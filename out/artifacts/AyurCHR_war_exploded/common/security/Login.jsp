<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <title>Login</title>
    <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/dojo/1.7.1/dijit/themes/claro/claro.css"/>
    <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/dojo/1.7.1/dojox/widget/Portlet/Portlet.css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/dojo/1.7.1/dojo/dojo.js" djConfig="parseOnLoad:true"
            type="text/javascript"></script>
</head>
<body>

<form method="post" action="login">
    <div align="center">
        <table align="center">
            <tr>
                <td>
                    <h2>Login Authentication</h2>
                </td>
            </tr>
        </table>
        <table width="300px" align="center"
               style="border: 1px solid #000000; background-color: #efefef;">
            <tr>
                <td colspan=2></td>
            </tr>
            <tr>
                <td colspan=2></td>
            </tr>
            <tr>
                <td><b>UserID :</b></td>
                <td><input type="text" name="userName" value=""></td>
            </tr>
            <tr>
                <td><b>Password :</b></td>
                <td><input type="password" name="password" value=""></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="Submit" value="Submit"></td>
            </tr>
            <%
                if (request.getAttribute("errorString") != null) {
            %>
            <tr>
                <td colspan=2><font color="red"><%= request.getAttribute("errorString")%>
                </font></td>
            </tr>

            <%
                }
            %>
        </table>

        <%session.setAttribute("userName", null);%>
    </div>


    <script type="text/javascript">
        dojo.xhrGet({
            // The URL of the request
            url: "./common/security/setSessonNull.jsp",
            // Handle the result as JSON data
            handleAs: "text",preventCache: true,
            // The success handler
            load: function(data) {

            },
            // The error handler
            error: function() {

            }
        });
    </script>
</form>
</body>
</html>