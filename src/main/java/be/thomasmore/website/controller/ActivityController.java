package be.thomasmore.website.controller;

import be.thomasmore.website.model.Activity;
import be.thomasmore.website.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;

    @GetMapping("/activities")
    public String listActivities(Model model) {
        List<Activity> activities = activityRepository.findAll();
        model.addAttribute("activities", activities);
        return "activities/list";
    }

    @GetMapping("/activities/{id}")
    public String detailActivity(@PathVariable Integer id, Model model) {
        Activity activity = activityRepository.findById(id).orElse(null);
        model.addAttribute("activity", activity);
        return "activities/detail";
    }
}