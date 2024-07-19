package web.config.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.User.User;
import web.config.UserDao.UserDao;

import java.util.List;
@Service
public class UserService extends UserDao {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public List<User> getAllUsers() {
        return userDao.index();
    }

    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    public void updateUser(User updatedUser) {
        userDao.updateUser(updatedUser);
    }

    @Transactional
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}