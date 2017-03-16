
package ge.mziuri.test.dao;



import ge.mziuri.test.model.Contest;
import ge.mziuri.test.model.User;
import java.util.List;


public interface ContestDAO {
   List <Contest> getAllContest ();
   int addContest (Contest contest);
 //  void getcontesetbyid (Integer contesetid);
 
   
}
