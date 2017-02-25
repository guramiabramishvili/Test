
package ge.mziuri.test.dao;


import ge.mziuri.test.model.User;


public interface UserDAO {
    void addUser(User user);
    User getUser (String username,String password);
    
    
}
