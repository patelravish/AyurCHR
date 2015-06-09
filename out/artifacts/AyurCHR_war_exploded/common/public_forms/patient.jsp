<%@ page import="fv.ayurchr.dbobjects.hibernate.User" %>
<%@ page import="org.dom4j.Document" %>
<%@ page import="org.dom4j.Element" %>
<%@ page import="org.dom4j.io.SAXReader" %>
<%@ page import="java.io.File" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="fv.ayurchr.dbobjects.hibernate.Incidence" %>
<%@ page import="fv.ayurchr.commons.XMLUtilities" %>
<%@ page import="fv.ayurchr.dbobjects.hibernate.Patient" %>
<%
    Class CLASS = Patient.class;
    String ENTITY = Patient.ENTITY;
%>

<%@include file="/common/form/form_header.jsp" %>

<%

    Patient u = (Patient) FormObj;
    ArrayList<HashMap> FieldList = new ArrayList<HashMap>();

    FieldList = XMLUtilities.getFieldList(request.getRealPath("/common/public_forms/form_xml/patient.xml"));

    iFORM.print(FieldList);
%>


<%@include file="/common/form/form_footer.jsp" %>
<%}%>