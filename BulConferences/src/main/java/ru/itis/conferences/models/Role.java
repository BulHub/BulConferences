package ru.itis.conferences.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

/**
 * Roles of various entities
 * @author Bulat Bilalov
 * @version 1.0
 */
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
@Builder
public class Role extends BaseEntity implements GrantedAuthority {

    /** Role name */
    @Column(name = "name")
    private String name;

    /** Users with this role */
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;

    /** @return Returns the name of the role */
    @Override
    public String getAuthority() {
        return name;
    }
}
