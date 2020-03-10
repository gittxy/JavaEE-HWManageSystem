package code.servlet;

import code.jdbc.HomeworkJdbc;
import code.model.StudentHomework;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;


/**
 * @Author:txy
 * @Date:created in 8:50 2020/3/8
 */
@WebServlet("/submit")
public class StudentAddHomeworkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码问题
        resp.setContentType("text/html;charset=UTF-8");
        if(req.getParameter("homework_id").equals("")){
            resp.getWriter().println("作业编号不能为空,5s后返回初始界面");
        }else if(req.getParameter("homework_title").equals("")){
            resp.getWriter().println("作业标题不能为空,5s后返回初始界面");
        }else if(req.getParameter("student_id").equals("")){
            resp.getWriter().println("学生学号不能为空,5s后返回初始界面");
        }else if(req.getParameter("homework_content").equals("")){
            resp.getWriter().println("作业内容不能为空,5s后返回初始界面");
        }else{
            StudentHomework sh = new StudentHomework();
            sh.setStudentId(Long.parseLong(req.getParameter("student_id")));
            sh.setHomeworkId(Long.parseLong(req.getParameter("homework_id")));
            sh.setHomeworkTitle(req.getParameter("homework_title"));
            sh.setHomeworkContent(req.getParameter("homework_content"));
            Timestamp dateNow=new Timestamp(System.currentTimeMillis());

            sh.setCreateTime(dateNow);


            try {
                resp.getWriter().println(HomeworkJdbc.handHomework(sh)+",5s后返回初始界面");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        resp.setHeader("refresh","5;URL=index.jsp");
    }
}
