<%@ page import="fv.ayurchr.commons.HibernateSession" %>
<%@ page import="java.util.List" %>
<%
    String EntityName = request.getParameter("EntityName");
    String FilterValue = request.getParameter("FilterValue");
    String FilterName = request.getParameter("FilterName");
    HibernateSession hs = new HibernateSession();
    List list = hs.getList(EntityName, FilterName, FilterValue);
    Object obj = new Object();
    if (list.size() > 0) {
        obj = list.get(0);
    } else
        obj = null;


%>