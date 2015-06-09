<%@ page import="fv.ayurchr.commons.SaveForm" %>
<%@ page import="fv.ayurchr.commons.FormAttributes" %>
<%@ page import="fv.ayurchr.commons.taglib.html.FORM" %>
<%
    FormAttributes FA = new FormAttributes(); // Attributes o the orm which will be used or form rendering
    Class CLASS = Class.forName(request.getParameter("CLASS"));
    String ENTITY = request.getParameter("ENTITY");
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
    SaveForm.saveForm(request, session);
%>