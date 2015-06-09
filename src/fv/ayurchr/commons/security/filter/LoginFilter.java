package fv.ayurchr.commons.security.filter;

import fv.ayurchr.commons.SV;
import fv.ayurchr.commons.security.util.Constants;
import fv.ayurchr.commons.security.util.DAOUtility;
import fv.ayurchr.commons.security.util.EncryptionUtil;
import fv.ayurchr.commons.utils.LoggerUtils;
import fv.ayurchr.dbobjects.hibernate.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet Filter implementation class LoginFilter.
 * This filter is to validate session. If found invalid then redirect user to Login page.
 *
 * @author jrawal
 */
public class LoginFilter implements Filter {
    private static Logger LOGGER = LoggerUtils.getLogger();

    /**
     * Default constructor.
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    private static HashMap<String, Long> LoggedInUsers = new HashMap<String, Long>(SV.LoginCapacity);

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */

    private void forwardToLogin(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
        httpRequest.getRequestDispatcher(SV.secuirity_page).forward(httpRequest, httpResponse);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        String userName = "";

        try {
            //If request is initial request, then check if it is Login Request.
            if (!(session == null || session.getAttribute("userName") == null)) {
                //Validate session by verifying the security token
                if (isValidUserSession(session)) {
                    if (httpRequest.getParameter("logout") != null && httpRequest.getParameter("logout").equals("Y")) {
                        LOGGER.log(Level.INFO, "User Logout.");
                        session.invalidate();
                        httpRequest.getRequestDispatcher(SV.secuirity_page).forward(httpRequest, httpResponse);
                    } else {
                        chain.doFilter(request, response);
                    }
                }
            } else {
                LOGGER.log(Level.INFO, "Invalid Session");
                if (null != request.getParameter("userName")) {
                    userName = request.getParameter("userName");
                    LOGGER.log(Level.INFO, "User Name = '" + userName + "'");
                }
                //If it is Login request, then validate user credentials and populate session.
                if (isInitialLoginRequest(httpRequest)) {
                    LOGGER.log(Level.INFO, "Initial Login Request for User Name='" + userName + "'");
                    if (isUserAuthentified(httpRequest)) {
                        LOGGER.log(Level.INFO, "Successful Authentication: User Name='" + userName + "'");
                        User loggedInUser = DAOUtility.getLoggedInUser(userName);  
                        long time = System.currentTimeMillis();
                        session.setAttribute(Constants.USER_SESSION_OBJ, loggedInUser);
                        session.setAttribute("userName_Time", time);
                        session.setAttribute("userName", userName);
                        LoggedInUsers.put(userName, time);
                        session.setAttribute("token", EncryptionUtil.encryptString(userName, SV.ENCRYPT_ALGORITHM));
                        chain.doFilter(request, response);
                    } else {
                        httpRequest.getRequestDispatcher(SV.secuirity_page).forward(httpRequest, httpResponse);
                    }
                } else {
                    LOGGER.log(Level.WARNING, "Forwarding to LoginPage");
                    forwardToLogin(httpRequest, httpResponse);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            httpRequest.setAttribute("errorString", e.getMessage());
            //httpRequest.getRequestDispatcher(SV.secuirity_page).forward(httpRequest, httpResponse);
        }

    }

    /**
     * Check if User credentials provided are correct.
     *
     * @param httpRequest
     * @return true if user credentials are valid.
     * @throws Exception
     */
    private boolean isUserAuthentified(HttpServletRequest httpRequest) throws Exception {
        String password = DAOUtility.getUserPassword(httpRequest.getParameter("userName"));
        String requestPassword = httpRequest.getParameter("password");
        if ((EncryptionUtil.encryptString(requestPassword, SV.ENCRYPT_ALGORITHM)).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param session
     * @return
     * @throws Exception
     */
    private boolean isValidUserSession(HttpSession session) throws Exception {
        Object userName = session.getAttribute("userName");
        Object token = session.getAttribute("token");

        if (null != userName && null != token) {
            if (EncryptionUtil.encryptString(userName.toString(), SV.ENCRYPT_ALGORITHM).equals(token.toString())) {
                Object time = session.getAttribute("userName_Time");
                LOGGER.log(Level.INFO, "Session Variable = '" + time + "'");
                LOGGER.log(Level.INFO, "Local   Variable = '" + LoggedInUsers.get(userName) + "'");
                if (null != time && LoggedInUsers.containsKey(userName) && time.equals(LoggedInUsers.get(userName))) {
                    LOGGER.log(Level.INFO, "Valid Session");
                    return true;
                } else {
                    LOGGER.log(Level.INFO, "Invalid Session");
                }
            }

        }
        throw new Exception("Warning: Authentication Credentials Required!");
    }


    /**
     * Checks if this request is Login Request.
     *
     * @param httpRequest
     * @return
     */
    private boolean isInitialLoginRequest(HttpServletRequest httpRequest) {
        if (httpRequest.getParameter("userName") != null &&
                httpRequest.getParameter("password") != null
                ) {
            return true;
        }
        return false;
    }


    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}
