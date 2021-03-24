package ru.itis.conferences.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString(exclude = "users")
@Table(name = "conference")
@EqualsAndHashCode(exclude = "users")
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "conference_user",
            joinColumns = {@JoinColumn(name = "conference_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    private Set<User> users;
}
