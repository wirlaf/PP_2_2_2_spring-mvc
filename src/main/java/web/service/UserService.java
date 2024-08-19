package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void create(User user);
    void update(User user,int id);
    void delete(int id);
    List<User> show();
}