\<%@ page import="fv.ayurchr.dbobjects.hibernate.Symptom" %>

<%
    Class CLASS = Symptom.class;
    String ENTITY = Symptom.ENTITY;
%>

<%@include file="/common/form/form_header.jsp" %>

<%

    Symptom symptom = (Symptom) FormObj;
%>

<%
    iFORM.printTextBox("Description", 300, true, "Description", symptom.getDescription(), "");
%>

<%@include file="/common/form/form_footer.jsp" %>
<%}%>