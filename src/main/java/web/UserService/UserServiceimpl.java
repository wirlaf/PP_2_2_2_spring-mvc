package web.UserService;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.User.User;
import web.UserDao.UserDao;

import java.util.List;
@Service
public class UserServiceimpl implements UserService {

private final UserDao userDao;

    public UserServiceimpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Transactional
    public List<User> getAllUsers() {
        return userDao.index();
    }

    @Override
    public List<User> index() {
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