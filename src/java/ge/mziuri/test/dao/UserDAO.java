
package ge.mziuri.test.dao;


import ge.mziuri.test.exceptions.RegistrationException;
import ge.mziuri.test.model.User;


public interface UserDAO {
    
    void addUser(User user) throws RegistrationException;
    User getUser (String username,String password);
    User getUserbyID (int id);
}
