package biz.gsign.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BcryptPasswordService implements PasswordService {
    private BCryptPasswordEncoder encoder;

    public BcryptPasswordService() {
        encoder = new BCryptPasswordEncoder();
    }

    @Override
    public String encodePassword(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    @Override
    public boolean validatePassword(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }
}
