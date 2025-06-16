package be.thomasmore.website.controller;

import be.thomasmore.website.model.Participant;
import be.thomasmore.website.model.Registration;
import be.thomasmore.website.model.SummerCamp;
import be.thomasmore.website.repositories.ParticipantRepository;
import be.thomasmore.website.repositories.RegistrationRepository;
import be.thomasmore.website.repositories.SummerCampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ParticipantController {

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private SummerCampRepository summerCampRepository;

    @GetMapping("/participants")
    public String participantList(Model model) {
        List<Participant> participants = participantRepository.findAllByOrderByNameAsc();
        model.addAttribute("participants", participants);
        return "allParticipant";
    }

    @GetMapping("/participant/{id}")
    public String participantDetails(@PathVariable(required = false) Integer id, Model model) {
        Participant participant = participantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Participant niet gevonden"));

        List<Registration> registrations = registrationRepository.findByParticipant(participant);

        List<SummerCamp> registeredCamps = new ArrayList<>();
        for (Registration registration : registrations) {
            registeredCamps.add(registration.getCamp());
        }

        model.addAttribute("participant", participant);
        model.addAttribute("camps", registeredCamps);
        return "participantDetails";
    }

}
