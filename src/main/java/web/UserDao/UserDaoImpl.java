package web.UserDao;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.User.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;
@Transactional
    public  List<User> index() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM user";
        Query query = entityManager.createNativeQuery(sql, User.class);
        userList = query.getResultList();
        return userList;
    }
    @Transactional
    public void addUser(User user) {
        try {
            entityManager.persist(user);
        } catch (Exception e) {
            System.out.println("Error adding user: " + e.getMessage());
        }
    }
    @Transactional
    public void updateUser(User updatedUser) {
        try {
            entityManager.merge(updatedUser);
        } catch (Exception e) {
            System.out.println("Error updating user: " + e.getMessage());
        }
    }
    @Transactional
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }
  @Transactional
    public void deleteUser(Long id){
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
  }
}