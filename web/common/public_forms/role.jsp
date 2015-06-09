<%@ page import="fv.ayurchr.dbobjects.hibernate.Role" %>
<%@ page import="java.sql.Date" %>

<%
    Class CLASS = Role.class;
    String ENTITY = Role.ENTITY;
%>

<%@include file="/common/form/form_header.jsp" %>

<%

    Role role = (Role) FormObj;
%>

<%
    TextBox RoleName = new TextBox("Role Name", "RoleName");
    RoleName.setRequired(true);
    iFORM.printTextBox(RoleName);

    DateBox DB = new DateBox("Test Date", "DateBox");
    DB.setValue(Date.valueOf("2011-05-30"));
    DB.setRequired(true);
    iFORM.printDateBox(DB);

    NumberBox NB = new NumberBox("Test Number", "Number");
    NB.setValue(500);
    NB.setRange(-50, 550000000);
    iFORM.printNumBox(NB);
%>

<%@include file="/common/form/form_footer.jsp" %>