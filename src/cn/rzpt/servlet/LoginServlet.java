package cn.rzpt.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");

        //1.获取用户输入的验证码
        String verifycode = request.getParameter("verifycode");
        //2.获取服务器session存放的数据，如果没有则返回空
        String sessionCacheDate = (String) request.getSession().getAttribute("sessionCacheData");
        //将服务器的缓存session数据清除
        request.getSession().removeAttribute("sessionCacheData");

        //判断服务器是否存在
        if (sessionCacheDate == null){
            request.setAttribute("msg","请不要重复提交");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
            System.out.println("请不要重复提交");
            return;
        }

        //3.比较
        if (!sessionCacheDate.equalsIgnoreCase(verifycode)){
            //用户输入错误
            request.setAttribute("msg","验证码输入错误");
            //请求转发
            request.getRequestDispatcher("/index.jsp").forward(request,response);

            System.out.println("验证码输入错误");

            return;
        }

        if (username.equals("zhangsan")){
            System.out.println("下面就要开始进行登录的业务代码了！！");
        }else {
            //用户输入错误
            request.setAttribute("msg","用户名输入错误");
            //请求转发
            request.getRequestDispatcher("/index.jsp").forward(request,response);

            System.out.println("用户名输入错误");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
