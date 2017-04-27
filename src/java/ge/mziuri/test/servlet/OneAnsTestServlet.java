package ge.mziuri.test.servlet;

import ge.mziuri.test.dao.ContestDAO;
import ge.mziuri.test.dao.ContestDAOImpl;
import ge.mziuri.test.dao.ResultsDAO;
import ge.mziuri.test.dao.ResultsDAOImpl;
import ge.mziuri.test.dao.TestDAO;
import ge.mziuri.test.dao.TestDAOImpl;
import ge.mziuri.test.dao.UserDAO;
import ge.mziuri.test.dao.UserDAOImpl;
import ge.mziuri.test.model.QuestionType;
import ge.mziuri.test.model.Result;
import ge.mziuri.test.model.Test;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OneAnsTestServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        TestDAO testDAO = new TestDAOImpl();
        ContestDAO contestDAO = new ContestDAOImpl();
        ResultsDAO resultDAO = new ResultsDAOImpl();
        UserDAO userDAO = new UserDAOImpl();
        Result result = new Result();
        int contestid = 0;
        int questionNumber = 0;
        int UserId = 0;
        int points = 0;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("contest_id")) {
                    contestid = Integer.parseInt(cookie.getValue());
                    break;
                }
            }
            for (Cookie cookie1 : cookies) {
                if (cookie1.getName().equals("TestNumber")) {
                    questionNumber = Integer.parseInt(cookie1.getValue());
                    break;
                }
            }
            for (Cookie cookie2 : cookies) {
                if (cookie2.getName().equals("UserId")) {
                    UserId = Integer.parseInt(cookie2.getValue());
                    break;
                }
            }
            for (Cookie cookie3 : cookies) {
                if (cookie3.getName().equals("Points")) {
                    points = Integer.parseInt(cookie3.getValue());
                    break;
                }
            }
        }
        List<Test> tests = testDAO.getQuestionByContestId(contestid);
        Test test = tests.get(questionNumber);
        try {
            int answer = Integer.parseInt(request.getParameter("answer"));
            if (test.getAnswerIndexes().get(0) == answer) {
                points++;
            }
        } catch (Exception ignore) {
        }

        int nextQuestion = questionNumber + 1;
        Cookie PointsCookie = new Cookie("Points", "" + points);
        Cookie TestNumberCookie = new Cookie("TestNumber", "" + nextQuestion);
        response.addCookie(PointsCookie);
        response.addCookie(TestNumberCookie);
        response.resetBuffer();
        QuestionType NextQuestionType = tests.get(questionNumber + 1).getType();
        if (NextQuestionType.name().equals("SINGLE_ANSWER")) {
            RequestDispatcher rd = request.getRequestDispatcher("OneAnsTest.jsp");
            rd.forward(request, response);
        }
        if (NextQuestionType.name().equals("MULTIPLE_ANSWER")) {
            RequestDispatcher rd = request.getRequestDispatcher("MultiAnsTest.jsp");
            rd.forward(request, response);
        }
        if (NextQuestionType.name().equals("OPEN")) {
            RequestDispatcher rd = request.getRequestDispatcher("OpenAnsTest.jsp");
            rd.forward(request, response);
        }
        if (tests.size() == questionNumber) {
            result.setContest(contestDAO.getContestbyId(contestid));
            result.setUser(userDAO.getUserbyID(UserId));
            result.setPoint(points);
            resultDAO.addResult(result);
            RequestDispatcher rd = request.getRequestDispatcher("userHome.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

}
