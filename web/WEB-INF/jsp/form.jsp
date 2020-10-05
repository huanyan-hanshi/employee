<%@ page import="com.lin.pojo.Employee" %>
<%@ page import="com.lin.service.EmployeeService" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工管理</title>
</head>
<body>
<%
    ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
    EmployeeService employeeService= (EmployeeService) context.getBean("employeeService");
    Employee employee=null;
    String action="";
    if (request.getParameter("employeeId")==null)action="/add";
    else {
        action="/update";
        employee=employeeService.get(Integer.valueOf(request.getParameter("employeeId")));
    }
    request.setAttribute("action",action);
%>
<form:form action="${action}">
    <table>
        <tr>
            <td>id</td>
            <td>
                <%=request.getParameter("employeeId")%>
                <form:input path="id"/>
            </td>
        </tr>
        <tr>
            <td>姓名</td>
            <td>
                <form:input path="name"/>
                <%=employee.getName()%>
            </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td>
                <form:input path="age"/>
                <%=employee.getAge()%>
            </td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <form:input path="sex"/>
                <%=employee.getSex()%>
            </td>
        </tr>
        <tr>
            <td>地址</td>
            <td>
                <form:input path="address"/>
                <%=employee.getAddress()%>
            </td>
        </tr>
        <tr>
            <td>电话</td>
            <td>
                <form:input path="phone"/>
                <%=employee.getPhone()%>
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <form:input path="password"/>
                <%=employee.getPassword()%>
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td>
                <input type="submit" name="提交">
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
