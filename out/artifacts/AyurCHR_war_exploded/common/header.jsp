<%--
  Created by IntelliJ IDEA.
  User: rpatel
  Date: 15/4/11
  Time: 10:46 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <%@page import="fv.ayurchr.commons.security.util.Constants" %>
    <html>

    <head>
        <title>Ayur Centralized Health Records and Electronic Medical Records</title>

        <jsp:include page="common/header/includeJS.jsp"/>
        <jsp:include page="common/header/includeCSS.jsp"/>

        <script type="text/javascript">
            dojo.require("dijit.Tooltip");
            dojo.require("dijit.form.ValidationTextBox");
            dojo.require("dijit.layout.ContentPane");
            dojo.require("dijit.layout.BorderContainer");
            dojo.require("dijit.layout.TabContainer");
            dojo.require("dijit.layout.AccordionContainer");
            dojo.require("dijit.form.Form");
            dojo.require("dijit.form.Button");
            dojo.require("dijit.TitlePane");
            dojo.require("dijit.MenuBar");
            dojo.require("dijit.PopupMenuBarItem");
            dojo.require("dijit.DropDownMenu");
            dojo.require("dijit.MenuItem");
            dojo.require('dijit.form.DateTextBox');

        </script>
        <script type="text/javascript">
            var displaybody = function () {
                dojo.byId("coverdiv").style.display = 'none';
            };
            dojo.addOnLoad(displaybody);
        </script>
        <%--<script>
            dojo.require("dojox.widget.Portlet");
            dojo.require("dojox.widget.FeedPortlet");
            dojo.require("dijit.dijit");
        </script>--%>
    </head>
    <body class="claro" id='mainbody'>
    <div id='coverdiv' style='width:100%;height:100%'>Please Wait!</div>
    <%@include file="./header/menu.jsp" %>
