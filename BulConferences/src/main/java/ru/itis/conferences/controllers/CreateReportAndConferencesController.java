package ru.itis.conferences.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.conferences.models.Conference;
import ru.itis.conferences.models.Report;
import ru.itis.conferences.services.AudienceService;
import ru.itis.conferences.services.ConferenceService;
import ru.itis.conferences.services.ReportService;
import ru.itis.conferences.utils.Attributes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Controller
@PreAuthorize("hasRole('ROLE_PRESENTER')")
public class CreateReportAndConferencesController {

    private final ConferenceService conferenceService;
    private final AudienceService audienceService;
    private final ReportService reportService;

    @Autowired
    public CreateReportAndConferencesController(ConferenceService conferenceService, AudienceService audienceService, ReportService reportService) {
        this.conferenceService = conferenceService;
        this.audienceService = audienceService;
        this.reportService = reportService;
    }

    @GetMapping("/create/report")
    public String getPageForCreateReports(Map<String, Object> model){
        model.put("audiences", audienceService.findAll());
        model.put("conferences", conferenceService.findAll());
        return "create-report";
    }

    @PostMapping("/create/report")
    //FIXME: НЕ СОХРАНЯЕТ В БД!!!
    public String createReports(Report report,
                                @RequestParam("conference1") String conference,
                                @RequestParam("audience1") String audience,
                                @RequestParam("start_date1") String start_date,
                                @RequestParam("finish_date1") String finish_date,
                                ModelMap map){
        reportService.fillingTheEntity(report, conference, audience, start_date, finish_date);
        StringBuilder errors = reportService.checkingDataForCreateReports(report, map);
        if (!LocalDateTime.parse(finish_date).isAfter(LocalDateTime.parse(start_date))){
            errors.append("The start date cannot be more than the end date of the conference ");
        }
        Optional<Report> optionalReport = reportService.areTheseDatesBusyInTheAudience(LocalDateTime.parse(finish_date),
                LocalDateTime.parse(start_date), report.getAudience().getNumber());
        if (optionalReport.isPresent()){
            errors.append("This conference is the same as your: ");
            errors.append(optionalReport.get().toString());
        }
        if (errors.length() == 0){
            reportService.add(report);
            Attributes.addSuccessAttributes(map, "Success!");
        }else{
            Attributes.addErrorAttributes(map, errors.toString());
        }
        map.put("audiences", audienceService.findAll());
        map.put("conferences", conferenceService.findAll());
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
