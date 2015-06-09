<%@page import="fv.ayurchr.commons.security.util.Constants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.lang.reflect.Field"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="fv.ayurchr.commons.HibernateSession"%>
<%@page import="fv.ayurchr.dbobjects.hibernate.User"%>
<%@ page import="fv.ayurchr.dbobjects.hibernate.Patient" %>
<%@ page import="net.sf.json.JSONObject" %>
<%
    String userId = request.getParameter("UserId");
	User user = null;
	if(userId != null)
	{
	    HibernateSession hs = new HibernateSession();
		user = (User)hs.getEntity("USER", Long.parseLong(userId));
		JSONObject jsonObject = new JSONObject();
	 	if (user != null) 
	 	{
	 		Method methods[] = User.class.getMethods();
            for (int i = 0; i < methods.length; i++) {
            	String methodName = methods[i].getName();
                if (methodName.startsWith("get")) 
                {
                    Class returnType = methods[i].getReturnType();
                    Object value = methods[i].invoke(user);
                	String variableName = methodName.substring(3);

                   	if (Date.class.getName().equals(returnType.getName()) && value != null)
                    {
                    	SimpleDateFormat sdf = new SimpleDateFormat(Constants.USER_DATE_FORMAT);
                    	value = sdf.format(value);
                    }
                	jsonObject.put(variableName, value != null ? value : "");
                }
            }
	 	}

	 	out.print(jsonObject);
	}
%>