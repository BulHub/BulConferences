package ru.itis.conferences.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.conferences.dto.ReportDto;
import ru.itis.conferences.services.ReportService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest")
public class ReportRestController {

    private final ReportService reportService;

    @Autowired
    public ReportRestController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping(value = "/report/{name}")
    public ResponseEntity<ReportDto> getResumeByName(@PathVariable(name = "name") String name) {
        Optional<ReportDto> resume = reportService.find(name).map(ReportDto::fromReport);
        return resume.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/reports")
    public ResponseEntity<List<ReportDto>> getAllReports(){
        return new ResponseEntity<>(reportService.findAll()
                .stream().map(ReportDto::fromReport)
                .collect(Collectors.toList()),
                HttpStatus.OK);
    }
}
