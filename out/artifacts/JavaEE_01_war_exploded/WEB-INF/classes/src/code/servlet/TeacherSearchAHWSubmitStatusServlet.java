package code.servlet;

import code.jdbc.HomeworkJdbc;
import code.model.StudentHomework;

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

@WebServlet("/queryHWSubmissionStatus")
public class TeacherSearchAHWSubmitStatusServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<StudentHomework> studentHomeworkList = null;
        try {
            studentHomeworkList = HomeworkJdbc.selectAHomework(Long.parseLong(req.getParameter("homework_id")));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.setAttribute("studenthomeworklist",studentHomeworkList);
        req.getRequestDispatcher("AStudentHW.jsp").forward(req,resp);
    }
}
