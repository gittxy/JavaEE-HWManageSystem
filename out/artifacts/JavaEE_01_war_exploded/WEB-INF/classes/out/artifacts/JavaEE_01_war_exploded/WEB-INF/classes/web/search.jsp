<%@ page import="code.model.StudentHomework" %>
<%@ page import="java.util.List" %>
<%@ page import="code.model.Homework" %>
<%@ page import="code.servlet.TeacherSearchServlet" %>
<%@ page import="code.jdbc.HomeworkJdbc" %><%--
  Created by IntelliJ IDEA.
  User: guoqi
  Date: 2020/3/7
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课后作业</title>
</head>
<body>
<h1 align="center">
    作业列表
</h1>
<table align="center" width="950" border="1" bgcolor="black" cellpadding="1" cellspacing="1">
    <tr bgcolor="aqua">
        <td align="center">作业编号</td>
        <td align="center">作业标题</td>
    </tr>
    <%
        List<Homework> tlist = HomeworkJdbc.selectAllTeacherHomework();
        if(null == tlist||tlist.size()<=0){
            out.println("None data.");
        }else{
            for(Homework th:tlist){
    %>
    <tr align="center" bgcolor="white" height="40">
        <td><%=th.getId()%></td>
        <td><%=th.getTitle()%></td>
    </tr>
    <%}}%>
</table>
<h1 align="center">
    作业提交记录
</h1>
<table align="center" width="950" border="1" bgcolor="black" cellpadding="1" cellspacing="1">
    <tr bgcolor="aqua">
        <td align="center">ID</td>
        <td align="center">学号</td>
        <td align="center">作业编号</td>
        <td align="center">作业标题</td>
        <td align="center">作业内容</td>
        <td align="center">创建时间</td>
    </tr>
    <%
        List<StudentHomework> slist = (List<StudentHomework>)request.getAttribute("studenthomeworklist");
        if(null == slist || slist.size()<=0){
            out.println("None data.");
        }else{
            for(StudentHomework sh: slist){
    %>
    <tr align="center" bgcolor="white" height="30">
        <td><%=sh.getId()%></td>
        <td><%=sh.getStudentId()%></td>
        <td><%=sh.getHomeworkId()%></td>
        <td><%=sh.getHomeworkTitle()%></td>
        <td><%=sh.getHomeworkContent()%></td>
        <td><%=sh.getCreateTime()%></td>
    </tr>
    <%}}%>
</table>
<br/>
<br/>
<a href="http://localhost:8081/" >
    <button >返回</button>
</a>
</body>
</html>
