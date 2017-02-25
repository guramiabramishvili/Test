
import ge.mziuri.test.dao.UserDAO;
import ge.mziuri.test.dao.UserDAOImpl;
import ge.mziuri.test.exceptions.RegistrationException;
import ge.mziuri.test.model.User;


public class Runner {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImpl();
        User user = new User();
        user.setAdmin(true);
        user.setEmail("lortkipanidze77@gmail.com");
        user.setFirstname("luka");
        user.setLastname("Lortkipanidze");
        user.setPassword("12345678");
        user.setUsername("dfsgsfd");
        
        
        
        
        
        
        
        try {
            userDAO.addUser(user);
        } catch (RegistrationException ex) {
            System.out.println("ასეთი მომხმარებელი უკვე არსებობს!");
        }
        
    }
}
