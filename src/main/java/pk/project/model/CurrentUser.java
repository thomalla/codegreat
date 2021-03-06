package pk.project.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import pk.project.util.Role;

import java.util.Collection;

public class CurrentUser extends org.springframework.security.core.userdetails.User
{
    private User user;


    public CurrentUser(User user)
    {
        super(user.getLogin(),user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user=user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                "} " + super.toString();
    }
}
