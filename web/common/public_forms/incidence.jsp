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
<%
    Class CLASS = Incidence.class;
    String ENTITY = Incidence.ENTITY;
%>

<%@include file="/common/form/form_header.jsp" %>
<%
	String incidenceId = request.getParameter("incidenceId"); 
    Incidence incidence = (Incidence)FORM.getFormValue(Long.parseLong(incidenceId), Incidence.class.getName());
    ArrayList<HashMap> FieldList = new ArrayList<HashMap>();

    FieldList = XMLUtilities.getFieldList(request.getRealPath("/common/public_forms/form_xml/patient_incidence.xml"));
    iFORM.print(FieldList);
%>
<script type="text/javascript">
    var getPatientInfo = function() {
        if ('' != dojo.byId('PatientId').value.trim())
            dojo.xhrGet({
                // The URL of the request
                url: "/common/websrevice/getPatient.jsp?EntityName=Patient&FilterName=PatientId&FilterValue=" + dojo.byId(PatientId).value,
                // Handle the result as JSON data
                handleAs: "json",
                // The success handler
                load: function(jsonData) {
                    if ("false" == jsonData.hasData) {
                        dojo.require("dijit.Dialog");
                        var secondDlg = new dijit.Dialog({
                            title: "No Patient Found",
                            content: "No Patient found with the PatientId" + dojo.byId("PatientId"),
                            style: "width: 500px; height:100px;",
                            onCancel :function() {
                                //dojo.byId('PatientId').select();
                            }
                        });
                        secondDlg.show();
                    }
                    else {
                        dojo.byId("FirstName").value = jsonData.FirstName;
                        dojo.byId("Identification").value = jsonData.Identification;
                        dojo.byId("LastName").value = jsonData.LastName;
                    }
                },
                // The error handler
                error: function() {
                    dojo.byId("newsContainerNode").innerHTML = "News is not available at this time."
                }
            });
    }

    dojo.addOnLoad(function () {
        dojo.connect(dojo.byId(PatientId), 'onblur', getPatientInfo)
    });
</script>
<%@include file="/common/form/form_footer.jsp" %>
<%}
%>