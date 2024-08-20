package web.dao;

import web.model.User;

import java.util.List;


public interface UserDao {

    List<User> show();
    void create(User user);

    void update(User user);

    void delete(int id);

}
