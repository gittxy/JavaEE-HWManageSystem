package code.servlet;

import code.jdbc.StudentJdbc;
import code.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author:txy
 * @Date:created in 8:46 2020/3/8
 */
@WebServlet("/addStudent")
public class TeacherAddStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码问题
        resp.setContentType("text/html;charset=UTF-8");
        if(req.getParameter("id").equals("")){
            resp.getWriter().println("学生学号不能为空,5s后返回初始界面");
        }else if(req.getParameter("name").equals("")){
            resp.getWriter().println("学生姓名不能为空,5s后返回初始界面");
        }else{
            Student newStudent = new Student();
            newStudent.setId(Long.parseLong(req.getParameter("id")));
            newStudent.setName(req.getParameter("name"));
            Timestamp dateNow=new Timestamp(System.currentTimeMillis());

            newStudent.setCreateTime(dateNow);
            List<Student> studentList = null;
            try {
                studentList = StudentJdbc.selectAllStudent();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            boolean isExist = false;
            for(Student s:studentList){
                if( newStudent.getId().equals(s.getId())){
                    isExist = true;
                    break;
                }
            }

            if(isExist){
                resp.getWriter().println("学号重复,5s后返回初始界面");
            }else {

                try {
                    if(StudentJdbc.addStudent(newStudent)){
                        resp.getWriter().println("添加成功,5s后跳转");
                    }else {
                        resp.getWriter().println("添加失败，请检查后再添加,5s后返回初始界面");
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        resp.setHeader("refresh","5;URL=index.jsp");
    }
}
