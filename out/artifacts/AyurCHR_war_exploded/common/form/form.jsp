<%@ page import="fv.ayurchr.commons.FormAttributes" %>
<%@ page import="fv.ayurchr.commons.SaveForm" %>
<%@ page import="fv.ayurchr.commons.taglib.html.FORM" %>
<%@ page import="fv.ayurchr.dbobjects.hibernate.Incidence" %>
<%
    Class CLASS_1 = Incidence.class;
    String ENTITY_1 = Incidence.ENTITY;
%>
<%
    if ("true".equals(request.getParameter("submitfIncidence"))) {
        FORM iFORM = new FORM(out); //Form instance which will be used across the page rendering
        FormAttributes FA = new FormAttributes(); // Attributes o the orm which will be used or form rendering
        FA.setCLASS(CLASS_1);
        FA.setEntity(ENTITY_1);
        Object FormObj = CLASS_1.newInstance();
        if (null == request.getParameter("IncidenceId") 
        		|| "".equals(request.getParameter("IncidenceId")) 
        		|| "null".equals(request.getParameter("IncidenceId"))) {
            FA.setISNEW(true);
            FA.setAction(FormAttributes.ADD);
        } else {
            long l_id = -1;
            try {
                l_id = Long.valueOf(request.getParameter("IncidenceId"));
            } catch (Exception e) {
            }
            FA.setId(l_id);
            FormObj = FORM.getFormValue(FA.getId(), ENTITY_1);
        }

        session.setAttribute(FORM.ATTRIBUTES, FA);
        long l = System.currentTimeMillis();
        SaveForm.saveForm(request, session);
        System.out.println("Time Taken = " + (System.currentTimeMillis() - l) / 1000);
    } else {
%>
<form dojoType="dijit.form.Form" id="AyurCHRIncidenceForm" jsId="AyurCHRIncidenceForm" action="" method="POST">
    <script type="dojo/method" event="onReset">
        return confirm('Press OK to reset widget values');
    </script>

    <script type="dojo/method" event="onSubmit">
        dojo.stopEvent(event);
        if (this.validate())
        {
        	if(confirm('Do you want to update records?'))
        	{
        		submitfIncidence.value='true';
        		UserId.value = dojo.byId('PatientId').value.trim();
        		postForm(this.id);
		        window.location.href = "<%=request.getContextPath()%>/index.jsp?display_page=incidence";
       		}
        }
        else
        {
        	alert('Form contains invalid data. Please correct first');
        }
		return false;
    </script>
    <input type='hidden' name='submitfIncidence' id='submitfIncidence' value="false"/>
    <input type='hidden' name='UserId' id='UserId' value="0"/>
    <input type='hidden' name='IncidenceId' id='IncidenceId' value="<%=incidenceId%>" />
    <input type='hidden' name='PatientIdSub' id='PatientIdSub' value="<%=patientId%>"/>

    <div style="width: 100%; text-align: left;">
        <label for="AppointmentDate">Next Visit: </label>
        <input style="width:150px;margin-right:10px;" dojoType='dijit.form.DateTextBox'
               type="text" name="AppointmentDate" id="AppointmentDate" value=""/>
        <button dojoType="dijit.form.Button" type="submit" name="submitButton"  id="submitButton"
                value="Save">
            Save
        </button>
		<%if(incidenceId != null) { %>
			<button dojoType="dijit.form.Button" onclick="dojoPrintDialog2.show()" type="print">Print</button>
			<div id="printDialog2" data-dojo-type="dijit.Dialog" data-dojo-id="dojoPrintDialog2" title="Print Mode" style="width:440px;">
		        <div class="dijitDialogPaneContentArea">
			        <table>
			        	<tr>
			        		<td><input type="radio" name="PrMode" id="PrMode" checked value="0"/></td>
			        		<td>Print only prescription</td>
			        	</tr>
			        	<tr>
			        		<td><input type="radio" name="PrMode" id="PrMode" value="1"/></td>
			        		<td>Print full report</td>
			        	</tr>
			        </table>
				</div>
				<div class="dijitDialogPaneActionBar">
			        <button data-dojo-type="dijit.form.Button" type="button" onClick="fv.common.incidence.printIncidence();dojoPrintDialog2.hide()">
			            <img src="<%=request.getContextPath()%>/images/tick.png" width="16" height="16" title="Print">
			        </button>
				<button data-dojo-type="dijit.form.Button" type="button"
					onClick="dojoPrintDialog2.hide()">
					<img src="<%=request.getContextPath()%>/images/Close.png"
						width="16" height="16" title="Cancel">
				</button>
			</div>
			</div>
		<%} %>
		<button dojoType="dijit.form.Button" type="reset">Reset</button>
	</div>
    <br/><br/>
    <%@include file="incidence/incidenceform.jsp" %>
</form>

<%}%>