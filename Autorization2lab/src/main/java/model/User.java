package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private String name;
    private String login;
    private String password;
    @ManyToOne(
            cascade = {CascadeType.ALL}
    )
    @JoinColumn(
            name = "role_id"
    )
    private Role role;

    public User(String name, String login, String password) throws NoSuchAlgorithmException {
        this.name = name;
        this.login = login;
        this.password = getHash(password);
    }

    public static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        Formatter formatter = new Formatter(sb);
        byte[] var3 = bytes;
        int var4 = bytes.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            byte b = var3[var5];
            formatter.format("%02x", b);
        }

        return sb.toString();
    }

    public static String getHash(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return bytesToHexString(md.digest(pass.getBytes()));
    }
}
