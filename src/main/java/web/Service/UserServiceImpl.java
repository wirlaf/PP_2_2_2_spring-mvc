package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void create(User user) {
        userDao.create(user);
        System.out.println("Service");
        System.out.println(user);
    }

    @Override
    public void update(User user, int id) {
        userDao.update(user, id);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User showOne(int id) {
        return userDao.showOne(id);
    }

    @Override
    public List<User> show() {
        return userDao.show();
    }
}
