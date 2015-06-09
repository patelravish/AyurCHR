package fv.ayurchr.commons;

import fv.ayurchr.commons.utils.LoggerUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Ravish Patel.
 * fv.ayurchr.dbobjects.hibernate.User: ravish
 * Date: 1/5/11
 * Time: 11:27 AM
 */
public class HibernateSession {
    private static Logger LOGGER = LoggerUtils.getLogger();
    private static SessionFactory sessionFactory = null;
    private Session session = null;

    private Session getHibernateSession() {
        if (null == sessionFactory)
            sessionFactory = new Configuration().configure().buildSessionFactory();
        if (null == session)
            session = sessionFactory.openSession();
        return session;
    }

    public long save(String entity, Object object) throws Exception {
        long key;
        Session hs = getHibernateSession();
        try {
            LOGGER.log(Level.INFO, object.toString());
            key = (Long) hs.save(entity, object);
        } catch (Exception e_Ex) {
            if (SV.isDev) {
                e_Ex.printStackTrace();
                //          throw new Exception("Error in Saving "+object.getClass());
            }
            return 0;
        } finally {
            close();
        }

        return key;
    }

    public boolean saveOrUpdate(Object object) throws Exception {
        Object o = null;
        Session hs = getHibernateSession();
        try {
            LOGGER.log(Level.INFO, object.toString());
            hs.saveOrUpdate(object);
        } catch (Exception e_Ex) {
            if (SV.isDev) {
                throw new Exception("Error in Saving " + object.getClass());
            }
            return false;
        } finally {
            close();
        }

        return true;
    }

    public boolean update(Object p_object) throws Exception {
        Session hs = getHibernateSession();
        try {
            //System.out.println(p_object.toString());
            hs.update(p_object);
        } catch (Exception e_Ex) {
            if (SV.isDev) {
                e_Ex.printStackTrace();
                //   throw new Exception("Error in Saving "+p_object.getClass());
            }
            return false;
        } finally {
            close();
        }

        return true;
    }

    public boolean update(String p_EntityName, Object p_object) throws Exception {
        Session hs = getHibernateSession();
        try {
            LOGGER.log(Level.INFO, p_object.toString());
            hs.update(p_EntityName, p_object);
        } catch (Exception e_Ex) {
            if (SV.isDev) {
                e_Ex.printStackTrace();
                // throw new Exception("Error in Saving "+p_object.getClass());
            }
            return false;
        } finally {
            close();
        }

        return true;
    }

    public boolean delete(String p_EntityName, Object p_object) throws Exception {
        Session hs = getHibernateSession();
        try {
            LOGGER.log(Level.INFO, p_object.toString());
            hs.delete(p_EntityName, p_object);
        } catch (Exception e_Ex) {
            if (SV.isDev) {
                e_Ex.printStackTrace();
                // throw new Exception("Error in Saving "+p_object.getClass());
            }
            return false;
        } finally {
        }

        return true;
    }

    public Object getEntity(String p_TableName, long p_Id) {
        Session hs = getHibernateSession();
        return hs.createQuery("from " + p_TableName + " where Id = " + p_Id).uniqueResult();
    }

    public List getList(String p_TableName, long p_Id) {
        Session hs = getHibernateSession();
        return hs.createQuery("from " + p_TableName + " where -1 = " + p_Id + " or Id = " + p_Id).list();
    }

    public List getList(String p_EntityName, String p_FilterVariableName, String p_FilterValue, String p_orderByClause) {
        Session hs = getHibernateSession();
        StringBuilder query = new StringBuilder();
        query.append("from ");
        query.append(p_EntityName);
        query.append(" where '' = '");
        query.append(p_FilterValue.trim());
        query.append("' or upper(");
        query.append(p_FilterVariableName);
        query.append(") like '%");
        query.append(p_FilterValue.toUpperCase());
        query.append("%'");
        if(p_orderByClause != null)
        {
        	query.append(" order by ");
        	query.append(p_orderByClause);
        }
        
        return hs.createQuery(query.toString()).list();
    }

    public List getList(String p_EntityName, String p_FilterVariableName, String p_FilterValue) {
        return getList(p_EntityName, p_FilterVariableName, p_FilterValue, null);
    }

    private void close() throws Exception {
        session.flush();
        session.connection().commit();
        session.close();
    }

    protected void finalize() throws Exception {
        close();
    }

}
