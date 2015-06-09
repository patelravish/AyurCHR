<%@ page import="fv.ayurchr.commons.SaveForm" %>
<%@ page import="fv.ayurchr.commons.taglib.html.FORM" %>
<%@ page import="fv.ayurchr.commons.FormAttributes" %>
<%
    if ("true".equals(request.getParameter("submitf"))) {
        long l = System.currentTimeMillis();
        SaveForm.saveForm(request, session);
        System.out.println("Time Taken = " + (System.currentTimeMillis() - l) / 1000);
    } else {
%>
<%-- <%@include file="/common/header.jsp" %> --%>


<form dojoType="dijit.form.Form" id="AyurCHRForm" jsId="AyurCHRForm" action="" method="POST">
    <script type="dojo/method" event="onReset">
        return confirm('Press OK to reset widget values');
    </script>

    <script type="dojo/method" event="onSubmit">
        dojo.stopEvent(event);
        if (this.validate())
        {
        if(confirm('Do you want to update records?'))
        {
        submitf.value='true';
        postForm(this.id);
        }
        }
        else
        {
        alert('Form contains invalid data. Please correct first');
        }
        return false;
    </script>
<%
    FORM iFORM = new FORM(out); //Form instance which will be used across the page rendering
    FormAttributes FA = new FormAttributes(); // Attributes o the orm which will be used or form rendering
    FA.setCLASS(CLASS);
    FA.setEntity(ENTITY);
    Object FormObj = CLASS.newInstance();
    if (null == request.getParameter("Id")) {
        FA.setISNEW(true);
        FA.setAction(FormAttributes.ADD);
    } else {
        long l_id = -1;
        try {
            l_id = Long.valueOf(request.getParameter("Id"));
        } catch (Exception e) {
        }
        FA.setId(l_id);
        FormObj = FORM.getFormValue(FA.getId(), ENTITY);
    }

    session.setAttribute(FORM.ATTRIBUTES, FA);
%>