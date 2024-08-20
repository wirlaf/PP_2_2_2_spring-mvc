package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private  EntityManager entityManager;


    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user, int id) {
        user.setId(id);
        entityManager.merge(user);
    }
    @Override
    public void delete(int id) {
        if (entityManager.find(User.class, id) != null) {
            entityManager.remove(entityManager.find(User.class, id));
        }

    }

    @Override
    public List<User> show() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }


}
