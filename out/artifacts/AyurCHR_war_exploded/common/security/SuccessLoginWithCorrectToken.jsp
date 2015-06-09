<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <title>SuccessLogin</title>
</head>
<body>
<form method="post" action="SuccessLogin.jsp">
    <table align="center">
        <tr>
            <td>
                <h2>Congratulations, Login Successfully done.</h2>
            </td>
        </tr>
    </table>
    <table width="500px" align="center"
           style="border: 1px solid #000000; background-color: #efefef;">
        <tr>
            <td width="200px"><b>Original token :</b>
            <td width="300px"><input size="50" name="realtoken" value="<%=session.getAttribute("token").toString()%>">
            </td>
        </tr>

        <tr>
            <td width="200px"><b>New token set :</b>
            <td width="300px"><input size="50" type="text" name="dummytoken"
                                     value="<%=session.getAttribute("token").toString()%>" disabled="disabled"></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" name="Submit" value="Submit">
            </td>
        </tr>
    </table>
</form>
</body>
</html>