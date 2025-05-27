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
        Iterable<Participant> iterable = participantRepository.findAll();
        List<Participant> participants = new ArrayList<>();
        for (Participant p : iterable) {
            participants.add(p);
        }
        model.addAttribute("participants", participants);
        return "participantlist";
    }

    @GetMapping("/participant/{id}")
    public String participantDetails(@PathVariable Integer id, Model model) {
        Participant participant = participantRepository.findById(id).orElse(null);
        if (participant == null) return "error";

        List<Registration> registrations = new ArrayList<>();
        for (Registration r : registrationRepository.findAll()) {
            if (r.getParticipantId().equals(id)) {
                registrations.add(r);
            }
        }

        List<SummerCamp> registeredCamps = new ArrayList<>();
        for (Registration r : registrations) {
            SummerCamp c = summerCampRepository.findById(r.getSummerCampId()).orElse(null);
            if (c != null) {
                registeredCamps.add(c);
            }
        }

        model.addAttribute("participant", participant);
        model.addAttribute("camps", registeredCamps);
        return "participantdetails";
    }
}