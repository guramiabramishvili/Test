package ge.mziuri.test.dao;

import ge.mziuri.test.model.Test;
import java.util.List;

public interface TestDAO {

    void addTest(Test test);
    //   void deleteTest(int testid);
    //  Test getquestionbyid(Integer contestid,Integer questionid)throws ContestException ;
    List<Test> getQuestionByContestId(Integer contestid);
}
