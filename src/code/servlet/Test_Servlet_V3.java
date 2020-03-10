package code.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:txy
 * @Date:created in 8:46 2020/3/8
 */
@WebServlet("/testServletV3")
//HttpServlet实现了http请求
public class Test_Servlet_V3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String myHeader = req.getParameter("myheader");
        resp.getWriter().println("hello Servlet v3 "+myHeader);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("param");
        resp.getWriter().println("hello Servlet v3 post "+param);
    }
}
