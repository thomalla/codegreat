package pk.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by DELL on 2017-04-22.
 */
@Entity
public class User
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int userId;
    private String login;
    private String name;
    private String surname;
    private String email;
    private String password;

    protected User(){};

    public User(String login, String name, String surname, String email, String password) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
}
