package fv.ayurchr.commons;

import fv.ayurchr.commons.security.util.Constants;
import fv.ayurchr.commons.taglib.html.FORM;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/**
 * Created by Ravish Patel.
 * fv.ayurchr.dbobjects.hibernate.User: ravish
 * Date: 1/5/11
 * Time: 2:17 PM
 */
public class SaveForm {
    public static Object saveForm(HttpServletRequest request, HttpSession session) throws Exception

    {
        fv.ayurchr.commons.HibernateSession hs = new fv.ayurchr.commons.HibernateSession();
        try {

            HashMap m = (HashMap) request.getParameterMap();
            FormAttributes FA = (FormAttributes) session.getAttribute(FORM.ATTRIBUTES);
            //           session.removeAttribute(fv.ayurchr.commons.taglib.html.FORM.ATTRIBUTES);
            Class clas = FA.getCLASS();

            Object objInstance = clas.newInstance();
            Method methods[] = clas.getMethods();
            String methodName;
            String variableName;
            for (int i = 0; i < methods.length; i++) {
                methodName = methods[i].getName();
                variableName = methodName.substring(3);
                if (methodName.startsWith("set") && m.containsKey(variableName)) {
                    Class parType = methods[i].getParameterTypes()[0];
                    
                    String value  = null;
                    if(((String[]) m.get(variableName)).length > 1)
                    {
                    	// handling done for multi select type of elements
                    	if (String.class.getName().equals(parType.getName()))
                    	{
                    		value = Arrays.toString((String[]) m.get(variableName));
                    		value = value.substring(1, value.length() - 1); // removing square brackets on either side
                    		value = value.replaceAll("\\s+", "");
                    	}
                    }
                    
                	value = value != null ? value : ((String[]) m.get(variableName))[0];
                    
                    if (String.class.getName().equals(parType.getName()))
                        methods[i].invoke(objInstance, String.valueOf(value));
                    else if ("long".equals(parType.getName()))
                        methods[i].invoke(objInstance, Long.valueOf(value));
                    else if (Date.class.getName().equals(parType.getName()))
                    {
                    	SimpleDateFormat sdf = new SimpleDateFormat(Constants.USER_DATE_FORMAT);
                    	Date date = sdf.parse(String.valueOf(value));
                        methods[i].invoke(objInstance, date);
                    }
                }
            }
            if (null != FA.getId()) {
                clas.getMethod("setId", Long.TYPE).invoke(objInstance, FA.getId());
                hs.update(FA.getEntity(), objInstance);
            } else {
                hs.save(FA.getEntity(), objInstance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
