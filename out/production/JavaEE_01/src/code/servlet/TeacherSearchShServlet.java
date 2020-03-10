package code.servlet;

import code.jdbc.HomeworkJdbc;
import code.model.StudentHomework;
import code.model.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author:txy
 * @Date:created in 8:46 2020/3/8
 */
@WebServlet("/searchAllSh")
public class TeacherSearchShServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<StudentHomework> studentHomeworkList = null;
        try {
            studentHomeworkList = HomeworkJdbc.selectAllStudentHomework();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.setAttribute("studenthomeworklist",studentHomeworkList);

        req.getRequestDispatcher("Tea_Query_HW.jsp").forward(req,resp);
    }

}
