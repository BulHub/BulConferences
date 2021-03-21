package ru.itis.conferences.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.conferences.dto.ReportDto;
import ru.itis.conferences.models.Audience;
import ru.itis.conferences.services.AudienceService;
import ru.itis.conferences.services.ReportService;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ScheduleRestController {

    private final AudienceService audienceService;
    private final ReportService reportService;

    @Autowired
    public ScheduleRestController(AudienceService audienceService, ReportService reportService) {
        this.audienceService = audienceService;
        this.reportService = reportService;
    }

    @GetMapping("/rest/reports")
    public ResponseEntity<List<ReportDto>> getAllReports(){
        return new ResponseEntity<>(reportService.findAll()
                .stream().map(ReportDto::fromReport)
                .collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @GetMapping("/rest/findByAudience/{number}")
    public ResponseEntity<List<ReportDto>> getReportsByAudience(@PathVariable("number") String number) {
        Optional<Audience> optionalAudience = audienceService.findByNumber(Long.parseLong(number));
        return optionalAudience.map(audience ->
                new ResponseEntity<>(reportService.findByAudience(audience).stream()
                        .map(ReportDto::fromReport).collect(Collectors.toList()),
                        HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/rest/findAllReportsSortedAudience")
    public ResponseEntity<HashMap<Audience, List<ReportDto>>> getAllReportsSortedByAudience(){
        List<Audience> audiences = audienceService.findAll();
        if (audiences.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            HashMap<Audience, List<ReportDto>> hashMap = audiences.stream()
                    .collect(Collectors.toMap(audience -> audience,
                            audience -> reportService.findByAudience(audience)
                    .stream().map(ReportDto::fromReport).collect(Collectors.toList()),
                            (a, b) -> b, HashMap::new));
            return new ResponseEntity<>(hashMap, HttpStatus.OK);
        }
    }
}

