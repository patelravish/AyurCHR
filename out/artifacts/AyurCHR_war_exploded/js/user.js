dojo.provide("fv.common.user");

( function() {

    fv.common.user.handler = {

        userCreate : function() {
        }
    }
});


fv.common.user.logoutUser = function() {

    window.location = "common/security/LogOut.jsp";
}

var renderUserList = function(store) {

    /*set up layout*/
    var layout = [
        [
            {'name': 'ID', 'field': 'ID', 'width': '50px'},
            {'name': 'First Name', 'field': 'FirstName', 'width': '150px'},
            {'name': 'Middle Name', 'field': 'MiddleName', 'width': '150px'},
            {'name': 'Last Name', 'field': 'LastName', 'width': '150px'},
            {'name': 'Identification', 'field': 'Identification', 'width': '250px'},
            {'name': 'Date of Birth', 'field': 'DateOfBirth', 'width': '110px'}
        ]
    ];

    /*create a new grid:*/
    grid = new dojox.grid.DataGrid({
            id: 'grid',
            store: store,
            structure: layout,
            rowSelector: '20px'},
        document.createElement('div'));
    grid.queryOptions = {ignoreCase: true};

    /*append the new grid to the div*/
    dojo.byId("gridDiv").appendChild(grid.domNode);

    /*Call startup() to render the grid*/
    grid.startup();
    grid.filter({FirstName: 'jjjjjjjjjjjjj'}); // to show no records.

    dojo.connect(grid, "onRowClick", grid, function(evt) {
        var idx = evt.rowIndex, item = this.getItem(idx);

        //� get a value out of the item
        var patientId = this.store.getValue(item, "ID");

        fv.common.user.getUserEdit(patientId);


    });
}

fv.common.user.getUserCreate = function(userType) {

    dojo.byId("editUserDiv").style.display = 'block';

    dojo.byId("gridDiv").style.display = 'none';

    var nodeList = dojo.query("input[type='text']");

    for (var i in nodeList) {

        var node = nodeList[i];

        node.value = "";

    }

    dojo.byId("UserId").value = "";

    dojo.byId("incidenceList").innerHTML = "";

};

fv.common.user.loadIncidences = function(userId) {

    dojo.xhrGet({
        // The URL of the request
        url: "common/websrevice/getIncidenceList.jsp?PatientId=" + userId,
        // Handle the result as JSON data
        handleAs: "json",
        // The success handler
        load: function(jsonData) {
            if (jsonData && jsonData.Size != 0) {
                //dojo.byId('leftAccordion').innerHTML = data;
                // var k = "1";
                var size = jsonData.Size;
                dojo.attr(dojo.byId("incidenceList"), "innerHTML", "");
                for (var k = 0; k < size; k++) {
                    var incidenceId = jsonData["IncidenceId_" + k]
                    var node = dojo.create("div", {id: ("incidence_" + incidenceId)}, "incidenceList");
                    node.innerHTML =
                        "<hr/>" +
                            "<span class='tooltiplable'>" + jsonData["Date_" + k] + "</span>" +
                            "<div class='tooltip_problem'>" +
                            "<span class='tooltip_lable'>Problem:</span>" +
                            "<span class='tooltip_problem_content'>" + jsonData["Problem_" + k] + "</span>" +
                            "</div>" +
                            "<div class='tooltip_diagnosis'>" +
                            "<span class='tooltip_lable'>Diagnosis:</span> " +
                            "<span class='tooltip_diagnosis_content'>" + jsonData["Diagnosis_" + k] + "</span>";
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

};

fv.common.user.loadAllergies = function(userId) {

    dojo.xhrGet({

    	url: "common/websrevice/getAllergyList.jsp?PatientId=" + userId,
        
    	handleAs: "json",
        
    	load: function(jsonData) {
            if (jsonData && jsonData.length != 0) {
            	
            	dojo.ready(function(){
            		
                    var allergyData = {
                        identifier: 'ID',
                        items: jsonData
                    };
                   
                    var allergyStore = new dojo.data.ItemFileWriteStore({data: allergyData});

                    /*set up layout*/
                    var layout = [
                        [
                            {'name': 'Allergy Type', 'field': 'AllergyType', 'width': '10%'},
                            {'name': 'Reaction', 'field': 'Reaction', 'width': '13%'},
                            {'name': 'Severity', 'field': 'Severity', 'width': '13%'},
                            {'name': 'Medication', 'field': 'Medication', 'width': '13%'},
                            {'name': 'Start Date', 'field': 'StartDate', 'width': '8%'},
                            {'name': 'End Date', 'field': 'EndDate', 'width': '8%'}
                            //{'name': 'Comments', 'field': 'Comments', 'width': '250px'}
                        ]
                    ];
                    
                    if (dijit.byId('allergyGrid')) { 
                    
                    	(dijit.byId('allergyGrid')).destroyRecursive(); 
                    
                    } 
                    
                    dojo.attr(dojo.byId("allergyList"), "innerHTML", "");
                    
                    /*create a new grid:*/
                    var allergyGrid = new dojox.grid.DataGrid({
                            id: 'allergyGrid',
                            store: allergyStore,
                            structure: layout,
                            rowSelector: '20px'},
                        document.createElement('div'));

                    /*append the new grid to the div*/
                    dojo.byId("allergyList").appendChild(allergyGrid.domNode);

                    /*Call startup() to render the grid*/
                    allergyGrid.startup();
                   
            	});

            }
            else {
                
            	dojo.byId("allergyList").innerHTML = "No Allergies Found."

            }

    	},
        
        error: function() {
            dojo.byId("allergyList").innerHTML = "No Allergies Found."
        }
    });
    
};

fv.common.user.getUserEdit = function(userId) {

    dojo.byId("editUserDiv").style.display = 'block';
    
    dojo.byId("UserDetailTabs").style.visibility = 'visible';

    dojo.byId("gridDiv").style.display = 'none';

    dojo.xhrGet({

        // The URL of the request
        url: "common/public_forms/editUser.jsp?UserId=" + userId,

        // Handle the result as JSON data
        handleAs: "json",

        // The success handler
        load: function(jsonData) {

        	var printObj = {};  
        	
            var nodeList = dojo.query("input[type='text']");

            for (var i in nodeList) {

                var node = nodeList[i];

                var elementName = node.name;

                var value = jsonData[elementName];

                if (value) {

                    node.value = value;
                    
                    printObj[elementName] = value;

                }

            }

            nodeList = dojo.query("input[type='hidden']");

            for (var k in nodeList) {

                var node = nodeList[k];

                var elementName = node.name;

                var value = jsonData[elementName];

                if (value) {

                    node.value = value;
                    
                    printObj[elementName] = value;

                }

            }

            dojo.byId("DateOfBirth").value = jsonData.DateOfBirth;
            printObj["DateOfBirth"] = jsonData.DateOfBirth;
            printJson[0] = printObj;
            
            dojo.byId("UserId").value = jsonData.Id;
            dojo.byId("AllergyUserId").value = jsonData.Id;

            fv.common.user.loadAllergies(userId);
            fv.common.user.loadIncidences(userId);
            //fv.common.user.loadVaccinations(userId);
            
        } ,

        // The error handler
        error: function() {

            dojo.byId("contentDiv").innerHTML = "cannot edit user";

        }

    });
};

fv.common.user.resetUserForm = function() {

    var form = dojo.byId("AyurCHRForm");

    if (confirm('Press OK to reset widget values')) {

        form.reset();

    }

};

fv.common.user.submitUserForm = function() {

    var userForm = dojo.byId("UserForm");

    dojo.stopEvent(event);

    if (confirm('Do you want to update records?')) {

        dojo.byId("SubmitF").value = 'true';

        userForm.submit();
    }

};

fv.common.user.printUserDetails = function() {
	
	 var userDetails = printJson[0];
	 var detTbl = dojo.create("table")
	 var detTr;
	 
	 detTr = dojo.create("tr");
	 detTr.appendChild(dojo.create("td")).innerHTML = "Name: ";
	 detTr.appendChild(dojo.create("td")).innerHTML = userDetails["FirstName"] + " " + 
	 												  (userDetails["MiddleName"] ? userDetails["MiddleName"] : "") + " " + 
	 												  userDetails["LastName"];
	 detTbl.appendChild(detTr);
	 detTbl.appendChild(dojo.create("br"));
	 
	 detTr = dojo.create("tr");
	 detTr.appendChild(dojo.create("td")).innerHTML = "Date of Birth: ";
	 detTr.appendChild(dojo.create("td")).innerHTML = (userDetails["DateOfBirth"] ? userDetails["DateOfBirth"] : "");
	 detTbl.appendChild(detTr);
	 detTbl.appendChild(dojo.create("br"));
	 
	 detTr = dojo.create("tr");
	 detTr.appendChild(dojo.create("td")).innerHTML = "Phone: ";
	 detTr.appendChild(dojo.create("td")).innerHTML = (userDetails["PhoneNumber"] ? userDetails["PhoneNumber"] : "");
	 detTbl.appendChild(detTr);
	 detTbl.appendChild(dojo.create("br"));
	 
	 detTr = dojo.create("tr");
	 detTr.appendChild(dojo.create("td")).innerHTML = "Identification: ";
	 detTr.appendChild(dojo.create("td")).innerHTML = (userDetails["Identification"] ? userDetails["Identification"] : "");
	 detTbl.appendChild(detTr);
	 detTbl.appendChild(dojo.create("br"));
	 
	 
	 var incidences = dojo.byId('incidenceList'); 
	 var allergies = dojo.byId('allergyList');
	 
	 var tabs = dijit.byId("tabContainer");
	 
	 
	 var mywindow = window.open('', 'my div', 'height=800,width=800');
     mywindow.document.write('<html><head><title> Patient Report </title>');
     mywindow.document.write('<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/dojo/1.7.1/dijit/themes/claro/claro.css" type="text/css" />');
     mywindow.document.write('<link rel="stylesheet" href="css/dojo_custom.css" type="text/css" />');
     mywindow.document.write('<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/dojo/1.7.1/dojox/grid/resources/claroGrid.css" type="text/css" />');
     mywindow.document.write('</head><body >');
     mywindow.document.write(detTbl.innerHTML);
     mywindow.document.write(incidences.innerHTML);
     mywindow.document.write("<br>");
     mywindow.document.write(allergies.innerHTML);
     mywindow.document.write('</body></html>');
     mywindow.document.close();
     mywindow.print();
     return true;
   
	
};
