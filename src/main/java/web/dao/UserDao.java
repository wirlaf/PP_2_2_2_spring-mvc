package web.dao;

import web.model.User;

import java.util.List;


public interface UserDao {

    List<User> show();
    User showOne(Integer id);
    void create(User user);

    void update(User user,int id);

    void delete(int id);

}
