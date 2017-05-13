package ge.mziuri.test.dao;

import ge.mziuri.test.model.Contest;
import java.util.List;

public interface ContestDAO {
   List <Contest> getAllContest (boolean active);
   int addContest (Contest contest);
   Contest getContestbyId(int id);
}
