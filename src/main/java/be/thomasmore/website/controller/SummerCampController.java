package be.thomasmore.website.controller;

import be.thomasmore.website.model.Participant;
import be.thomasmore.website.model.SummerCamp;
import be.thomasmore.website.model.Activity;
import be.thomasmore.website.repositories.ParticipantRepository;
import be.thomasmore.website.repositories.RegistrationRepository;
import be.thomasmore.website.repositories.SummerCampRepository;
import be.thomasmore.website.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class SummerCampController {

    @Autowired
    private SummerCampRepository summerCampRepository;
    @Autowired
    private ParticipantRepository participantRepository;


    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @GetMapping({"/campgreeting/{id}", "/campgreeting"})
    public String campGreeting(@PathVariable(required = false) Integer id,
                               Model model,
                               Principal principal) {

        if (id == null) {
            return "campDetails";
        }

        SummerCamp camp = summerCampRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kamp niet gevonden"));
        model.addAttribute("camp", camp);
        model.addAttribute("greeting", "Welkom bij " + camp.getName());

        int prevId = (id == 1) ? 10 : id - 1;
        int nextId = (id == 10) ? 1 : id + 1;
        model.addAttribute("prevId", prevId);
        model.addAttribute("nextId", nextId);

        List<Activity> activities = activityRepository.findBySummerCampId(id);
        model.addAttribute("activities", activities);

        boolean isRegistered = false;
        if (principal != null) {
            Optional<Participant> optionalParticipant = participantRepository.findByUsername(principal.getName());
            if (optionalParticipant.isPresent()) {
                Participant participant = optionalParticipant.get();
                model.addAttribute("participant", participant);

                isRegistered = registrationRepository.existsByParticipantAndCamp(participant, camp);
            }
        }
        model.addAttribute("isRegistered", isRegistered);


        return "campDetails";
    }


    @GetMapping("/camps")
    public String filterCamps(Model model,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String location,
                              @RequestParam(required = false) Integer minParticipants,
                              @RequestParam(required = false) Double maxPrice,
                              @RequestParam(required = false) String campType) {

        List<SummerCamp> camps = summerCampRepository.findByFilters(name, location, minParticipants, maxPrice, campType);
        model.addAttribute("camps", camps);
        return "allCamps";
    }
    @GetMapping("/campnew")
    public String showNewCampForm(Model model) {
        model.addAttribute("camp", new SummerCamp());
        return "campform";
    }

    @PostMapping("/campnew")
    public String saveNewCamp(@ModelAttribute("camp") SummerCamp camp) {
        summerCampRepository.save(camp);
        return "redirect:/camps";
    }
    @GetMapping("/campedit/{id}")
    public String showEditCampForm(@PathVariable(required = false) int id, Model model) {
        SummerCamp camp = summerCampRepository.findById(id).orElse(null);
        if (camp == null) return "redirect:/camps";
        model.addAttribute("camp", camp);
        return "campedit";
    }
    @PostMapping("/campedit/{id}")
    public String updateCamp(@PathVariable(required = false) int id, @ModelAttribute("camp") SummerCamp updatedCamp) {
        updatedCamp.setId(id);
        summerCampRepository.save(updatedCamp);
        return "redirect:/campgreeting/" + id;
    }

    @PostMapping("/campdelete/{id}")
    public String deleteCamp(@PathVariable(required = false) int id) {
        summerCampRepository.deleteById(id);
        return "redirect:/camps";
    }




}