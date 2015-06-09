<%@page import="fv.ayurchr.dbobjects.hibernate.User" %>
<%@ page import="fv.ayurchr.dbobjects.hibernate.Patient" %>
<%@ page import="net.sf.json.JSONObject" %>
<%@ page import="fv.ayurchr.commons.utils.Utils" %>
<%@include file="/common/websrevice.jsp" %>
<%
    JSONObject jsonObject = new JSONObject();

    if (null != obj) {
        User user = (User) obj;
        jsonObject.put("Name", user.getFirstName() + " " + user.getLastName());
        jsonObject.put("Address", user.getAddress_Street());
        jsonObject.put("Identification", user.getIdentification());
        jsonObject.put("PatientId", user.getId());
        jsonObject.put("DOB", Utils.getDisplayDate(user.getDateOfBirth()));
        jsonObject.put("hasData", "true");
    } else {
        jsonObject.put("hasData", "false");
    }


    out.print(jsonObject);
%>