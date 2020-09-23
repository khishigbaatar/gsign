package biz.gsign.config.security;

import biz.gsign.user.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GSignUserDetailsService implements UserDetailsService {
    private final UserDataMapper userDataMapper;

    public GSignUserDetailsService(UserDataMapper userDataMapper) {
        this.userDataMapper = userDataMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DatabaseUser databaseUser = userDataMapper.getByUsername(username);

        List<GrantedAuthority> roles;

        roles = AuthorityUtils.createAuthorityList("");

        return new GSignUserDetails(
                databaseUser.getUsername(),
                databaseUser.getEncodedPassword(),
                roles,
                new User(databaseUser)
        );
    }
}
