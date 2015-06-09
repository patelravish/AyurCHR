<%@page import="fv.ayurchr.commons.security.util.Constants" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="fv.ayurchr.dbobjects.hibernate.User" %>
<%@page import="java.util.List" %>
<%@page import="fv.ayurchr.commons.HibernateSession" %>

<style>
    #grid {
        width: 55em;
        height: 10em;
    }
    #allergyGrid {
        width: 55em;
        height: 10em;
    }
</style>

<%
    HibernateSession hs = new HibernateSession();
    List<User> userList = hs.getList("USER", -1);
    SimpleDateFormat sdf = new SimpleDateFormat(Constants.USER_DATE_FORMAT);
%>
<script>

    dojo.require("dojo.parser");
    dojo.require("dijit.Dialog");
    dojo.require("dijit.form.Button");
    dojo.require("dijit.form.Form");
    dojo.require("dijit.form.TextBox");
    dojo.require("dijit.form.DateTextBox");
    dojo.require("dijit.form.Textarea");
    dojo.require("dojox.grid.DataGrid");
    dojo.require("dojo.data.ItemFileWriteStore");

    var printJson = [];
    var grid;
    dojo.ready(function() {
        /*set up data store*/
        var data = {
            identifier: 'ID',
            items: []
        };
        var data_list = [
            <%for(User user: userList )
            {
            %>
            {
                ID : "<%=user.getId()%>",
                FirstName: "<%=user.getFirstName()%>",
                MiddleName: "<%=user.getMiddleName() != null ? user.getMiddleName() : ""%>",
                LastName: "<%=user.getLastName()%>",
                Identification: "<%=user.getIdentification() != null ? user.getIdentification() : ""%>",
                DateOfBirth : "<%=user.getDateOfBirth() != null ? sdf.format(user.getDateOfBirth()) : ""%>"
            }
            <%
                  if(userList.indexOf(user) != userList.size() - 1)
                  {%>
            ,
            <%}
            }%>
        ];


        for (var i = 0; i < data_list.length; i++) {
            data.items.push(data_list[i]);
        }

        var store = new dojo.data.ItemFileWriteStore({data: data});

        renderUserList(store);
    });
</script>
<div style="float: left;display: block;overflow-y:visible;">
    <table>
        <tr>
            <td>
                <p>
                    <input type="text" name="firstNameFltr" id='firstNameFltr'/>
				<span data-dojo-type="dijit.form.Button" id='NameFilter' >
				    Filter by Name
				    <script type="dojo/method" data-dojo-event="onClick" data-dojo-args="evt">
                        dojo.byId("gridDiv").style.display = 'block';
                        dojo.byId("UserDetailTabs").style.visibility = 'hidden';
                        dojo.byId("editUserDiv").style.display = 'none';

						if(dojo.byId("firstNameFltr").value != "")
						{
                        	grid.filter({FirstName: '*' + dojo.byId("firstNameFltr").value + '*'});
						}
                    </script>
				</span>
					
				<span data-dojo-type="dijit.form.Button" id='IdFilter'>
				    Filter by Id
				    <script type="dojo/method" data-dojo-event="onClick" data-dojo-args="evt">
                        dojo.byId("gridDiv").style.display = 'block';
						if(dojo.byId("firstNameFltr").value != "")
						{                        
							grid.filter({ID: dojo.byId("firstNameFltr").value + '*'});
						}
                    </script>
				</span>
				<span data-dojo-type="dijit.form.Button" id='CreatePatient' >
    				Create Patient
				    <script type="dojo/method" data-dojo-event="onClick" data-dojo-args="evt">
                        fv.common.user.getUserCreate();
                    </script>
				</span>
				<span data-dojo-type="dijit.form.Button" id='AllergyButton'>
    				Add Allergy
				    <script type="dojo/method" data-dojo-event="onClick" data-dojo-args="evt">
                        require(["dijit/registry"], function(registry){
							if(dojo.byId("UserId").value == "") {
								alert("Please select a patient to add Allergies.");
							}
							else {
								registry.byId("dialogOne").show();
							}
                        });
                    </script>
				</span>
				<%--<span data-dojo-type="dijit.form.Button" id='IncidenceButton'>
    				Edit Visits
				    <script type="dojo/method" data-dojo-event="onClick" data-dojo-args="evt">
                        require(["dijit/registry"], function(registry){
							if(dojo.byId("UserId").value == "") {
								alert("Please select a patient to edit his/her visits.");
							}
							else {
								registry.byId("dialogTwo").show();
							}
                        });
                    </script>
				</span> --%>
				<span data-dojo-type="dijit.form.Button" id='PrintButton'>
    				Print
				    <script type="dojo/method" data-dojo-event="onClick" data-dojo-args="evt">
                        require(["dijit/registry"], function(registry){
							if(dojo.byId("UserId").value == "") {
								alert("Please select a patient to Print details.");
							}
							else {
								fv.common.user.printUserDetails();
							}
                        });
                    </script>
				</span>
                    <%@include file="../../common/form/allergy/Allergy.jsp" %>
                    <%--<%@include file="../../common/form/incidence/editIncidence.jsp" %> --%>
                </p>
                <div id="gridDiv">
                </div>
            </td>
        </tr>
    </table>
</div>