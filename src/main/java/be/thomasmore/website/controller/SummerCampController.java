package be.thomasmore.website.controller;

import be.thomasmore.website.model.SummerCamp;
import be.thomasmore.website.model.Activity;
import be.thomasmore.website.repositories.SummerCampRepository;
import be.thomasmore.website.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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

        Iterable<Activity> iterable = activityRepository.findAll();
        List<Activity> activities = new ArrayList<>();
        for (Activity a : iterable) {
            activities.add(a);
        }
        model.addAttribute("activities", activities);

        return "campgreeting";
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
        return "list";
    }
}