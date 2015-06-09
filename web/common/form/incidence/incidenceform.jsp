<%@page import="java.util.Set"%>
<%@page import="fv.ayurchr.commons.security.util.Constants"%>
<%@page import="java.util.TreeMap"%>
<%@page import="fv.ayurchr.commons.taglib.html.ComboBox" %>
<%@ page import="fv.ayurchr.commons.taglib.html.FORM" %>
<%@ page import="javax.swing.text.InternationalFormatter" %>
<%@ page import="fv.ayurchr.commons.taglib.html.TextBox" %>
<script type="text/javascript">
    dojo.require("dijit.TitlePane");

    require([
        "dojo/ready", "dojo/store/Memory", "dijit/form/FilteringSelect"
    ], function(ready, Memory, FilteringSelect) {
        loadIncidenceAttributes(FilteringSelect, Memory);
    });
    
    var incidencePrint = {};
</script>

<div style="min-height: 300px;max-height: 400px; overflow-y: scroll;">

    &nbsp;&nbsp;
    <div style="float: left;">
        <label for='Temperature'>Temp(&deg;F)</label><br/>
        <input style="width:100px;margin-right:10px;" dojoType='dijit.form.NumberTextBox'
               type="text" name="Temperature" id="Temperature" value=""/>
    </div>
    &nbsp;&nbsp;
    <div style="float:left;">
        <label for="BloodPressure">BP/Pulse</label><br/>
        <input style="width:100px;margin-right:10px;" dojoType='dijit.form.ValidationTextBox'
               type="text" name="BloodPressure" id="BloodPressure" value=""/>
    </div>
    &nbsp;&nbsp;

    <div style="float: left;">
        <label for='Weight'>Weight(kg)</label><br/>
        <input style="width:100px;margin-right:10px;" dojoType='dijit.form.NumberTextBox'
               type="text" name="Weight" id="Weight" value=""/>
    </div>
    &nbsp;&nbsp;
    <div style="float:left;">
        <label for="Height">Height(cms)</label><br/>
        <input style="width:100px;margin-right:10px;" dojoType='dijit.form.NumberTextBox'
               type="text" name="Height" id="Height" value=""/>
    </div>
    <br/><br/><br/>

    <div style="float: left;">
        <label for='ProblemId_1'>Problem</label><br/>
        <input id="ProblemId_1">
    </div>
    &nbsp;&nbsp;
    <div style="float:left;">
        <label for="Since_1">Since</label><br/>
        <input id="Since_1">
    </div>
    <br/><br/><br/>

    <div style="float: left;">
        <label for='ProblemId_2'>Problem</label><br/>
        <input id="ProblemId_2">
    </div>
    &nbsp;&nbsp;
    <div style="float:left;">
        <label for="Since_2">Since</label><br/>
        <input id="Since_2">
    </div>
    <br/><br/><br/>
    <!--
    <div style="float: left;">
        <label for='ProblemId_3'>Problem</label><br/>
        <input id="ProblemId_3">
    </div>
    &nbsp;&nbsp;
    <div style="float:left;">
        <label for="Since_3">Since</label><br/>
        <input id="Since_3">
    </div>
    <br/><br/><br/>

    <div style="float: left;">
        <label for='ProblemId_4'>Problem</label><br/>
        <input id="ProblemId_4">
    </div>
    &nbsp;&nbsp;
    <div style="float:left;">
        <label for="Since_4">Since</label><br/>
        <input id="Since_4">
    </div>
    <br/><br/><br/>

    <div style="float: left;">
        <label for='ProblemId_5'>Problem</label><br/>
        <input id="ProblemId_5">
    </div>
    &nbsp;&nbsp;
    <div style="float:left;">
        <label for="Since_5">Since</label><br/>
        <input id="Since_5">
    </div>
    <br/><br/><br/>
     -->
    <div style="float: left;">
        <label for='SymptomId_1'>Symptom</label><br/>
        <input id="SymptomId_1">
    </div>
    &nbsp;&nbsp;
    <div style="float:left;">
        <label for="SymptomId_2">Symptom</label><br/>
        <input id="SymptomId_2">
    </div>
    <br/><br/><br/>

    <!--<div style="float: left;">
        <label for='SymptomId_3'>Symptom</label><br/>
        <input id="SymptomId_3">
    </div>
    &nbsp;&nbsp;
    <div style="float:left;">
        <label for="SymptomId_4">Symptom</label><br/>
        <input id="SymptomId_4">
    </div>
    <br/><br/><br/>
     -->
    <div style="float: left;">
        <label for='DiagnosisId_1'>Diagnosis</label><br/>
        <input id="DiagnosisId_1">
    </div>
    &nbsp;&nbsp;
    <div style="float:left;">
        <label for="DiagnosisId_2">Diagnosis</label><br/>
        <input id="DiagnosisId_2">
    </div>
    <br/><br/><br/>

    <!--
   <div style="float: left;">
       <label for='DiagnosisId_3'>Diagnosis</label><br/>
       <input id="DiagnosisId_3">
   </div>
   &nbsp;&nbsp;
   <div style="float:left;">
       <label for="DiagnosisId_4">Diagnosis</label><br/>
       <input id="DiagnosisId_4">
   </div>
   <br/><br/><br/>
    -->
	<input type="hidden" name="TimeId_1" id="TimeId_1" value="" />
    <div style="float: left;">
        <label for='MedicationId_1'>Medication</label><br/>
        <input id="MedicationId_1">
    </div>
    &nbsp;&nbsp;
    <div style="float:left;">
        <label for='TimeId_10'>Time</label><br/>
        <span title="Before Breakfast" >
			<input id="TimeId_10" name="TimeId_10" type="checkbox" 
				onChange="fv.common.incidence.setTimeParameter('TimeId_1',this)" title="Before Breakfast" value="91" />BB
		</span>
		<span title="Before Lunch"  >
			<input id="TimeId_12" name="TimeId_12" type="checkbox" 
				onChange="fv.common.incidence.setTimeParameter('TimeId_1',this)" value="93" />BL
		</span>
		<span  title="Before Dinner" >
			<input id="TimeId_14" name="TimeId_14" type="checkbox" 
				onChange="fv.common.incidence.setTimeParameter('TimeId_1',this)" value="95" />BD
		</span>
		<br/>
		<span title="After Breakfast"  >
			<input id="TimeId_11" name="TimeId_11" type="checkbox" 
				onChange="fv.common.incidence.setTimeParameter('TimeId_1',this)" value="92" />AB
		</span>
		<span title="After Lunch"  >
			<input id="TimeId_13" name="TimeId_13" type="checkbox" 
				onChange="fv.common.incidence.setTimeParameter('TimeId_1',this)" value="94" />AL
		</span>
		<span title="After Dinner"  >
			<input id="TimeId_15" name="TimeId_15" type="checkbox" 
				onChange="fv.common.incidence.setTimeParameter('TimeId_1',this)" value="96" />AD
		</span>
		<span data-dojo-type="dijit.form.Button" id='Time1Button'>
   			<img src="<%=request.getContextPath()%>/images/add-icon.png" width="16" height="16" title="Add More">
		    	<script type="dojo/method" data-dojo-event="onClick" data-dojo-args="evt">
                        require(["dijit/registry"], function(registry){
							registry.byId("timeDialog1").show();
                        });
                </script>
		</span>
		
		<div id="timeDialog1" data-dojo-type="dijit.Dialog" data-dojo-id="dojoTimeDialog1" title="Medication Time" style="width:440px;">
			<div class="dijitDialogPaneContentArea">
		        <table>
		            <tr>	
        		        <td>
       		        		<select id="TimeId_16" multiple="true" name="TimeId_16" data-dojo-type="dojox.form.CheckedMultiSelect">
					        	<%
					        	 	TreeMap<String, String> sortedTimeMap = new TreeMap<String, String>(Constants.TAKEATTIME_VALUES_MAP);
						            Set<String> timeSet = sortedTimeMap.keySet();
						            for(String timeKey : timeSet)
						            {
						            	if(Integer.parseInt(timeKey) < 90 )
						            	{
						            	%>
						            	<option value="<%=timeKey%>"><%=Constants.TAKEATTIME_VALUES_MAP.get(timeKey)%></option>
						            	<%
						            	}
						            }
					        	%>
				        	</select>
        		        </td>
            		</tr>
           		</table>
			</div>
		  	<div class="dijitDialogPaneActionBar">
		        <button data-dojo-type="dijit.form.Button" type="button" onClick="fv.common.incidence.setMultiTimeParameter('TimeId_1', 'TimeId_16');dojoTimeDialog1.hide()">
		            <img src="<%=request.getContextPath()%>/images/tick.png" width="16" height="16" title="Submit">
		        </button>
		         <button data-dojo-type="dijit.form.Button" type="button" onClick="dojoTimeDialog1.reset()">
		            <img src="<%=request.getContextPath()%>/images/refresh.png" width="16" height="16" title="Reset">
		        </button>
		         <button data-dojo-type="dijit.form.Button" type="button" onClick="dojoTimeDialog1.hide()">
		            <img src="<%=request.getContextPath()%>/images/Close.png" width="16" height="16" title="Cancel">
		        </button>
		    </div>
		</div>
    </div>
    <br/><br/><br/><br/>
    
   	<input type="hidden" name="TimeId_2" id="TimeId_2" value="" />
    <div style="float: left;">
        <label for='MedicationId_2'>Medication</label><br/>
        <input id="MedicationId_2">
    </div>
    &nbsp;&nbsp;
    <div style="float:left;">
        <label for='TimeId_20'>Time</label><br/>
        <span title="Before Breakfast" >
			<input id="TimeId_20" name="TimeId_10" type="checkbox" 
				onChange="fv.common.incidence.setTimeParameter('TimeId_2', this)" value="91" />BB
		</span>
		<span title="Before Lunch"  >
			<input id="TimeId_22" name="TimeId_12" type="checkbox" 
				onChange="fv.common.incidence.setTimeParameter('TimeId_2', this)" value="93" />BL
		</span>
		<span title="Before Dinner"  >
			<input id="TimeId_24" name="TimeId_14" type="checkbox" 
				onChange="fv.common.incidence.setTimeParameter('TimeId_2',this)" value="95" />BD
		</span>
		<br/>
		<span title="After Breakfast" >
			<input id="TimeId_21" name="TimeId_11" type="checkbox" 
				onChange="fv.common.incidence.setTimeParameter('TimeId_2', this)"  value="92" />AB
		</span>
		
		<span title="After Lunch"  >
			<input id="TimeId_23" name="TimeId_13" type="checkbox" 
				onChange="fv.common.incidence.setTimeParameter('TimeId_2', this)" value="94" />AL
		</span>
		
		<span title="After Dinner"  >
			<input id="TimeId_25" name="TimeId_15" type="checkbox" 
				onChange="fv.common.incidence.setTimeParameter('TimeId_2',this)" value="96" />AD
		</span>
		<span data-dojo-type="dijit.form.Button" id='Time2Button'>
  			<img src="<%=request.getContextPath()%>/images/add-icon.png" width="16" height="16" title="Add More">
			    <script type="dojo/method" data-dojo-event="onClick" data-dojo-args="evt">
                        require(["dijit/registry"], function(registry){
							registry.byId("timeDialog2").show();
                        });
                </script>
		</span>
		
		<div id="timeDialog2" data-dojo-type="dijit.Dialog" data-dojo-id="dojoTimeDialog2" title="Medication Time" style="width:440px;">
	        <div class="dijitDialogPaneContentArea">
		        <table>
		            <tr>	
        		        <td>
       		        		<select id="TimeId_26" multiple="true" name="TimeId_26" data-dojo-type="dojox.form.CheckedMultiSelect">
					        	<%
					        	 	sortedTimeMap = new TreeMap<String, String>(Constants.TAKEATTIME_VALUES_MAP);
						            timeSet = sortedTimeMap.keySet();
						            for(String timeKey : timeSet)
						            {
						            	if(Integer.parseInt(timeKey) < 90 )
						            	{
						            	%>
						            	<option value="<%=timeKey%>"><%=Constants.TAKEATTIME_VALUES_MAP.get(timeKey)%></option>
						            	<%
						            	}
						            }
					        	%>
				        	</select>
        		        </td>
            		</tr>
           		</table>
			</div>
		  	<div class="dijitDialogPaneActionBar">
		        <button data-dojo-type="dijit.form.Button" type="button" onClick="fv.common.incidence.setMultiTimeParameter('TimeId_2', 'TimeId_26');dojoTimeDialog2.hide()">
		            <img src="<%=request.getContextPath()%>/images/tick.png" width="16" height="16" title="Submit">
		        </button>
		         <button data-dojo-type="dijit.form.Button" type="button" onClick="dojoTimeDialog2.reset()">
		            <img src="<%=request.getContextPath()%>/images/refresh.png" width="16" height="16" title="Reset">
		        </button>
		         <button data-dojo-type="dijit.form.Button" type="button" onClick="dojoTimeDialog2.hide()">
		            <img src="<%=request.getContextPath()%>/images/Close.png" width="16" height="16" title="Cancel">
		        </button>
		    </div>
		</div>
    </div>
    <br/><br/><br/>
    
    <div style="float:left;">
        <label for="Comment">Comments</label><br/>
        <textarea id="Comment" name="Comment" data-dojo-type="dijit.form.SimpleTextarea" rows="4" cols="50"
                  style="width:auto;"></textarea>
    </div>
    <br/><br/><br/><br/><br/>
    <div style="float:left;">
       <ul>
       	<li>BB : Before Breakfast</li>
       	<li>AB : After Breakfast</li>
       	<li>BL : Before Lunch</li>
       	<li>AL : After Lunch</li>
       	<li>BB : Before Dinner</li>
       	<li>AD : After Dinner</li>
       </ul>
    </div>

</div>
