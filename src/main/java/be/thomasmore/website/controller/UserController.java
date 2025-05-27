package be.thomasmore.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import be.thomasmore.website.model.UserRegisterForm;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired private PasswordEncoder passwordEncoder;

    @GetMapping("/user/login")
    public String login(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/camps";
        }
        return "user/login";
    }

    @GetMapping("/user/logout")
    public String logout(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/camps"; // gebruiker is al uitgelogd
        }
        return "user/logout";
    }
    @GetMapping("/user/register")
    public String registerForm(Model model) {
        model.addAttribute("userRegisterForm", new UserRegisterForm());
        return "user/register";
    }

    @PostMapping("/user/register")
    public String registerSubmit(@ModelAttribute UserRegisterForm userRegisterForm,
                                 HttpServletRequest request) {
        String username = userRegisterForm.getUsername();
        String password = passwordEncoder.encode(userRegisterForm.getPassword());

        jdbcTemplate.update("INSERT INTO users (username, password, enabled) VALUES (?, ?, true)",
                username, password);
        jdbcTemplate.update("INSERT INTO authorities (username, authority) VALUES (?, ?)",
                username, "ROLE_USER");

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(username, null, List.of(() -> "ROLE_USER"));
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);

        return "redirect:/camps";
    }


}
