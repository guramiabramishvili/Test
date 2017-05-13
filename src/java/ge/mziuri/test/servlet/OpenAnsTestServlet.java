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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OpenAnsTestServlet extends HttpServlet {

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
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("TestNumber")) {
                    questionNumber = Integer.parseInt(cookie.getValue());
                    break;
                }
            }
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("UserId")) {
                    UserId = Integer.parseInt(cookie.getValue());
                    break;
                }
            }
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("Points")) {
                    points = Integer.parseInt(cookie.getValue());
                    break;
                }
            }
        }
        List<Test> tests = testDAO.getQuestionByContestId(contestid);
        if (questionNumber == tests.size()) {
            String answer = request.getParameter("1");
             Test test = tests.get(questionNumber - 1);
    try {
                    for (int i = 0; i < test.getOpenquestionanswer().size(); i++) {
                        if (answer.equals(test.getOpenquestionanswer().get(i))) {
                            points++;
                            Cookie pointsCookie = new Cookie("Points", "" + points);
                            response.addCookie(pointsCookie);

                        }
                    }
                } catch (Exception ignored) {
                }
            result.setContest(contestDAO.getContestbyId(contestid));
            result.setUser(userDAO.getUserbyID(UserId));
            result.setPoint(points);
            resultDAO.addResult(result);
            RequestDispatcher rd = request.getRequestDispatcher("userHome.jsp");
            rd.forward(request, response);
        } else {

            Cookie testNumberCookie = new Cookie("TestNumber", "" + (questionNumber + 1));
            String answer = request.getParameter("1");
            response.addCookie(testNumberCookie);
            Test test = tests.get(questionNumber - 1);
            if (questionNumber != 0) {
                try {
                    for (int i = 0; i < test.getOpenquestionanswer().size(); i++) {
                        if (answer.equals(test.getOpenquestionanswer().get(i))) {
                            points++;
                            Cookie pointsCookie = new Cookie("Points", "" + points);
                            response.addCookie(pointsCookie);

                        }
                    }
                } catch (Exception ignored) {
                }
            }
            QuestionType nextQuestionType = tests.get(questionNumber).getType();
            if (nextQuestionType.name().equals("SINGLE_ANSWER")) {
                RequestDispatcher rd = request.getRequestDispatcher("OneAnsTest.jsp");
                rd.forward(request, response);
            }
            if (nextQuestionType.name().equals("MULTIPLE_ANSWER")) {
                RequestDispatcher rd = request.getRequestDispatcher("MultiAnsTest.jsp");
                rd.forward(request, response);
            }
            if (nextQuestionType.name().equals("OPEN")) {
                RequestDispatcher rd = request.getRequestDispatcher("OpenAnsTest.jsp");
                rd.forward(request, response);
            }
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}