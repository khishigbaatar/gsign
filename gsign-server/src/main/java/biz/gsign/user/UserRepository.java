package biz.gsign.user;

import biz.gsign.restutils.BadRequestException;
import biz.gsign.restutils.NotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final UserDataMapper userDataMapper;
    private PasswordService passwordService;

    public UserRepository(
            UserDataMapper userDataMapper,
            PasswordService passwordService
    ) {
        this.userDataMapper = userDataMapper;
        this.passwordService = passwordService;
    }

    public User authenticate(Credentials credentials) {
        DatabaseUser databaseUser;

        try {
            databaseUser = userDataMapper.getByUsername(credentials.getUsername());
        } catch (NotFoundException e) {
            throw new BadRequestException("Invalid credentials.");
        }

        boolean passwordIsValid = passwordService.validatePassword(
                credentials.getPassword(),
                databaseUser.getEncodedPassword()
        );

        if (!passwordIsValid) {
            throw new BadRequestException("Invalid credentials.");
        }

        return new User(databaseUser);
    }
}
