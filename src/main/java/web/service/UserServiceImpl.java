package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void create(User user) {
        userDao.create(user);
    }
    @Override
    public void update(User user, int id) {
        userDao.update(user, id);
    }
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
    @Override
    public List<User> show() {
        return userDao.show();
    }
}
