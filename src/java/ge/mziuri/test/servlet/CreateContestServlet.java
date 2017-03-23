package ge.mziuri.test.servlet;

import ge.mziuri.test.dao.ContestDAO;
import ge.mziuri.test.dao.ContestDAOImpl;
import ge.mziuri.test.model.Contest;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateContestServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String duration = request.getParameter("duration");

        try {
            Contest contest = new Contest();
            contest.setName(name);
            DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            contest.setDate(new Date(formatter.parse(date).getTime()));
            int duration1 = Integer.parseInt(duration) * 60;
            contest.setDuration(duration1);
            String hour = time.substring(0, 2);
            String min = time.substring(3, 5);
            int hour1 = Integer.parseInt(hour);
            int min1 = Integer.parseInt(min);
            int milisecs = hour1 * 60 * 60 * 1000 + min1 * 60 * 1000;
            Time time1 = new Time(milisecs);
            contest.setTime(time1);
            ContestDAO contestDAO = new ContestDAOImpl();
            int id = contestDAO.addContest(contest);
            Cookie cookie = new Cookie ("contest_id", "" + id);
            response.addCookie(cookie);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
         
        RequestDispatcher rd = request.getRequestDispatcher("TestType.jsp");
        rd.forward(request, response);

    }
}
