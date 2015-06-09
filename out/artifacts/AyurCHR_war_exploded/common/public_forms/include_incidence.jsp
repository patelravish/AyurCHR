<script type="text/javascript" src="./js/incidence.js"></script>
<script type="text/javascript">
    var connectButton = function() {
        dojo.connect(dojo.byId('PatientId'), 'onblur', getPatientInfo);
        if(dojo.byId('PatientId') != "")
        {
        	getPatientInfo();
        }
    };
    dojo.addOnLoad(connectButton);
</script>
<style type="text/css">
    #timeDialog1_underlay {
        background-color:grey;
    }
    
     #timeDialog2_underlay {
        background-color:grey;
    }
    
    #printDialog2_underlay {
        background-color:grey;
    }
</style>
<%
String patientId = request.getParameter("PatientIdSub");
String incidenceId = request.getParameter("IncidenceId");
// set patient only when incidence is set
patientId = incidenceId != null && !"".equals(incidenceId) && !"null".equals(incidenceId) && patientId != null ? patientId : "";
%>

<div dojoType="dijit.layout.BorderContainer" gutters="true" style='width:1050px;' id="borderContainerTwo"
     liveSplitters="false" style="overflow-x:visible;">
    <div dojoType="dijit.layout.ContentPane" region="top" splitter="false" style="max-width:1050px!important;">
        <input type='text' id='PatientId' name='PatientId' value='<%=patientId%>' dojoType='dijit.form.ValidationTextBox'
               required='true' style='width:120px' tabindex="-1"/>
        <button type='button' id='patientbutton' dojoType='dijit.form.Button' value='Go' tabindex="-1">Go
        </button>
    </div>

    <div dojoType="dijit.layout.BorderContainer" minSize="20" style="max-width: 250px;!important" gutters="true"
         id="leftAccordion" region="center" splitter="false">

    </div>
    <!-- end AccordionContainer -->
    <div dojoType="dijit.layout.BorderContainer" region="leading" style="width:800px;margin: 0px!important;"
         gutters="true">
        <div dojoType="dijit.layout.BorderContainer" region="top" splitter="false" style="height:50px;">

            <div dojoType="dijit.layout.ContentPane" region="center" splitter="false">
                <div id='Name' style='float:left;font-weight: bold;font-size: 150%;'></div>

            </div>
        </div>
        <div dojoType="dijit.layout.ContentPane" region="top" splitter="false" gutters="true"
             style="min-height: 300px;">
            <%@include file="../../common/form/form.jsp" %>
        </div>
    </div>
    <!-- end TabContainer -->
</div>