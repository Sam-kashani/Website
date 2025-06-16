package be.thomasmore.website.controller;

import be.thomasmore.website.model.Participant;
import be.thomasmore.website.model.Registration;
import be.thomasmore.website.model.SummerCamp;
import be.thomasmore.website.model.UserRegister;
import be.thomasmore.website.repositories.ParticipantRepository;
import be.thomasmore.website.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;



    @GetMapping("/user/login")
    public String login(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/camps";
        }
        return "user/login";
    }

    @GetMapping("/user/logout")
    public String logoutPage() {
        return "user/logout";
    }


    @GetMapping("/user/register")
    public String showRegisterPage(Model model, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/camps";
        }
        model.addAttribute("userRegister", new UserRegister());
        return "user/register";
    }

    @PostMapping("/user/register")
    public String processRegister(@ModelAttribute("userRegister") UserRegister userRegister, Model model) {
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(
                "SELECT username FROM users WHERE username = ?",
                userRegister.getUsername()
        );

        if (rowSet.next()) {
            model.addAttribute("userRegister", userRegister);
            model.addAttribute("usernameExists", true);
            return "user/register";
        }

        jdbcTemplate.update(
                "INSERT INTO users(username, password, enabled) VALUES (?, ?, true)",
                userRegister.getUsername(),
                passwordEncoder.encode(userRegister.getPassword())
        );

        jdbcTemplate.update(
                "INSERT INTO authorities(username, authority) VALUES (?, ?)",
                userRegister.getUsername(),
                "ROLE_USER"
        );

        jdbcTemplate.update(
                "INSERT INTO participant(name, email, age, username) VALUES (?, ?, ?, ?)",
                userRegister.getName(),
                userRegister.getEmail(),
                userRegister.getAge(),
                userRegister.getUsername()
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(userRegister.getUsername());
        UsernamePasswordAuthenticationToken authRequest =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authRequest);

        return "redirect:/camps?registered=true";

    }
    @GetMapping("/user/profile")
    public String showProfile(Model model, Principal principal) {
        if (principal == null) return "redirect:/user/login";

        Optional<Participant> optionalParticipant = participantRepository.findByUsername(principal.getName());
        if (optionalParticipant.isPresent()) {
            model.addAttribute("participant", optionalParticipant.get());
            return "user/profile";
        }

        return "redirect:/camps";
    }
}



