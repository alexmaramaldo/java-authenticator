package dev.alexmaramaldo.authenticator.controllers;

import dev.alexmaramaldo.authenticator.entities.ConfirmationToken;
import dev.alexmaramaldo.authenticator.entities.User;
import dev.alexmaramaldo.authenticator.services.ConfirmationTokenService;
import dev.alexmaramaldo.authenticator.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    private final ConfirmationTokenService confirmationTokenService;

    @GetMapping("/sign-in")
    public String signIn() {

        return "sign-in";
    }

    @GetMapping("/sign-up")
    public String signUpPage(User user) {

        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String signUp(User user) {

        userService.signUpUser(user);

        return "redirect:/sign-in";
    }

    @GetMapping("/sign-up/confirm")
    public String confirmMail(@RequestParam("token") String token) {

        Optional<ConfirmationToken> optionalConfirmationToken = confirmationTokenService.findConfirmationTokenByToken(token);

        optionalConfirmationToken.ifPresent(userService::confirmUser);

        return "redirect:/sign-in";
    }

}