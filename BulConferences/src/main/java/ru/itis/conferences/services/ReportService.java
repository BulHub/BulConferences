package ru.itis.conferences.services;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import ru.itis.conferences.models.Audience;
import ru.itis.conferences.models.Report;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public interface ReportService {
    List<Report> findAll();

    Optional<Report> find(String name);

    void delete(Report entity);

    void add(Report entity);

    List<Report> findByAudience(Audience audience);

    StringBuilder checkingDataForCreateReportsAddFillingTheEntity(Report report, String start_date,
                                               String finish_date);

    Optional<Report> areTheseDatesBusyInTheAudience(LocalDateTime start,
                                                    LocalDateTime finish,
                                                    Long number);

    void update(Report oldReport, Report newReport);
}
