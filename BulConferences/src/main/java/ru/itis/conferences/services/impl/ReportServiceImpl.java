package ru.itis.conferences.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.conferences.models.Audience;
import ru.itis.conferences.models.Report;
import ru.itis.conferences.repositories.ReportRepository;
import ru.itis.conferences.services.AudienceService;
import ru.itis.conferences.services.ReportService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    private final AudienceService audienceService;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository, AudienceService audienceService) {
        this.reportRepository = reportRepository;
        this.audienceService = audienceService;
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
    public List<Report> findAllByAudience(Audience audience) {
        return reportRepository.findAllByAudience(audience);
    }

    @Override
    public Optional<Report> areTheseDatesBusyInTheAudience(LocalDateTime start, LocalDateTime finish, Long number) {
        Optional<Audience> optionalAudience = audienceService.findByNumber(number);
        if(optionalAudience.isPresent()){
            Audience audience = optionalAudience.get();
            List<Report> reports = findAllByAudience(audience);
        }
        return Optional.empty();
    }
}
