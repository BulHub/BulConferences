package ru.itis.conferences.controllers;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.itis.conferences.models.Conference;
import ru.itis.conferences.models.Report;
import ru.itis.conferences.services.AudienceService;
import ru.itis.conferences.services.ConferenceService;
import ru.itis.conferences.services.ReportService;
import ru.itis.conferences.utils.Attributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@PreAuthorize("hasRole('ROLE_PRESENTER')")
public class CRUDReportAndConferencesController {

    private final ConferenceService conferenceService;
    private final AudienceService audienceService;
    private final ReportService reportService;

    @Autowired
    public CRUDReportAndConferencesController(ConferenceService conferenceService, AudienceService audienceService, ReportService reportService) {
        this.conferenceService = conferenceService;
        this.audienceService = audienceService;
        this.reportService = reportService;
    }

    @GetMapping("/create/report")
    public String getPageForCreateReports(Map<String, Object> model) {
        model.put("audiences", audienceService.findAll());
        model.put("conferences", conferenceService.findAll());
        return "create-report";
    }

    @PostMapping("/create/report")
    public String createReports(Report report,
                                @RequestParam("conference1") String conference,
                                @RequestParam("audience1") String audience,
                                @RequestParam("start_date1") String start_date,
                                @RequestParam("finish_date1") String finish_date,
                                ModelMap map) {
        StringBuilder errors = reportService.checkingDataForCreateReportsAddFillingTheEntity(report, conference,
                audience, start_date, finish_date);
        if (errors.length() == 0) {
            Optional<Report> optionalReport = reportService.areTheseDatesBusyInTheAudience(LocalDateTime.parse(start_date),
                    LocalDateTime.parse(finish_date), report.getAudience().getNumber());
            if (optionalReport.isPresent()) {
                Attributes.addErrorAttributes(map, "At this time, a report is already being held in this audience!");
            } else {
                reportService.add(report);
                Attributes.addSuccessAttributes(map, "Success");
            }
        } else {
            Attributes.addErrorAttributes(map, errors.toString());
        }
        map.put("conferences", conferenceService.findAll());
        map.put("audiences", audienceService.findAll());
        System.out.println(errors);
        return "create-report";
    }

    @GetMapping("/create/conference")
    public String getPageForCreateConferences(){
        return "create-conference";
    }

    @PostMapping("/create/conference")
    public String createConferences(Conference conference, ModelMap map) {
        Optional<Conference> optionalConference = conferenceService.find(conference.getName());
        if (!optionalConference.isPresent()) {
            Attributes.addSuccessAttributes(map, "Success!");
            conferenceService.add(conference);
        }else {
            Attributes.addErrorAttributes(map, "A conference with the same name already exists!");
        }
        return "create-conference";
    }

    @GetMapping("/delete/report")
    public String getPageForDeleteReport(ModelMap map){
        List<String> names = reportService.findAll()
                .stream().map(Report::getName)
                .collect(Collectors.toList());
        map.put("names", names);
        return "delete-report";
    }

    @PostMapping("/delete/report")
    public String deleteReport(RedirectAttributes redirectAttributes,
                               @RequestParam("name") String name){
        Optional<Report> report = reportService.find(name);
        if (report.isPresent()){
            reportService.delete(report.get());
            Attributes.addSuccessAttributesWithFlash(redirectAttributes, "Success");
        }else{
            Attributes.addErrorAttributesWithFlash(redirectAttributes, "Error!");
        }
        return "redirect:/delete/report";
    }
}
