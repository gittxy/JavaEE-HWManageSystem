package code.servlet;

import code.jdbc.HomeworkJdbc;
import code.jdbc.StudentJdbc;
import code.model.Homework;
import code.model.Student;
import code.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author:txy
 * @Date:created in 8:46 2020/3/8
 */

@WebServlet("/queryStuHW")
public class TeacherSearchAStudentHWServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<StudentHomework> studentHomeworkList = null;
        try {
            studentHomeworkList = HomeworkJdbc.selectAStudentHomework(Long.parseLong(req.getParameter("student_id")));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        req.setAttribute("studenthomeworklist",studentHomeworkList);
        req.getRequestDispatcher("AStudentHW.jsp").forward(req,resp);


    }


}
