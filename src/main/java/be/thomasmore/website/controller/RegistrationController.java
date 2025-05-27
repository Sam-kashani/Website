package be.thomasmore.website.controller;

import be.thomasmore.website.model.Registration;
import be.thomasmore.website.model.Participant;
import be.thomasmore.website.model.RegistrationForm;
import be.thomasmore.website.repositories.RegistrationRepository;
import be.thomasmore.website.repositories.ParticipantRepository;
import be.thomasmore.website.repositories.SummerCampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private SummerCampRepository summerCampRepository;

    @GetMapping("/registrations")
    public String listAllRegistrations(Model model) {
        model.addAttribute("registrations", registrationRepository.findAll());
        model.addAttribute("participants", participantRepository.findAll());
        model.addAttribute("camps", summerCampRepository.findAll());
        return "list_all";
    }

    @GetMapping("/registrations/new")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        model.addAttribute("camps", summerCampRepository.findAll());
        return "new";
    }

    @PostMapping("/registrations/save")
    public String saveRegistration(@ModelAttribute RegistrationForm form) {
        Participant participant = new Participant();
        participant.setName(form.getParticipantName());
        participant.setEmail(form.getParticipantEmail());
        participant.setAge(form.getParticipantAge());
        participantRepository.save(participant);

        Registration registration = new Registration();
        registration.setParticipantId(participant.getId());
        registration.setSummerCampId(form.getSummerCampId());
        registration.setRegistrationDate(LocalDate.now());
        registration.setRegistrationTime(LocalTime.now().withSecond(0).withNano(0));

        registrationRepository.save(registration);

        return "redirect:/registrations";
    }

    @GetMapping("/registrations/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Registration registration = registrationRepository.findById(id).orElse(null);
        model.addAttribute("registration", registration);
        model.addAttribute("participants", participantRepository.findAll());
        model.addAttribute("camps", summerCampRepository.findAll());
        return "edit";
    }

    @PostMapping("/registrations/update")
    public String updateRegistration(@ModelAttribute Registration registration) {
        registrationRepository.save(registration);
        return "redirect:/registrations";
    }
}
