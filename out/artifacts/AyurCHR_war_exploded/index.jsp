<%@include file="common/header.jsp" %>

<%
    String display_page = request.getParameter("display_page");
%>
<div style="overflow-y: scroll;height: 95%!important;">


    <%
        if (null == display_page || "".equals(display_page)) {
    %>
    <div id="feedDiv" style="float: left;overflow-y:visible;" data-dojo-type="dijit.layout.ContentPane" title="Home">
        <%@ include file="includeInfoBoard.jsp" %>
    </div>
    <%
    } else if ("incidence".equalsIgnoreCase(display_page)) {

    %>
    <div data-dojo-type="dijit.layout.ContentPane" title="Incidence" style="float: left;">
        <%@include file="common/public_forms/include_incidence.jsp" %>
    </div>
    <%
    } else if ("patient".equalsIgnoreCase(display_page)) {
    %>
    <div id="createUserDiv" style="float: left;display: block;overflow-y:visible;"
         data-dojo-type="dijit.layout.ContentPane" title="Add/Edit Patient Info.">
        <%@include file="common/public_forms/user.jsp" %>
    </div>
    <%
    } else {
    %>
    <div id="feedDiv" style="float: left;overflow-y:visible;" data-dojo-type="dijit.layout.ContentPane" title="Home">
        <%@ include file="includeInfoBoard.jsp" %>
    </div>
    <%
        }
    %>

</div>
<%@include file="/common/footer.jsp" %>