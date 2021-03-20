package ru.itis.conferences.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import ru.itis.conferences.models.Audience;
import ru.itis.conferences.models.Report;
import ru.itis.conferences.repositories.ReportRepository;
import ru.itis.conferences.services.AudienceService;
import ru.itis.conferences.services.ConferenceService;
import ru.itis.conferences.services.ReportService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    private final AudienceService audienceService;
    private final ConferenceService conferenceService;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository, AudienceService audienceService, ConferenceService conferenceService) {
        this.reportRepository = reportRepository;
        this.audienceService = audienceService;
        this.conferenceService = conferenceService;
    }

    @Override
    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public Optional<Report> find(String name) {
        return reportRepository.findByName(name);
    }

    @Override
    public void delete(Report entity) {
        reportRepository.delete(entity);
    }

    @Override
    public void add(Report entity) {
        reportRepository.save(entity);
    }

    @Override
    public List<Report> findByAudience(Audience audience) {
        return reportRepository.findByAudience(audience);
    }

    @Override
    public void fillingTheEntity(Report report, String conference,
                                 String audience, String start_date,
                                 String finish_date){
        report.setConference(conferenceService.find(conference).get());
        report.setAudience(audienceService.findByNumber(Long.parseLong(audience)).get());
        report.setStartDate(LocalDateTime.parse(start_date));
        report.setFinishDate(LocalDateTime.parse(finish_date));
    }

    @Override
    public StringBuilder checkingDataForCreateReports(Report report, ModelMap map){
        StringBuilder builder = new StringBuilder();
        if (report.getStartDate() == null) builder.append("The start date of the report cannot be empty ");
        if (report.getFinishDate() == null) builder.append("The end date of the report cannot be empty ");
        Optional<Report> optionalReport = reportRepository.findByName(report.getName());
        if (optionalReport.isPresent()){
            builder.append("This conference name is already taken ");
        }
        return builder;
    }

    @Override
    public Optional<Report> areTheseDatesBusyInTheAudience(LocalDateTime start, LocalDateTime finish, Long number) {
        Optional<Audience> optionalAudience = audienceService.findByNumber(number);
        if(optionalAudience.isPresent()){
            Audience audience = optionalAudience.get();
            List<Report> reports = findByAudience(audience);
            for (Report report: reports) {
                if(!(start.isAfter(report.getStartDate()) && finish.isAfter(report.getFinishDate()))
                && !(start.isBefore(report.getStartDate()) && finish.isBefore(report.getFinishDate()))){
                    return Optional.of(report);
                }
            }
        }
        return Optional.empty();
    }
}
