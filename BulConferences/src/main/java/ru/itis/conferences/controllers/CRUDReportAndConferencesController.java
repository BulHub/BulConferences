package ru.itis.conferences.controllers;

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
                                @RequestParam("start_date1") String start_date,
                                @RequestParam("finish_date1") String finish_date,
                                RedirectAttributes redirectAttributes) {
        StringBuilder errors = reportService.checkingDataForCreateReportsAddFillingTheEntity(report,
                start_date, finish_date);
        Optional<Report> optionalReport = reportService.areTheseDatesBusyInTheAudience(LocalDateTime.parse(start_date),
                LocalDateTime.parse(finish_date), report.getAudience().getNumber());
        if (optionalReport.isPresent()) {
            errors.append("At this time, a report is already being held in this audience!");
        }
        if (errors.length() == 0){
            reportService.add(report);
            Attributes.addSuccessAttributesWithFlash(redirectAttributes,
                    "Success");
        }else{
            Attributes.addErrorAttributesWithFlash(redirectAttributes, errors.toString());
        }
        return"redirect:/create/report";
    }


    @GetMapping("/create/conference")
    public String getPageForCreateConferences() {
        return "create-conference";
    }

    @PostMapping("/create/conference")
    public String createConferences(Conference conference, ModelMap map) {
        Optional<Conference> optionalConference = conferenceService.find(conference.getName());
        if (!optionalConference.isPresent()) {
            Attributes.addSuccessAttributes(map, "Success!");
            conferenceService.add(conference);
        } else {
            Attributes.addErrorAttributes(map, "A conference with the same name already exists!");
        }
        return "create-conference";
    }

    @GetMapping("/delete/report")
    public String getPageForDeleteReport(ModelMap map) {
        List<String> names = reportService.findAll()
                .stream().map(Report::getName)
                .collect(Collectors.toList());
        map.put("names", names);
        return "delete-report";
    }

    @PostMapping("/delete/report")
    public String deleteReport(RedirectAttributes redirectAttributes,
                               @RequestParam("name") String name) {
        Optional<Report> report = reportService.find(name);
        if (report.isPresent()) {
            reportService.delete(report.get());
            Attributes.addSuccessAttributesWithFlash(redirectAttributes, "Success");
        } else {
            Attributes.addErrorAttributesWithFlash(redirectAttributes, "Error!");
        }
        return "redirect:/delete/report";
    }

    @GetMapping("/update/report")
    public String getPageForUpdateReport(Map<String, Object> model) {
        model.put("audiences", audienceService.findAll());
        model.put("conferences", conferenceService.findAll());
        List<String> names = reportService.findAll().stream().map(Report::getName).collect(Collectors.toList());
        model.put("names", names);
        return "update-report";
    }

    @PostMapping("/update/report")
    public String updateReport(Report report,
                               @RequestParam("start_date1") String start_date,
                               @RequestParam("finish_date1") String finish_date,
                               RedirectAttributes redirectAttributes) {
        Optional<Report> reportOptional = reportService.find(report.getName());
        if (reportOptional.isPresent()) {
            Report newReport = reportOptional.get();
            if (report.getAudience() != null) {
                newReport.setAudience(report.getAudience());
            }
            if (report.getConference() != null) {
                newReport.setConference(report.getConference());
            }
            if (!start_date.equals("") && !finish_date.equals("")) {
                LocalDateTime start = LocalDateTime.parse(start_date);
                LocalDateTime finish = LocalDateTime.parse(finish_date);
                if (!finish.isAfter(start)) {
                    Attributes.addErrorAttributesWithFlash(redirectAttributes,
                            "The start date cannot be more than the end date of the conference. ");
                } else {
                    Optional<Report> optionalReport = reportService.areTheseDatesBusyInTheAudience(start,
                            finish, newReport.getAudience().getNumber());
                    if (optionalReport.isPresent()) {
                        Attributes.addErrorAttributesWithFlash(redirectAttributes, "At this time, a report is already being held in this audience!");
                    } else {
                        newReport.setStartDate(start);
                        newReport.setFinishDate(finish);
                        Attributes.addSuccessAttributesWithFlash(redirectAttributes, "Success");
                    }
                }
            }
            reportService.add(newReport);
        }
        return "redirect:/update/report";
    }
}
