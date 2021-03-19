package ru.itis.conferences.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreateReportAndConferencesController {

    @GetMapping("/create/report")
    public String getPageForCreateReports(){
        return "create-report";
    }

    @GetMapping("/create/conference")
    public String getPageForCreateConferences(){
        return "create-conference";
    }
}
