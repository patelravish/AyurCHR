<%@ page import="fv.ayurchr.commons.utils.Utils" %>
<%@ page import="fv.ayurchr.dbobjects.hibernate.Incidence" %>
<%@ page import="fv.ayurchr.commons.HibernateSession" %>
<%@ page import="java.util.List" %>
<%@ page import="net.sf.json.JSONObject" %>
<%!


    public String getToolTipText(Incidence i, int id) {
        String incidence = "<div dojo.dijitTooltip {max-width: 50em;} dojoType='dijit.Tooltip' connectId='" + id + "' position='before'>\n" +
                " <inc>" +
                Utils.getDisplayDate(i.getIncidenceDate()) +
                "</inc><br/>" +
                "&#187; " + i.getProblem_1() + ", " + i.getProblem_2() /*+ ", " + i.getProblem_3() + ", " + i.getProblem_4() + ", " + i.getProblem_5()*/ + ".<br/>" +
                "&#187; " + i.getSymptom_1() + ", " + i.getSymptom_2() /*+ ", " + i.getDiagnosis_3() + ", " + i.getDiagnosis_4() + ", " + i.getDiagnosis_5()*/ + ", " + i.getDiagnosis_5() +
                "&#187; " + i.getDiagnosis_1() + ", " + i.getDiagnosis_2() /*+ ", " + i.getDiagnosis_3() + ", " + i.getDiagnosis_4() + ", " + i.getDiagnosis_5()*/ + ", " + i.getDiagnosis_5() +
                "&#187; " + i.getMedication_1() + ", " + i.getMedication_2() /*+ ", " + i.getDiagnosis_3() + ", " + i.getDiagnosis_4() + ", " + i.getDiagnosis_5()*/ + ", " + i.getDiagnosis_5() +
                "&#187; " + i.getComment() +
                "</div>";
        return incidence;
    }

    public String getDisplayString(String s) {
        //String DisplayString = "";
        if (null == s || "".equals(s.trim()))
            return "";
        else
            return ", " + s;
    }
%>

<%
    JSONObject jsonObject = new JSONObject();
    String PatientId = request.getParameter("PatientId");
    HibernateSession hs = new HibernateSession();
    List li = hs.getList("INCIDENCE", "UserId", PatientId, "INCIDENCEDATE DESC");

    Incidence inc;
    jsonObject.put("Size", li.size());
    for (int k = 0; k < li.size(); k++) {
        inc = (Incidence) li.get(k);
        jsonObject.put("IncidenceId_" + k, inc.getId());
        jsonObject.put("Date_" + k, Utils.getDisplayDate(inc.getIncidenceDate()));
        jsonObject.put("Problem_" + k, getDisplayString(inc.getProblem_1()) + getDisplayString(inc.getProblem_2()));
        jsonObject.put("Symptom_" + k, getDisplayString(inc.getSymptom_1()) + getDisplayString(inc.getSymptom_2()));
        jsonObject.put("Diagnosis_" + k, inc.getDiagnosis_1() + getDisplayString(inc.getDiagnosis_2()));
        jsonObject.put("Medication_" + k, inc.getMedication_1() + getDisplayString(inc.getMedication_2()));
        jsonObject.put("Comments_" + k, getDisplayString(inc.getComment()));
    }
    out.println(jsonObject);
%>