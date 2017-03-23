package ge.mziuri.test.servlet;

import ge.mziuri.test.dao.TestDAO;
import ge.mziuri.test.dao.TestDAOImpl;
import ge.mziuri.test.model.QuestionType;
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

public class CreateMultiAnsTestServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String question = request.getParameter("question");
        String ans1 = request.getParameter("1");
        String ans2 = request.getParameter("2");
        String ans3 = request.getParameter("3");
        String ans4 = request.getParameter("4");
        String ans5 = request.getParameter("5");
        String ans6 = request.getParameter("6");
        String[] correctanswer = request.getParameterValues("CorrectAns");
        List<Integer> correctanswers = new ArrayList<>();
        for (int i = 0; i < correctanswer.length; i++) {
            correctanswers.add(Integer.parseInt(correctanswer[i]));
        }
        String openquestionanswer = null;
        Cookie[] cookies = request.getCookies();
        int contestid = 0;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("contest_id")) {
                    contestid = Integer.parseInt(cookie.getValue());
                }
                
            }
        }
        Test test = new Test();
        test.getAnswers().add(0, ans1);
        test.getAnswers().add(1, ans2);
        test.getAnswers().add(2, ans3);
        test.getAnswers().add(3, ans4);
        test.getAnswers().add(4, ans5);
        test.getAnswers().add(5, ans6);
        test.setType(QuestionType.MULTIPLE_ANSWER);
        test.setAnswerIndexes(correctanswers);
        test.setContestid(contestid);
        test.getOpenquestionanswer().add(openquestionanswer);
        test.setQuestion(question);
        TestDAO testDAO = new TestDAOImpl();
        testDAO.addTest(test);
        RequestDispatcher rd = request.getRequestDispatcher("TestType.jsp");
        rd.forward(request, response);
        
    }
}
