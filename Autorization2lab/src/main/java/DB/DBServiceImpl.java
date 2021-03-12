package DB;


import model.HibernateUtil;
import model.Right;
import model.Role;
import model.User;
import org.hibernate.Session;

import javax.persistence.Query;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class DBServiceImpl implements DBService {
    private UserDAO userDAO;

    public DBServiceImpl() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        this.userDAO = new UserDAO(session);
    }

    public void save(User user) {
        this.userDAO.save(user);
    }

    public void save(Role role) {
        this.userDAO.save(role);
    }

    public void save(Right right) {
        this.userDAO.save(right);
    }

    public User getUser(Integer id) {
        return this.userDAO.getUser(id);
    }

    public List<User> findUserByName(String name) {
        return this.userDAO.findUserByName(name);
    }

    public User findUser(String login, String password) throws NoSuchAlgorithmException {
        return this.userDAO.findUser(login, password);
    }

    public List<Role> readAllRoles() {
        return this.userDAO.readAllRoles();
    }

    public List<Right> readAllRights() {
        return this.userDAO.readAllRights();
    }

    public List<User> readAllUsers() {
        return this.userDAO.readAllUsers();
    }

    public void openConnection() {
        this.userDAO.getSession().beginTransaction();
    }

    public void closeConnection() {
        this.userDAO.getSession().getTransaction().commit();
        this.userDAO.getSession().close();
        System.out.println("ok");
        System.exit(0);
    }
}