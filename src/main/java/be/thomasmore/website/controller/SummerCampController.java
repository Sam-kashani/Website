package be.thomasmore.website.controller;

import be.thomasmore.website.model.SummerCamp;
import be.thomasmore.website.model.Activity;
import be.thomasmore.website.repository.SummerCampRepository;
import be.thomasmore.website.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class SummerCampController {

    @Autowired
    private SummerCampRepository summerCampRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @GetMapping({"/campgreeting/{id}", "/campgreeting"})
    public String campGreeting(Model model, @PathVariable(required = false) Integer id) {
        if (id == null) {
            return "campgreeting";
        }

        Optional<SummerCamp> campFromDb = summerCampRepository.findById(id);
        model.addAttribute("camp", campFromDb.orElse(null));

        int prevId = (id == 1) ? 10 : id - 1;
        int nextId = (id == 10) ? 1 : id + 1;

        model.addAttribute("prevId", prevId);
        model.addAttribute("nextId", nextId);

        String greeting = campFromDb.map(c -> "Maak kennis met onze " + c.getName() + " in " + c.getLocation())
                .orElse("Geen kamp gevonden.");
        model.addAttribute("greeting", greeting);

        List<Activity> activities = activityRepository.findAll();
        model.addAttribute("activities", activities);

        return "campgreeting";
    }

    @GetMapping("/camps")
    public String filterCamps(Model model,
                              @org.springframework.web.bind.annotation.RequestParam(required = false) String name,
                              @org.springframework.web.bind.annotation.RequestParam(required = false) String location,
                              @org.springframework.web.bind.annotation.RequestParam(required = false) Integer minParticipants,
                              @org.springframework.web.bind.annotation.RequestParam(required = false) Double maxPrice,
                              @org.springframework.web.bind.annotation.RequestParam(required = false) String campType) {

        List<SummerCamp> camps = summerCampRepository.findByFilters(name, location, minParticipants, maxPrice, campType);
        model.addAttribute("camps", camps);
        return "camps/list";
    }
}
