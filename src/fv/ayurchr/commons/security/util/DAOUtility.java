package fv.ayurchr.commons.security.util;

import fv.ayurchr.commons.HibernateSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import fv.ayurchr.dbobjects.hibernate.IncidenceAttribsView;
import fv.ayurchr.dbobjects.hibernate.User;

import java.util.HashMap;
import java.util.List;

public class DAOUtility {
    private static final SessionFactory sessionFactory;
    private static final HashMap userMap;

    public static SessionFactory getSessionfactory() {
        return sessionFactory;
    }

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();

        userMap = new HashMap();
        userMap.put("user", "W6ph5Mm5Pz8GgiULbPgzG37mj9g="); //password
        userMap.put("user1", "44rSFJQ9qtHWTBAvrsKd5K/p2j0="); //password1
        userMap.put("user2", "KqYKj/f81HPTIeAUav2eJt85UUc="); //password2
        userMap.put("user3", "ERnP037iRzV+A0oI2ETuol9v0g8="); //password3
    }


    /**
     * Real method to get User details from database.
     *
     * @param userName
     * @return
     */
    public static String getLoginDetails(String userName) {
        Transaction tx = null;
        Session session = getSessionfactory().openSession();
        tx = session.beginTransaction();
        String SQL_QUERY = " from Login ";
        Query query = session.createQuery(SQL_QUERY);
        return null;
    }


    /**
     * It's a dummy method to get User password.
     *
     * @param userName for which password needs to be fetched.
     * @return password
     * @throws Exception if userId not exist.
     */
    public static String getDummyUserPassword(String userName) throws Exception {
        if (userMap.containsKey(userName)) {
            return userMap.get(userName).toString();
        } else {
            throw new Exception("UserID does not exist: <b>" + userName + "</b>");
        }
    }
    
    /**
     * 
     * @param userName
     * @return
     * @throws Exception
     */
    public static String getUserPassword(String userName) throws Exception 
    {
        HibernateSession hs = new HibernateSession();

    	List<User> userList = hs.getList("AUTH_USER","LOGINID",userName);
    	if(userList.size() == 1)
    	{
	    	User user = userList.get(0);
	    	return user.getPassword();
    	}
    	else
    	{
            throw new Exception("UserID does not exist: <b>" + userName + "</b>");
    	}
      
    }
    
    /**
     * 
     * @param userName
     * @return User Object of logged in User based on UserName
     * @throws Exception
     */
    public static User getLoggedInUser(String userName) throws Exception 
    {
        HibernateSession hs = new HibernateSession();

    	List<User> userList = hs.getList("USER","LOGINID",userName);
    	if(userList.size() == 1)
    	{
	    	User user = userList.get(0);
	    	return user;
    	}
    	else
    	{
            throw new Exception("UserID does not exist: <b>" + userName + "</b>");
    	}
      
    }
    
    public static IncidenceAttribsView getIncidenceObject(String incidenceType, long incidenceTypeId)
    {
        HibernateSession hs = new HibernateSession();

    	List<IncidenceAttribsView> listInc = hs.getList("INCIDENCEATTRIBSVIEW", "Id", String.valueOf(incidenceTypeId));
    	
    	for(IncidenceAttribsView inc : listInc)
    	{
    		if(inc.getAttributeType().indexOf(incidenceType) >= 0)
			{
    			return inc;
			}
    	}
    	return null;
    }
}
