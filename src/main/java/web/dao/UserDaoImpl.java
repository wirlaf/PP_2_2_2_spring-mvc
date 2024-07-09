package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<User> findAll() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public Optional<User> findById(int id) {
        User user = em.find(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public void save(User user) {
        em.merge(user);

    }

    @Override
    public void update(User user, int id) {
        em.merge(user);
    }

    @Override
    public void delete(int id) {
        Optional<User> user = findById(id);
        user.ifPresent(user1 -> em.remove(user1));
    }
}
