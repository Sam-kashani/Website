package be.thomasmore.website.controller;

import be.thomasmore.website.model.Activity;
import be.thomasmore.website.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;

    @GetMapping("/activities")
    public String listActivities(Model model) {
        Iterable<Activity> iterable = activityRepository.findAll();
        List<Activity> activities = new ArrayList<>();
        for (Activity a : iterable) {
            activities.add(a);
        }
        model.addAttribute("activities", activities);
        return "allCamps";
    }

    @GetMapping("/activities/{id}")
    public String detailActivity(@PathVariable Integer id, Model model) {
        Activity activity = activityRepository.findById(id).orElse(null);
        if (activity == null) return "error";
        model.addAttribute("activity", activity);
        return "detail";
    }
}
