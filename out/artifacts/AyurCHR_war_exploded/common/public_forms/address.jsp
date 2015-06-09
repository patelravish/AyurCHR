<%@ page import="fv.ayurchr.dbobjects.hibernate.Address" %>
<%@ page import="fv.ayurchr.dbobjects.hibernate.Role" %>
<%@ page import="fv.ayurchr.dbobjects.hibernate.User" %>

<%
    Class CLASS = User.class;
    String ENTITY = Address.ENTITY;
%>

<%@include file="/common/form/form_header.jsp" %>

<%
    User u = (User) FormObj;
%>

<%
    TextBox FirstName = new TextBox("First Name", "FirstName");
    FirstName.isRequired();
    FirstName.setValue(u.getFirstName());
    iFORM.print(FirstName);

    TextBox LastName = new TextBox("Last Name", "LastName");
    LastName.isRequired();
    LastName.setValue(u.getLastName());
    iFORM.print(LastName);

    TextBox MiddleName = new TextBox("Middle Name", "Last Name");
    LastName.isRequired();
    LastName.setValue(u.getLastName());
    iFORM.print(LastName);

    TextBox LastName = new TextBox("Last Name", "LastName");
    LastName.isRequired();
    LastName.setValue(u.getLastName());
    iFORM.print(LastName);

    TextBox LastName = new TextBox("Last Name", "LastName");
    LastName.isRequired();
    LastName.setValue(u.getLastName());
    iFORM.print(LastName);

    ComboBox RoleBox = new ComboBox("Role Name", "RoleId");
    RoleBox.setClassName(Role.class);
    RoleBox.setEntityName(Role.ENTITY);
    RoleBox.setFilterValueName("Id");
    RoleBox.setDisplayValue("RoleName");
    RoleBox.setValue(String.valueOf(u.getRoleId()));

    iFORM.print(RoleBox);
%>

<%@include file="/common/form/form_footer.jsp" %>
