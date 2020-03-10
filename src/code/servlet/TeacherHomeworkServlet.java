package code.servlet;



import code.jdbc.HomeworkJdbc;
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
 * @Date:created in 8:50 2020/3/8
 */
@WebServlet("/searchAllTh")
public class TeacherHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Homework> homeworkList = null;
        try {
            homeworkList = HomeworkJdbc.selectAllTeacherHomework();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.setAttribute("teacherhomeworklist", homeworkList);
        req.getRequestDispatcher("Tea_Add_HW.jsp").forward(req,resp);
    }

}
