<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="com.lin.service.EmployeeService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lin.pojo.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>员工管理</title>
</head>
<body>
    <%
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService= (EmployeeService) context.getBean("employeeService");
        List<Employee> employees=employeeService.gets();
        request.setAttribute("employees",employees);
    %>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>地址</th>
        <th>电话</th>
        <th>密码</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.employees}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.age}</td>
            <td>${employee.sex}</td>
            <td>${employee.address}</td>
            <td>${employee.phone}</td>
            <td>${employee.password}</td>
            <td>
                <a href="form.jsp?employeeId=${employee.id}">
                    <button>修改</button>
                </a>
                <a href="/delete/${employee.id}">
                    <button>修改</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="form.jsp"><button>员工添加</button></a>
</body>
</html>
