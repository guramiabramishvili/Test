package ge.mziuri.test.servlet;

import ge.mziuri.test.dao.UserDAO;
import ge.mziuri.test.dao.UserDAOImpl;
import ge.mziuri.test.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.getUser(username, Integer.toString(password.hashCode()));
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();

        if (user == null) {
            request.setAttribute("authorizationFailed", true);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } else if (user.isAdmin() == true) {
            int UserId = user.getId();
            Cookie UserCookie = new Cookie("UserId", "" + UserId);
            response.addCookie(UserCookie);
            RequestDispatcher rd = request.getRequestDispatcher("adminHome.jsp");
          
            rd.forward(request, response);

        } else {
              int UserId = user.getId();
            Cookie UserCookie = new Cookie("UserId", "" + UserId);
            response.addCookie(UserCookie);
            RequestDispatcher rd = request.getRequestDispatcher("userHome.jsp");
            rd.forward(request, response);
        }
    }
}