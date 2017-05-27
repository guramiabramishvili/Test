package ge.mziuri.test.dao;


import ge.mziuri.test.model.Result;
import java.util.List;

public interface ResultsDAO {
    
    void addResult (Result result);
    
    List<Result>  getResultByContestId(Integer contestid);
};