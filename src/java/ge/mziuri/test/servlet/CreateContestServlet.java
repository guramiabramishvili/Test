
package ge.mziuri.test.servlet;


import ge.mziuri.test.dao.ContestDAO;
import ge.mziuri.test.dao.ContestDAOImpl;
import ge.mziuri.test.model.Contest;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateContestServlet extends HttpServlet {
      @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        
    }
        @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String duration = request.getParameter("duration");
        
//        Contest contest = new Contest();
//        contest.setDate(date);
//        contest.setDuration(duration);
//        contest.setName(name);
//        contest.setTime(time);
//        ContestDAO contestDAO = new ContestDAOImpl();
        
//           contestDAO.addContest(contest);
        System.out.println(date + " " + time + " " + duration);
            RequestDispatcher rd = request.getRequestDispatcher("createtest.html");
            rd.forward(request, response);
       
    }
}
