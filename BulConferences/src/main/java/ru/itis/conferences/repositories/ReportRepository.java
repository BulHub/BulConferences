package ru.itis.conferences.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.conferences.models.Audience;
import ru.itis.conferences.models.Report;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    Optional<Report> findByName(String name);
    List<Report> findByAudience(Audience audience);
}
