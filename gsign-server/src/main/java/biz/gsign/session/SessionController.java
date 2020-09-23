package biz.gsign.session;

import biz.gsign.config.security.GSignUserDetails;
import biz.gsign.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
    @PostMapping("/sessions")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@AuthenticationPrincipal GSignUserDetails userDetails) {
        return userDetails.getGsignUser();
    }
}
