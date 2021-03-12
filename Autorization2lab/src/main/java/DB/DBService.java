package DB;

public interface DBService {
    void save(model.User user);

    void save(model.Role role);

    void save(model.Right right);

    model.User getUser(java.lang.Integer integer);

    java.util.List<model.User> findUserByName(java.lang.String s);

    model.User findUser(java.lang.String s, java.lang.String s1) throws java.security.NoSuchAlgorithmException;

    java.util.List<model.Role> readAllRoles();

    java.util.List<model.Right> readAllRights();

    java.util.List<model.User> readAllUsers();

    void openConnection();

    void closeConnection();
}