<%@page import="fv.ayurchr.commons.security.util.Constants" %>
<%
    String userName = (String) session.getAttribute("userName");
%>


<div data-dojo-type="dijit.MenuBar" id="navMenu">
    <div data-dojo-type="dijit.MenuBarItem" data-dojo-props="onClick:function(){fv.common.index.displayContent('')}">
        Home
    </div>
    <div data-dojo-type="dijit.MenuBarItem"
         data-dojo-props="onClick:function(){fv.common.index.displayContent('patient');}">
        Create/Update Patient
    </div>
    <div data-dojo-type="dijit.MenuBarItem"
         data-dojo-props="onClick:function(){fv.common.index.displayContent('incidence');}">
        Patient Visit
    </div>
    <div data-dojo-type="dijit.PopupMenuBarItem">
        <span><%="Welcome " + userName%></span>

        <div data-dojo-type="dijit.DropDownMenu" id="editMenu">
            <div data-dojo-type="dijit.MenuItem" data-dojo-props="onClick:function(){fv.common.user.logoutUser();}">
                Logout
            </div>
            <!--             <div data-dojo-type="dijit.MenuItem" data-dojo-props="onClick:function(){alert('edit 2');}">Edit #2</div> -->
        </div>
    </div>
</div>