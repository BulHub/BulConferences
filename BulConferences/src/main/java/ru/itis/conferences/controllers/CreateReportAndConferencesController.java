package ru.itis.conferences.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.conferences.models.Conference;
import ru.itis.conferences.models.Report;
import ru.itis.conferences.services.ConferenceService;
import ru.itis.conferences.utils.Attributes;

import java.util.Optional;

@Controller
public class CreateReportAndConferencesController {

    private final ConferenceService conferenceService;

    @Autowired
    public CreateReportAndConferencesController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @GetMapping("/create/report")
    public String getPageForCreateReports(){
        return "create-report";
    }

    @PostMapping("/create/report")
    public String createReports(Report report, ModelMap map){
        Attributes.addSuccessAttributes(map, "Success!");
        System.out.println(report);
        return "create-report";
    }

    @GetMapping("/create/conference")
    public String getPageForCreateConferences(){
        return "create-conference";
    }

    @PostMapping("/create/conference")
    public String createConferences(Conference conference, ModelMap map){
        Optional<Conference> optionalConference = conferenceService.find(conference.getName());
        if (!optionalConference.isPresent()){
            Attributes.addSuccessAttributes(map, "Success!");
            conferenceService.add(conference);
        }else{
            Attributes.addErrorAttributes(map, "A conference with the same name already exists!");
        }
        return "create-conference";
    }
}
