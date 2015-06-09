dojo.provide("fv.common.incidence");

fv.common.incidence.editIncidence = function(arg) {
	
    var incidenceId = this.id.substring(10, this.id.length)

    dojo.byId("IncidenceId").value = incidenceId;
    
    dojo.byId("AyurCHRIncidenceForm").submit();
    
}

fv.common.incidence.incidenceAttribs = {};


fv.common.incidence.setMultiTimeParameter = function(parentEl, chkElId) {
	
	var selectedVals = dijit.byId(chkElId).get("value");
	for(var i = 0; i < selectedVals.length; i++ ) {
		
		if(dojo.byId(parentEl).value == "") {
			dojo.byId(parentEl).value = selectedVals[i];
		}
		else {
			dojo.byId(parentEl).value = dojo.byId(parentEl).value + "," + selectedVals[i];
		}
	}
};


fv.common.incidence.setTimeParameter = function(parentEl, chkEl) {
	
	if(chkEl.checked == true){
		if(dojo.byId(parentEl).value == "") {
			dojo.byId(parentEl).value = chkEl.value
		}
		else {
			dojo.byId(parentEl).value = dojo.byId(parentEl).value + "," + chkEl.value
		}
	}
	else {
		var parentElVal = dojo.byId(parentEl).value;
		parentElVal = parentElVal.replace("," + chkEl.value, "");
		parentElVal = parentElVal.replace(chkEl.value + ",", "");
		parentElVal = parentElVal.replace(chkEl.value, "");
		dojo.byId(parentEl).value = parentElVal; 
	}
};


fv.common.incidence.loadFields = function(FilteringSelect, Memory) {

	var isDisabled = fv.common.incidence.incidenceAttribs.DISABLED || "N";
    var FIELDS_NUM = 2;
    var problemStore = new Memory({data : fv.common.incidence.incidenceAttribs.PROBLEM});
    for (var j = 1; j <= FIELDS_NUM; j++) {
    	
        var problemValue = fv.common.incidence.incidenceAttribs["PROBLEM_"+ j + "_VALUE"];
        new FilteringSelect({
            id: "ProblemId_" + j,
            name: "ProblemId_" + j,
            style: "width:200px;margin-right:10px;",
            autoComplete: false,
            value: problemValue || "-1",
            store: problemStore,
            queryExpr: "*${0}*",
            searchAttr: "name"
        }, "ProblemId_" + j);
        
        if(isDisabled == "Y")
    	{
        	dijit.byId("ProblemId_" + j).setDisabled(true);
    	}
        
        incidencePrint["problem" + j] = dijit.byId("ProblemId_" + j).attr('displayedValue');
    }
    

    var sinceStore = new Memory({data : fv.common.incidence.incidenceAttribs.SINCE});
    for (var k = 1; k <= FIELDS_NUM; k++) {

        var sinceValue = fv.common.incidence.incidenceAttribs["SINCE_"+ k + "_VALUE"];
        new FilteringSelect({
            id: "Since_" + k,
            name: "Since_" + k,
            style: "width:200px;margin-right:10px;",
            autoComplete: false,
            value: sinceValue || "-1",
            store: sinceStore,
            queryExpr: "*${0}*",
            searchAttr: "name"
        }, "Since_" + k);
        
        if(isDisabled == "Y")
    	{
        	dijit.byId("Since_" + k).setDisabled(true);
    	}
        incidencePrint["since" + k] = dijit.byId("Since_" + k).attr('displayedValue');
    }

    var symptomStore = new Memory({data : fv.common.incidence.incidenceAttribs.SYMPTOM});
    for (var l = 1; l <= FIELDS_NUM; l++) {

        var symptomValue = fv.common.incidence.incidenceAttribs["SYMPTOM_"+ l + "_VALUE"];
        new FilteringSelect({
            id: "SymptomId_" + l,
            name: "SymptomId_" + l,
            style: "width:200px;margin-right:10px;",
            autoComplete: false,
            value: symptomValue || "-1",
            store: symptomStore,
            queryExpr: "*${0}*",
            searchAttr: "name"
        }, "SymptomId_" + l);
        
        if(isDisabled == "Y")
    	{
        	dijit.byId("SymptomId_" + l).setDisabled(true);
    	}
        incidencePrint["symptom" + l] = dijit.byId("SymptomId_" + l).attr('displayedValue');
    }

    var diagnosisStore = new Memory({data : fv.common.incidence.incidenceAttribs.DIAGNOSIS});
    for (var m = 1; m <= FIELDS_NUM; m++) {

        var diagnosisValue = fv.common.incidence.incidenceAttribs["DIAGNOSIS_"+ m + "_VALUE"];
        new FilteringSelect({
            id: "DiagnosisId_" + m,
            name: "DiagnosisId_" + m,
            style: "width:200px;margin-right:10px;",
            autoComplete: false,
            value: diagnosisValue || "-1",
            store: diagnosisStore,
            queryExpr: "*${0}*",
            searchAttr: "name"
        }, "DiagnosisId_" + m);
        
        if(isDisabled == "Y")
    	{
        	dijit.byId("DiagnosisId_" + m).setDisabled(true);
    	}
        incidencePrint["diagnosis" + m] = dijit.byId("DiagnosisId_" + m).attr('displayedValue');
    }

    var medicationStore = new Memory({data : fv.common.incidence.incidenceAttribs.MEDICATION});
    for (var n = 1; n <= FIELDS_NUM; n++) {

        var medicationValue = fv.common.incidence.incidenceAttribs["MEDICATION_"+ n + "_VALUE"];
        new FilteringSelect({
            id: "MedicationId_" + n,
            name: "MedicationId_" + n,
            style: "width:200px;margin-right:10px;",
            autoComplete: false,
            value: medicationValue || "-1",
            store: medicationStore,
            queryExpr: "*${0}*",
            searchAttr: "name"
        }, "MedicationId_" + n);
        
        if(isDisabled == "Y")
    	{
        	dijit.byId("MedicationId_" + n).setDisabled(true);
    	}
        incidencePrint["medication" + n] = dijit.byId("MedicationId_" + n).attr('displayedValue');
    }
    
    for (var n = 1; n <= FIELDS_NUM; n++) {
	  
    	var timeValue = fv.common.incidence.incidenceAttribs["TIME_"+ n + "_VALUE"];
	  
    	if(timeValue != null && timeValue != undefined){

    		dojo.byId("TimeId_" + n).value = timeValue;
    		for(var m = 0; m < 6; m++){
			  
    			var chkEl = dojo.byId("TimeId_" + n + m);
    			if(timeValue.indexOf(chkEl.value) >= 0){
    				chkEl.checked = true;
    			}
    		}
    	}
    	
    	incidencePrint["time" + n] = dojo.byId("TimeId_" + n).value;
    }
    var timeStore = fv.common.incidence.incidenceAttribs.TAKEATTIME ;
    for (var n = 1; n <= FIELDS_NUM; n++) {
        
        var timeValue = fv.common.incidence.incidenceAttribs["TIME_"+ n + "_VALUE"];
        if(timeValue != null && timeValue != undefined)
    	{
        	var valueArr = timeValue.split(",");
        	dijit.byId("TimeId_" + n + "6").set("value", valueArr);
    	}
        if(isDisabled == "Y")
    	{
        	dijit.byId("TimeId_" + n + "6").setDisabled(true);
    	}
    }
    
    dijit.byId("timeDialog1").hide();
    dijit.byId("timeDialog2").hide();

    dojo.byId("AppointmentDate").value = fv.common.incidence.incidenceAttribs["NEXT_VISIT"] || "";
    incidencePrint["AppointmentDate"] = dojo.byId("AppointmentDate").value;
    
    dojo.byId("Temperature").value = fv.common.incidence.incidenceAttribs["TEMPERATURE"] || "";
    incidencePrint["Temperature"] = dojo.byId("Temperature").value;
    
    dojo.byId("BloodPressure").value = fv.common.incidence.incidenceAttribs["BLOOD_PRESSURE"] || "";
    incidencePrint["BloodPressure"] = dojo.byId("BloodPressure").value;
    
    dojo.byId("Weight").value = fv.common.incidence.incidenceAttribs["WEIGHT"] || "";
    incidencePrint["Weight"] = dojo.byId("Weight").value;
    
    dojo.byId("Height").value = fv.common.incidence.incidenceAttribs["HEIGHT"] || "";
    incidencePrint["Height"] = dojo.byId("Height").value;
    
    dojo.byId("Comment").value = fv.common.incidence.incidenceAttribs["COMMENT"] || "";
    incidencePrint["Comment"] = dojo.byId("Comment").value;
    
    if(isDisabled == "Y")
	{
    	dijit.byId("AppointmentDate").setDisabled(true);
    	dijit.byId("Temperature").setDisabled(true);
    	dijit.byId("BloodPressure").setDisabled(true);
    	dijit.byId("Weight").setDisabled(true);
    	dijit.byId("Height").setDisabled(true);
    	dijit.byId("Comment").setDisabled(true);
    	dijit.byId("submitButton").setDisabled(true);
	}
    
};

var loadIncidenceAttributes = function(FilteringSelect, Memory) {

    dojo.xhrGet({

        url : "common/list/incidenceAttribsList.jsp?IncidenceId=" + dojo.byId("IncidenceId").value,

        handleAs : "json",

        load : function(jsonData) {

            fv.common.incidence.incidenceAttribs = eval(jsonData);

            fv.common.incidence.loadFields(FilteringSelect, Memory);

        },

        error : function() {
            alert("Could not load Incidence attributes like Problems/Symptoms.");
        }
    });

}

var getPatientInfo = function() {
    if ('' != dojo.byId('PatientId').value.trim())
    {
    	dojo.byId('PatientIdSub').value = dojo.byId('PatientId').value;  
        dojo.xhrGet({
            // The URL of the request
            url: "common/websrevice/getUser.jsp?EntityName=USER&FilterName=Id&FilterValue=" + dojo.byId(PatientId).value,
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
                    dojo.byId("Name").innerHTML = jsonData.Name;
                    new dijit.Tooltip({
                        connectId: ("Name"),
                        label:(
                            "<div class='incidence_tooltip'>" +
                                "<span class='tooltiplable'>" + jsonData.Name + " (" + jsonData.DOB + ")" + "</span>" +
                                "<br/><span class='tooltiplable'>" + jsonData.Identification + " (" + jsonData.DOB + ")" + "</span>" +
                                "<hr/>" +
                                "<div class='tooltip_address'>" +
                                "<span class='tooltip_lable'>Address:</span>" +
                                "<span class='tooltip_address_content'>" + jsonData.Address + "</span>" +

                                "</div>")

                    });
                }
            },
            // The error handler
            error: function() {
                dojo.byId("newsContainerNode").innerHTML = "News is not available at this time."
            }
        });
	    //dojo.byId('leftAccordion').innerHTML='';
	    for (var k = 0; k < 40; k++) {
	        try {
	            dijit.registry.byId('incidence_' + k).destroy();
	        }
	        catch(ex) {
	        }
	    }
	    dojo.xhrGet({
	        // The URL of the request
	        url: "common/websrevice/getIncidenceList.jsp?PatientId=" + dojo.byId(PatientId).value,
	        // Handle the result as JSON data
	        handleAs: "json",preventCache: true,
	        // The success handler
	        load: function(jsonData) {
	            if (jsonData && jsonData.Size != 0) {
	                //dojo.byId('leftAccordion').innerHTML = data;
	                // var k = "1";
	                var size = jsonData.Size;
	                //dojo.attr(dojo.byId("incidenceList"), "innerHTML", "");
	                for (var k = 0; k < size; k++) {
	                    var incidenceId = jsonData["IncidenceId_" + k];
	
	                    dojo.create("div", {id: ("incidence_" + incidenceId)}, "leftAccordion");
	                    new dijit.layout.ContentPane({
	                        content: jsonData["Date_" + k],
	                        style:'display:block;'
	                    }, ("incidence_" + incidenceId));
	                    //dojo.attr(dojo.byId("incidence_" + k), "class", "incidence_list_right");
	                    dojo.connect(dojo.byId("incidence_" + incidenceId), 'onclick', fv.common.incidence.editIncidence);
	
	                    new dijit.Tooltip({
	                        connectId: ("incidence_" + incidenceId),
	                        label:(
	                            "<div class='incidence_tooltip'>" +
	                                "<span class='tooltiplable'>" + jsonData["Date_" + k] + "</span>" +
	                                "<hr/>" +
	                                "<div class='tooltip_problem'>" +
	                                "<span class='tooltip_lable'>Problem:</span>" +
	                                "<span class='tooltip_problem_content'>" + jsonData["Problem_" + k] + "</span>" +
	                                "</div>" +
	                                "<div class='tooltip_problem'>" +
	                                "<span class='tooltip_lable'>Symptom:</span>" +
	                                "<span class='tooltip_problem_content'>" + jsonData["Symptom_" + k] + "</span>" +
	                                "</div>" +
	                                "<div class='tooltip_problem'>" +
	                                "<span class='tooltip_lable'>Diagnosis:</span>" +
	                                "<span class='tooltip_problem_content'>" + jsonData["Diagnosis_" + k] + "</span>" +
	                                "</div>" +
	                                "<div class='tooltip_problem'>" +
	                                "<span class='tooltip_lable'>Medication:</span>" +
	                                "<span class='tooltip_problem_content'>" + jsonData["Medication_" + k] + "</span>" +
	                                "</div>" +
	                                "<div class='tooltip_problem'>" +
	                                "<span class='tooltip_lable'>Comments:</span>" +
	                                "<span class='tooltip_problem_content'>" + jsonData["Comments_" + k] + "</span>" +
	                                "</div>" +
	                                "</div>")
	
	                    });
	
	                }
	            }
	            else {
	                dojo.byId("incidenceList").innerHTML = "No Incidences Found."
	            }
	        },
	        // The error handler
	        error: function() {
	            dojo.byId("incidenceList").innerHTML = "No Incidences Found."
	        }
	    });
    }
}


fv.common.incidence.printIncidence = function() {
	
	 var detTbl = dojo.create("table")
	 var detTr;
	 
	 detTbl.appendChild(dojo.create("br"));
	 detTbl.appendChild(dojo.create("br"));
	 detTbl.appendChild(dojo.create("br"));
	 detTbl.appendChild(dojo.create("br"));
	 detTbl.appendChild(dojo.create("br"));
	 detTbl.appendChild(dojo.create("br"));
	 
	 detTr = dojo.create("tr");
	 detTr.appendChild(dojo.create("td")).innerHTML = "Name: ";
	 detTr.appendChild(dojo.create("td")).innerHTML = dojo.byId("Name").innerHTML;
	 detTbl.appendChild(detTr);
	 detTbl.appendChild(dojo.create("br"));
	 
	 detTr = dojo.create("tr");
	 detTr.appendChild(dojo.create("td")).innerHTML = "Temp(&deg;F): ";
	 detTr.appendChild(dojo.create("td")).innerHTML = incidencePrint["Temperature"] ;
	 detTbl.appendChild(detTr);
	 detTbl.appendChild(dojo.create("br"));
	 detTr = dojo.create("tr");
	 detTr.appendChild(dojo.create("td")).innerHTML = "BP/Pulse: ";
	 detTr.appendChild(dojo.create("td")).innerHTML = incidencePrint["BloodPressure"] ;
	 detTbl.appendChild(detTr);
	 detTbl.appendChild(dojo.create("br"));
	 detTr = dojo.create("tr");
	 detTr.appendChild(dojo.create("td")).innerHTML = "Weight(kg): ";
	 detTr.appendChild(dojo.create("td")).innerHTML = incidencePrint["Weight"] ;
	 detTbl.appendChild(detTr);
	 detTbl.appendChild(dojo.create("br"));
	 detTr = dojo.create("tr");
	 detTr.appendChild(dojo.create("td")).innerHTML = "Height(cms): ";
	 detTr.appendChild(dojo.create("td")).innerHTML = incidencePrint["Height"] ;
	 detTbl.appendChild(detTr);
	 detTbl.appendChild(dojo.create("br"));
	 
	 detTbl.appendChild(dojo.create("br"));

	 if(dojo.byId("PrMode").value == "1") {
		 
		 detTr = dojo.create("tr");
		 detTr.appendChild(dojo.create("td")).innerHTML = "Problems: ";
		 detTbl.appendChild(detTr);
		 detTbl.appendChild(dojo.create("br"));
		 
		 detTr = dojo.create("tr");
		 detTr.appendChild(dojo.create("td")).innerHTML = incidencePrint["problem1"] + " since " + incidencePrint["since1"] ;
		 if(incidencePrint["problem2"] != "") {
			 detTr.appendChild(dojo.create("td")).innerHTML = detTr.appendChild(dojo.create("td")).innerHTML + 
		 													"<br>"+ incidencePrint["problem2"] + " since " + incidencePrint["since2"] ;
		 }
		 detTbl.appendChild(detTr);
		 detTbl.appendChild(dojo.create("br"));
		 detTbl.appendChild(dojo.create("br"));
	
		 detTr = dojo.create("tr");
		 detTr.appendChild(dojo.create("td")).innerHTML = "Symptoms: ";
		 detTbl.appendChild(detTr);
		 detTbl.appendChild(dojo.create("br"));
	
		 detTr = dojo.create("tr");
		 detTr.appendChild(dojo.create("td")).innerHTML = incidencePrint["symptom1"] ;
		 if(incidencePrint["symptom2"] != "") {
			 detTr.appendChild(dojo.create("td")).innerHTML  = detTr.appendChild(dojo.create("td")).innerHTML  + ", "+ incidencePrint["symptom2"];
		 }
		 detTbl.appendChild(detTr);
		 detTbl.appendChild(dojo.create("br"));
		 detTbl.appendChild(dojo.create("br"));
	
		 
		 detTr = dojo.create("tr");
		 detTr.appendChild(dojo.create("td")).innerHTML = "Diagnosis: ";
		 detTbl.appendChild(detTr);
		 detTbl.appendChild(dojo.create("br"));
	
		 detTr = dojo.create("tr");
		 detTr.appendChild(dojo.create("td")).innerHTML = incidencePrint["diagnosis1"] + ", "+ incidencePrint["diagnosis2"];
		 detTbl.appendChild(detTr);
		 detTbl.appendChild(dojo.create("br"));
		 detTbl.appendChild(dojo.create("br"));
	 }
	 
	 var timeStore = fv.common.incidence.incidenceAttribs.TAKEATTIME ;
	 var timeValObj = {};
	 for(var k in timeStore)
	 {
    	var obj = timeStore[k];
    	timeValObj[obj.id] = obj.name;
	 }
	 
	 detTr = dojo.create("tr");
	 detTr.appendChild(dojo.create("td")).innerHTML = "Medication: ";
	 detTbl.appendChild(detTr);
	 detTbl.appendChild(dojo.create("br"));

	 var time1TD = incidencePrint["medication1"] + " Time: ";
	 var time1Arr = incidencePrint["time1"].split(",");
	 for(var i = 0; i < time1Arr.length; i++)
	 {
		 time1TD += i > 0 ? ", " : "";
		 time1TD += timeValObj[time1Arr[i]];
	 }
	 detTr = dojo.create("tr");
	 detTr.appendChild(dojo.create("td")).innerHTML = time1TD ;
	 detTbl.appendChild(detTr);
	 detTbl.appendChild(dojo.create("br"));

	 time1TD = incidencePrint["medication2"] + " Time: ";
	 time1Arr = incidencePrint["time2"].split(",");
	 for(var i = 0; i < time1Arr.length; i++)
	 {
		 time1TD += i > 0 ? ", " : "";
		 time1TD += timeValObj[time1Arr[i]];
	 }
	 detTr = dojo.create("tr");
	 detTr.appendChild(dojo.create("td")).innerHTML = time1TD;
	 detTbl.appendChild(detTr);
	 detTbl.appendChild(dojo.create("br"));
	 detTbl.appendChild(dojo.create("br"));
	 
	 detTr = dojo.create("tr");
	 detTr.appendChild(dojo.create("td")).innerHTML = "Next Visit: ";
	 detTr.appendChild(dojo.create("td")).innerHTML = incidencePrint["AppointmentDate"] ;
	 detTbl.appendChild(detTr);
	 detTbl.appendChild(dojo.create("br"));
	 detTbl.appendChild(dojo.create("br"));
	 
	 detTr = dojo.create("tr");
	 detTr.appendChild(dojo.create("td")).innerHTML = "Comments: ";
	 detTr.appendChild(dojo.create("td")).innerHTML = incidencePrint["Comment"] ;
	 detTbl.appendChild(detTr);
	 
	 
	 var mywindow = window.open('', 'my div', 'height=800,width=800');
     mywindow.document.write('<html><head><title> Patient Visit </title>');
     mywindow.document.write('<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/dojo/1.7.1/dijit/themes/claro/claro.css" type="text/css" />');
     mywindow.document.write('<link rel="stylesheet" href="css/dojo_custom.css" type="text/css" />');
     mywindow.document.write('</head><body >');
     mywindow.document.write(detTbl.innerHTML);
     mywindow.document.write('</body></html>');
     mywindow.document.close();
     mywindow.print();
     return true;
   
	

}	
