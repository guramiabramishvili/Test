package ge.mziuri.test.servlet;

import ge.mziuri.test.dao.TestDAO;
import ge.mziuri.test.dao.TestDAOImpl;
import ge.mziuri.test.model.QuestionType;
import ge.mziuri.test.model.Test;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateOneAnsTestServlet extends HttpServlet {
    
   
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
        int correctanswer = Integer.parseInt(request.getParameter("CorrectAns"));
        Test test = new Test();
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
System.out.println(contestid);
        if(!"".equals(ans1)) test.getAnswers().add(ans1);
        if(!"".equals(ans2)) test.getAnswers().add(ans2);
        if(!"".equals(ans3)) test.getAnswers().add(ans3);
        if(!"".equals(ans4)) test.getAnswers().add(ans4);
        if(!"".equals(ans5)) test.getAnswers().add(ans5);
        if(!"".equals(ans6)) test.getAnswers().add(ans6);
        test.setType(QuestionType.SINGLE_ANSWER);
        test.getAnswerIndexes().add(correctanswer);
        test.setContestid(contestid);
        test.getOpenquestionanswer().add(openquestionanswer);
        if(!"".equals(question)) test.setQuestion(question);
        TestDAO testDAO = new TestDAOImpl();
        testDAO.addTest(test);
        RequestDispatcher rd = request.getRequestDispatcher("TestType.jsp");
        rd.forward(request, response);
        
    }
        
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    



