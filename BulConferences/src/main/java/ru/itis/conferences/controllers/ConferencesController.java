package ru.itis.conferences.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.conferences.services.ConferenceService;
import ru.itis.conferences.utils.Attributes;

@Controller
@PreAuthorize("hasRole('ROLE_LISTENER')")
public class ConferencesController {

    private final ConferenceService conferenceService;

    @Autowired
    public ConferencesController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @GetMapping("/conferences")
    public String getCourses(ModelMap map) {
        map.put("conferencesDtoReg", conferenceService.getAllConferencesWhereThisUserIsRegistered());
        map.put("conferencesDtoNotReg", conferenceService.getAllConferencesWhereThisUserIsNotRegistered());
        return "conferences";
    }

    @GetMapping("/conference/{name}")
    public String enrollConference(@PathVariable("name") String name, RedirectAttributes redirectAttributes){
        if (conferenceService.signUpForConference(name)){
            Attributes.addSuccessAttributesWithFlash(redirectAttributes, "Success");
        }else{
            Attributes.addErrorAttributesWithFlash(redirectAttributes, "Error!");
        }
        return "redirect:/conferences";
    }
}
