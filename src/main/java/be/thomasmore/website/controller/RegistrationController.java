package be.thomasmore.website.controller;

import be.thomasmore.website.model.Registration;
import be.thomasmore.website.model.Participant;
import be.thomasmore.website.model.SummerCamp;
import be.thomasmore.website.repositories.RegistrationRepository;
import be.thomasmore.website.repositories.ParticipantRepository;
import be.thomasmore.website.repositories.SummerCampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private SummerCampRepository summerCampRepository;

    @GetMapping("/registrations")
    public String listRegistrations(Model model) {
        List<Registration> registrations = new ArrayList<>();
        registrationRepository.findAll().forEach(registrations::add);

        model.addAttribute("registrations", registrations);
        return "allRegistered";
    }




    @GetMapping("/registrations/edit/{id}")
    public String showParticipantDetailsFromRegistration(@PathVariable Integer id, Model model) {
        Registration registration = registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inschrijving niet gevonden"));

        Participant participant = registration.getParticipant();
        List<Registration> allRegistrations = registrationRepository.findByParticipant(participant);

        List<SummerCamp> registeredCamps = new ArrayList<>();
        for (Registration reg : allRegistrations) {
            registeredCamps.add(reg.getCamp());
        }

        model.addAttribute("participant", participant);
        model.addAttribute("camps", registeredCamps);

        return "participantDetails";
    }





    @PostMapping("/update")
    public String updateRegistration(@ModelAttribute Registration registration) {
        registrationRepository.save(registration);
        return "redirect:/registrations";
    }
    @PostMapping("/register")
    public String registerForCamp(@RequestParam Integer campId, Principal principal) {
        if (principal == null) return "redirect:/login";

        Optional<Participant> optionalParticipant = participantRepository.findByUsername(principal.getName());
        if (optionalParticipant.isEmpty()) return "redirect:/login";

        Participant participant = optionalParticipant.get();
        SummerCamp camp = summerCampRepository.findById(campId)
                .orElseThrow(() -> new RuntimeException("Camp not found"));

        boolean alreadyRegistered = registrationRepository.existsByParticipantAndCamp(participant, camp);
        if (!alreadyRegistered) {
            Registration registration = new Registration();
            registration.setParticipant(participant);
            registration.setCamp(camp);
            registration.setRegistrationDate(LocalDate.now());
            registration.setRegistrationTime(LocalTime.now());
            registrationRepository.save(registration);
        }

        return "redirect:/campgreeting/" + campId;
    }

    @PostMapping("/admin/unregister")
    public String unregisterAsAdmin(@RequestParam Integer participantId, @RequestParam Integer campId) {
        Participant participant = participantRepository.findById(participantId)
                .orElseThrow(() -> new RuntimeException("Participant niet gevonden"));
        SummerCamp camp = summerCampRepository.findById(campId)
                .orElseThrow(() -> new RuntimeException("Kamp niet gevonden"));
        Registration registration = registrationRepository.findByParticipantAndCamp(participant, camp);
        if (registration != null) {
            registrationRepository.delete(registration);
        }
        return "redirect:/registrations";
    }




    @GetMapping("/myregistrations")
    public String viewMyRegistrations(Model model, Principal principal) {
        if (principal == null) {
            model.addAttribute("registrations", Collections.emptyList());
            return "myRegistrations";
        }

        Optional<Participant> optionalParticipant = participantRepository.findByUsername(principal.getName());
        if (optionalParticipant.isPresent()) {
            List<Registration> registrations = registrationRepository.findByParticipant(optionalParticipant.get());
            model.addAttribute("registrations", registrations);
        } else {
            model.addAttribute("registrations", Collections.emptyList());
        }

        return "myRegistrations";
    }

    @PostMapping("/unregister/{campId}")
    public String unregister(@PathVariable Integer campId, Principal principal) {
        String username = principal.getName();
        Participant participant = participantRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Participant niet gevonden"));

        SummerCamp camp = summerCampRepository.findById(campId)
                .orElseThrow(() -> new RuntimeException("Kamp niet gevonden"));

        Registration registration = registrationRepository.findByParticipantAndCamp(participant, camp);
        if (registration != null) {
            registrationRepository.delete(registration);
        }

        return "redirect:/campgreeting/" + campId;
    }



}


