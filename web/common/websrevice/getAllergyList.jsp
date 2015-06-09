<%@page import="net.sf.json.JSONArray"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="fv.ayurchr.dbobjects.hibernate.Allergy"%>
<%@page import="fv.ayurchr.commons.security.util.Constants" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="fv.ayurchr.dbobjects.hibernate.User" %>
<%@page import="java.util.List" %>
<%@page import="fv.ayurchr.commons.HibernateSession" %>

<%
HibernateSession hs = new HibernateSession();
String userId = request.getParameter("PatientId");
List<Allergy> allergyList = hs.getList("ALLERGY", "USERID", userId, "ID DESC");
SimpleDateFormat sdf = new SimpleDateFormat(Constants.USER_DATE_FORMAT);
JSONArray allergyArr = new JSONArray();

for(Allergy allergy: allergyList )
{
	JSONObject allergyObj = new JSONObject();
	allergyObj.put("ID", allergy.getId());
	allergyObj.put("AllergyType", allergy.getAllergyType());
	allergyObj.put("Comments", allergy.getComments());
	allergyObj.put("StartDate", sdf.format(allergy.getStartDate()));
	allergyObj.put("EndDate", sdf.format(allergy.getEndDate()));
	allergyObj.put("Medication", allergy.getMedication());
	allergyObj.put("Reaction", allergy.getReaction());
	allergyObj.put("Severity", allergy.getSeverity());
	allergyObj.put("UserId", allergy.getUserId());
	allergyArr.add(allergyObj);
}

out.println(allergyArr);
%>