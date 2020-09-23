package biz.gsign.config.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class GSignUserDetails extends User {
    private final biz.gsign.user.User gsignUser;

    public GSignUserDetails(
            String username,
            String password,
            Collection<? extends GrantedAuthority> authorities,
            biz.gsign.user.User evaUser
    ) {
        super(username, password, authorities);
        this.gsignUser = evaUser;
    }

    public biz.gsign.user.User getGsignUser() {
        return gsignUser;
    }
}
