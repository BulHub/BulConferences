package ru.itis.conferences.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.conferences.models.Conference;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConferenceDto {

    private String name;
    private String description;

    public Conference toConference() {
        return Conference.builder()
                .name(name)
                .description(description)
                .build();
    }

    public static ConferenceDto fromConference(Conference conference) {
        return ConferenceDto.builder()
                .name(conference.getName())
                .description(conference.getDescription())
                .build();
    }
}
