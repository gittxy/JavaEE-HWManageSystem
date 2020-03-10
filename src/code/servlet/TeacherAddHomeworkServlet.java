package code.servlet;

import code.jdbc.HomeworkJdbc;
import code.model.Homework;

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
 * @Date:created in 8:50 2020/3/8
 */

@WebServlet("/addhomework")
public class TeacherAddHomeworkServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        if(req.getParameter("id").equals("")){
            resp.getWriter().println("作业编号不能为空,5s后返回初始界面");
        }else if(req.getParameter("title").equals("")){
            resp.getWriter().println("作业标题不能为空,5s后返回初始界面");
        }else if(req.getParameter("content").equals("")){
            resp.getWriter().println("作业内容不能为空,5s后返回初始界面");
        }else{
            Homework th = new Homework();
            th.setId(Long.parseLong(req.getParameter("id")));
            th.setTitle(req.getParameter("title"));
            th.setContent(req.getParameter("content"));
            Timestamp dateNow=new Timestamp(System.currentTimeMillis());

            th.setCreateTime(dateNow);
            List<Homework> thList = null;
            try {
                thList = HomeworkJdbc.selectAllTeacherHomework();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            boolean isExist = false;
            for(Homework h:thList){
                if(th.getId()==h.getId()){
                    isExist = true;
                    break;
                }
            }

            if(isExist){
                resp.getWriter().println("id重复,5s后返回初始界面");
            }else {
                try {
                    if(HomeworkJdbc.addHomework(th)){
                        resp.getWriter().println("添加成功,5s后返回初始界面");
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
