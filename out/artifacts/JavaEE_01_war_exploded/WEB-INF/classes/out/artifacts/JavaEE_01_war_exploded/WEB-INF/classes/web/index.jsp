<%--
  Created by IntelliJ IDEA.
  User: guoqi
  Date: 2020/2/28
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>作业管理系统</title>
  </head>
  <body align="center">
    <h1 >
      作业管理系统
    </h1>
      <a href="http://localhost:8081/searchAllSh" >
        <button >教师---查看作业</button>
      </a>
      <br/>
      <br/>
      <a href="http://localhost:8081/searchStudent" >
        <button>教师---添加学生</button>
      </a>
    <br/>
    <br/>
      <a href="http://localhost:8081/searchAllTh" >
        <button>教师---发布作业</button>
      </a>
    <br/>
    <br/>
    <a href="http://localhost:8081/handInHomework" >
      <button>学生---提交作业</button>
    </a>

  </body>
</html>
