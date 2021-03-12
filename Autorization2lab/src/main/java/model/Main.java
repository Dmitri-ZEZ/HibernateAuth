package model;

import DB.DBServiceImpl;
import org.hibernate.Session;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        DBServiceImpl dbService = new DBServiceImpl();
        dbService.openConnection();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите логин и пароль");
        String login = sc.nextLine();
        String password = sc.nextLine();

        try {
            User user = dbService.findUser(login, password);
            System.out.println(user);
        } catch (Exception var6) {
            System.out.println(new Exception("Не удалось войти"));
        }

        dbService.closeConnection();




    }
}
