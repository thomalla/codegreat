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
    private String name;
    private String surname;
    private String email;

}
