package DB;

import lombok.Getter;
import model.Right;
import model.Role;
import model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.security.NoSuchAlgorithmException;
import java.util.List;
@Getter
public class UserDAO {
    private Session session;

    public UserDAO(Session session) {
        this.session = session;
    }

    public void save(User user) {
        this.session.saveOrUpdate(user);
    }

    public void save(Role role) {
        this.session.saveOrUpdate(role);
    }

    public void save(Right right) {
        this.session.saveOrUpdate(right);
    }

    public User getUser(Integer id) {
        return (User)this.session.get(User.class, id);
    }

    public List<User> findUserByName(String name) {
        org.hibernate.query.Query query = this.session.createQuery("from User where name = ?1");
        query.setParameter(1, name);
        return query.getResultList();
    }

    public User findUser(String login, String password) throws NoSuchAlgorithmException {
        org.hibernate.query.Query query = this.session.createQuery("from User where login = ?1 and password = ?2");
        query.setParameter(1, login);
        query.setParameter(2, User.getHash(password));
        return (User)query.getSingleResult();
    }

    public List<Role> readAllRoles() {
        org.hibernate.query.Query query = this.session.createQuery("from Role");
        return query.getResultList();
    }

    public List<Right> readAllRights() {
        org.hibernate.query.Query query = this.session.createQuery("from Right");
        return query.getResultList();
    }

    public List<User> readAllUsers() {
        Query query = this.session.createQuery("from User");
        return query.getResultList();
    }

    public Session getSession() {
        return this.session;
    }

}