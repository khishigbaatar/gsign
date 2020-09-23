package biz.gsign.user;

public interface PasswordService {
    String encodePassword(String rawPassword);

    boolean validatePassword(String rawPassword, String encodedPassword);
}
