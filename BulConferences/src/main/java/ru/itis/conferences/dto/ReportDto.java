package ru.itis.conferences.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.conferences.models.Audience;
import ru.itis.conferences.models.Report;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportDto {

    private String name;
    private ConferenceDto conferenceDto;
    private Audience audience;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;

    public Report toReport() {
        return Report.builder()
                .name(name)
                .conference(conferenceDto.toConference())
                .audience(audience)
                .startDate(startDate)
                .finishDate(finishDate)
                .build();
    }

    public static ReportDto fromReport(Report report) {
        return ReportDto.builder()
                .name(report.getName())
                .conferenceDto(ConferenceDto.fromConference(report.getConference()))
                .startDate(report.getStartDate())
                .finishDate(report.getFinishDate())
                .build();
    }
}
