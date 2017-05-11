
import ge.mziuri.test.dao.ContestDAO;
import ge.mziuri.test.dao.ContestDAOImpl;
import ge.mziuri.test.dao.ResultsDAO;
import ge.mziuri.test.dao.ResultsDAOImpl;
import ge.mziuri.test.dao.TestDAO;
import ge.mziuri.test.dao.TestDAOImpl;
import ge.mziuri.test.dao.UserDAO;
import ge.mziuri.test.dao.UserDAOImpl;
import ge.mziuri.test.exceptions.RegistrationException;
import ge.mziuri.test.model.Contest;
import ge.mziuri.test.model.QuestionType;
import ge.mziuri.test.model.Result;
import ge.mziuri.test.model.Test;
import ge.mziuri.test.model.User;
import java.sql.Date;
import java.sql.Time;

public class Runner {

    public static void main(String[] args) {
     
       
      ContestDAO contestDAO = new ContestDAOImpl();
//        System.out.println(contestDAO.getAllContest(false));
       Contest contest1 = new Contest();
        contest1.setDate(new Date(31536));
        contest1.setDuration(12);
        contest1.setName("abc");
       contest1.setTime(new Time(921341414));
       contestDAO.addContest(contest1);
//       System.out.println(contestDAO.addContest(contest1));
//        TestDAO testDAO = new TestDAOImpl();
//      Test test = new Test();
//        test.setType(QuestionType.OPEN);
//       test.setContestid(2);
//        test.setQuestion("რა?");
//        testDAO.addTest(test);
        UserDAO userDAO = new UserDAOImpl();
               User user = new User();
                user.setAdmin(true);
                user.setEmail("lortkipanidze77@gmail.com");
                user.setFirstname("niko");
              user.setLastname("ade");
               user.setPassword("12345678");
              user.setUsername("abc");
           
            
   //        User user1=userDAO.getUser("dfsgsfd","12345678");
//                System.out.println(user1);
//                 
            try {
                    userDAO.addUser(user);
                } catch (RegistrationException ex) {
                   System.out.println("ასეთი მომხმარებელი უკვე არსებობს!");
                }
        TestDAO testDao=new TestDAOImpl();
        
//        System.out.println(testDao.getQuestionByContestId(25));
   ResultsDAO resultDAO = new ResultsDAOImpl();
        Result result1=new Result();
        result1.setContest(contest1);
        result1.setUser(user);
        result1.setPoint(5);
       resultDAO.addResult(result1);
    }
}
