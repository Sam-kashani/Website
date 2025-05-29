package be.thomasmore.website.controller;

import be.thomasmore.website.model.Participant;
import be.thomasmore.website.model.Registration;
import be.thomasmore.website.model.SummerCamp;
import be.thomasmore.website.repositories.ParticipantRepository;
import be.thomasmore.website.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
            return "redirect:/camps";
        }
        return "user/logout";
    }

    @ModelAttribute("myCamps")
    public List<SummerCamp> populateMyCamps(Principal principal) {
        if (principal == null) return null;

        Optional<Participant> optionalParticipant = participantRepository.findByUsername(principal.getName());
        if (optionalParticipant.isPresent()) {
            Participant participant = optionalParticipant.get();
            List<Registration> registrations = registrationRepository.findByParticipant(participant);

            List<SummerCamp> camps = new ArrayList<>();
            for (Registration reg : registrations) {
                camps.add(reg.getCamp());
            }

            return camps;
        }
        return null;
    }


}
