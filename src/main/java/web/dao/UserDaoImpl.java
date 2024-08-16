package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;




    @Override
    public void create(User user) {
        System.out.println("DAO");
        System.out.println(user);
        entityManagerFactory.createEntityManager().persist(user);
    }



    @Override
    public void update(User user, int id) {
        user.setId(id);
        entityManagerFactory.createEntityManager().merge(user);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<User> show() {
        return entityManagerFactory.createEntityManager().createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User showOne(Integer id) {
        return entityManagerFactory.createEntityManager().find(User.class, id);
    }
}
