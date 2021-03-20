package ru.itis.conferences.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="conference_id")
    private Conference conference;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "audience_id")
    private Audience audience;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "finish_date")
    private LocalDateTime finishDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "report_user",
            joinColumns = {@JoinColumn(name = "report_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    private List<User> users;
}
