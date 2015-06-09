<%@page import="fv.ayurchr.commons.SaveForm" %>
<%@page import="fv.ayurchr.commons.taglib.html.FORM" %>
<%@page import="fv.ayurchr.commons.FormAttributes" %>
<%@ page import="fv.ayurchr.dbobjects.hibernate.User" %>
<%@ page import="org.dom4j.Document" %>
<%@ page import="org.dom4j.Element" %>
<%@ page import="org.dom4j.io.SAXReader" %>
<%@ page import="java.io.File" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="fv.ayurchr.commons.XMLUtilities" %>
<%
    Class CLASS = User.class;
    String ENTITY = User.ENTITY;
    String userType = request.getParameter("userType");
    String submitType = request.getParameter("SubmitF");
    if (submitType != null) {
        if ("true".equals(submitType)) {
            FormAttributes FA = new FormAttributes(); // Attributes o the orm which will be used or form rendering
            FA.setCLASS(CLASS);
            FA.setEntity(ENTITY);
            Object FormObj = CLASS.newInstance();
            if (request.getParameter("UserId") == null || "".equals(request.getParameter("UserId"))) {
                FA.setISNEW(true);
                FA.setAction(FormAttributes.ADD);
            } else {
                long l_id = Long.valueOf(request.getParameter("UserId"));
                FA.setId(l_id);
                FormObj = FORM.getFormValue(FA.getId(), ENTITY);
            }
            session.setAttribute(FORM.ATTRIBUTES, FA);
            SaveForm.saveForm(request, session);
        }
    }
%>
<%@ include file="/common/list/userlist.jsp" %>
<br/>

<form dojoType="dijit.form.Form" id="UserForm" jsId="UserForm" action="" method="POST">
    <br/>

    <div id="editUserDiv" style="display:none;float: left;clear: left">

        <div style="float: left;">
            <label for='FirstName'>First Name</label><br/>
            <input style="width:200px;margin-right:10px;" dojoType='dijit.form.ValidationTextBox' required='true'
                   type="text" name="FirstName" id="FirstName" value=""/>
        </div>
        &nbsp;&nbsp;
        <div style="float:left;">
            <label for="MiddleName">Middle Name</label><br/>
            <input style="width:200px;margin-right:10px;" dojoType='dijit.form.ValidationTextBox' required='true'
                   type="text" name="MiddleName" id="MiddleName" value=""/></td>
        </div>
        &nbsp;&nbsp;
        <div style="float:left;">
            <label for="LastName">Last Name</label><br/>
            <input style="width:200px;margin-right:10px;" dojoType='dijit.form.ValidationTextBox' required='true'
                   type="text" name="LastName" id="LastName" value=""/>
        </div>
        <br/><br/><br/>

        <div style="float:left;">
            <label for="DateOfBirth">Birth Date</label><br/>
            <input style="width:200px;margin-right:10px;" dojoType='dijit.form.DateTextBox' required='true' type="text"
                   name="DateOfBirth" id="DateOfBirth" value=""/>
        </div>
        &nbsp;&nbsp;
        <div style="float:left;">
            <label for="Identification">Birth Mark</label><br/>
            <input style="width:200px;margin-right:10px;" dojoType='dijit.form.ValidationTextBox' required='true'
                   type="text" name="Identification" id="Identification" value=""/>
        </div>
        &nbsp;&nbsp;
        <div style="float:left;">
            <label for="PhoneNumber_Emergency">Emergency Phone No.:</label><br/>
            <input style="width:200px;margin-right:10px;" type="text" dojoType='dijit.form.ValidationTextBox'
                   required='true' name="PhoneNumber_Emergency" id="PhoneNumber_Emergency" value=""/>
        </div>
        <br/><br/><br/>

        <div style="float:left;">
            <label for="Address_HouseNo">House No.:</label><br/>
            <input style="width:200px;margin-right:10px;" type="text" dojoType='dijit.form.ValidationTextBox'
                   required='true' name="Address_HouseNo" id="Address_HouseNo" value=""/>
        </div>
        <div style="float:left;">
            <label for="Address_Community">Community:</label><br/>
            <input style="width:200px;margin-right:10px;" type="text" dojoType='dijit.form.ValidationTextBox'
                   required='true' name="Address_Community" id="Address_Community" value=""/>
        </div>
        <div style="float:left;">
            <label for="Address_Street">Street</label><br/>
            <input style="width:200px;margin-right:10px;" type="text" dojoType='dijit.form.ValidationTextBox'
                   required='true' name="Address_Street" id="Address_Street" value=""/>
        </div>
        <br/><br/><br/>

        <div style="float:left;">
            <label for="Address_City">City:</label><br/>
            <input style="width:200px;margin-right:10px;" type="text" dojoType='dijit.form.ValidationTextBox'
                   required='true' name="Address_City" id="Address_City" value=""/>
        </div>
        <div style="float:left;">
            <label for="Address_District">District</label><br/>
            <input style="width:200px;margin-right:10px;" type="text" dojoType='dijit.form.ValidationTextBox'
                   required='true' name="Address_District" id="Address_District" value=""/>
        </div>
        <div style="float:left;">
            <label for="Address_State">State</label><br/>
            <input style="width:200px;margin-right:10px;" type="text" dojoType='dijit.form.ValidationTextBox'
                   required='true' name="Address_State" id="Address_State" value=""/>
        </div>
        <br/><br/><br/>

        <div style="float:left;">
            <label for="Address_PinCode">Pincode:</label><br/>
            <input style="width:200px;margin-right:10px;" type="text" dojoType='dijit.form.ValidationTextBox'
                   required='true' name="Address_PinCode" id="Address_PinCode" value=""/>
        </div>
        <div style="float:left;">
            <label for="Address_Country">Country:</label><br/>
            <input style="width:200px;margin-right:10px;" type="text" dojoType='dijit.form.ValidationTextBox'
                   required='true' name="Address_Country" id="Address_Country" value=""/>
        </div>
        <div style="float:left;">
            <label for="PhoneNumber">Phone No.:</label><br/>
            <input style="width:200px;margin-right:10px;" type="text" dojoType='dijit.form.ValidationTextBox'
                   required='true' name="PhoneNumber" id="PhoneNumber" value=""/>
        </div>
        <input type="hidden" id="RoleId" name="RoleId" value="6"/>
        <input type="hidden" id="UserId" name="UserId" value=""/>
        <input type="hidden" id="SubmitF" name="SubmitF" value=""/>

        <button dojoType="dijit.form.Button" type="button" name="submitButton"
                value="Save" onclick="fv.common.user.submitUserForm()">
            Save
        </button>

        <!-- 	<button dojoType="dijit.form.Button" type="Delete" name="submitButton" -->
        <!-- 	        value="Delete"> -->
        <!-- 	    Delete -->
        <!-- 	</button> -->

        <button dojoType="dijit.form.Button" type="reset">
            Reset
        </button>
    </div>
</form>
<br>

<div data-dojo-type="dijit.layout.TabContainer" doLayout="false" id="UserDetailTabs" style='visibility:hidden;;'>
    <div data-dojo-type="dijit.layout.ContentPane" title="Patient Visits" selected="true">
        <div minSize="20" style="width:700px;" id="incidenceList"></div>
    </div>
    <div data-dojo-type="dijit.layout.ContentPane" title="Allergies">
        <div style="height:200px;width:700px;overflow-y:visible" id="allergyList"></div>
    </div>
    <div data-dojo-type="dijit.layout.ContentPane" title="Vaccinations">
        <div style="height:200px;width:700px" id="vaccineList"></div>
    </div>
</div>

