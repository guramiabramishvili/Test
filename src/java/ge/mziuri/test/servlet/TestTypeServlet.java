package ge.mziuri.test.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestTypeServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String type = request.getParameter("testType");
        Cookie TypeCookie = new Cookie("Type", "" + type);
        response.addCookie(TypeCookie);
        if ("oneAns".equals(type) == true) {
            RequestDispatcher rd = request.getRequestDispatcher("CreateOneAnsTest.jsp");
            rd.forward(request, response);
        }
        if ("multiAns".equals(type) == true) {
            RequestDispatcher rd = request.getRequestDispatcher("CreateMultiAnsTest.jsp");
            rd.forward(request, response);
        }
        if ("open".equals(type) == true) {
            RequestDispatcher rd = request.getRequestDispatcher("CreateOpenTest.jsp");
            rd.forward(request, response);
        }
    }
}
