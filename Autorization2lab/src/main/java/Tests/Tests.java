package Tests;

import DB.DBServiceImpl;
import model.Right;
import model.Role;
import model.User;
import org.junit.Assert;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

public class Tests {
        @Test
        public void fillingDataBase() throws NoSuchAlgorithmException {
            DBServiceImpl dbService = new DBServiceImpl();
            dbService.openConnection();

            Right right1 = new Right("create report");
            Right right2 = new Right("add user");
            Right right3 = new Right("delete user");
            Right right4 = new Right("create document");
            Right right5 = new Right("delete document");

            Role role1 = new Role("root");
            Role role2 = new Role("incomplete rights");

            role1.AddRight(right1);
            role1.AddRight(right2);
            role1.AddRight(right3);
            role1.AddRight(right4);
            role1.AddRight(right5);

            role2.AddRight(right1);
            role2.AddRight(right2);
            role2.AddRight(right4);

            User user1 = new User("Ivan", "Ivan_Wolf", "qwerty");
            user1.setRole(role1);

            User user2 = new User("Jon", "Jon_Pigon", "123456");
            user2.setRole(role2);

            User user3 = new User("Maxim", "Maximmmm", "zxcvbn");
            user3.setRole(role2);

            dbService.save(user1);
            dbService.save(user2);
            dbService.save(user3);

            Assert.assertEquals(dbService.getUser(1), user1);
            Assert.assertEquals(dbService.getUser(2), user2);
            Assert.assertEquals(dbService.getUser(3), user3);

            String login = "Ivan_Wolf";
            String password = "qwerty";

            try {
                User user = dbService.findUser(login, password);
                System.out.println("\u001b[31m" + user.getRole().getAccesList() + "\u001b[0m");
            } catch (Exception var15) {
                System.out.println(new Exception("Не удалось войти"));
                Assert.fail();
            }

            dbService.closeConnection();
        }
}
