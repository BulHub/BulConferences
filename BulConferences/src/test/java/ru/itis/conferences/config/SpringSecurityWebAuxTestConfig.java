package ru.itis.conferences.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import ru.itis.conferences.models.Role;
import ru.itis.conferences.models.Status;
import ru.itis.conferences.models.User;
import ru.itis.conferences.security.details.UserDetailsImpl;

import java.util.ArrayList;
import java.util.List;

@TestConfiguration
public class SpringSecurityWebAuxTestConfig {

    @Bean
    @Primary
    public UserDetailsService userDetailsService() {
        User listener = new User("listener@company.com", "password");
        listener.setStatus(Status.ACTIVE);
        List<Role> roles = new ArrayList<>();
        roles.add(Role.builder().name("ROLE_LISTENER").build());
        listener.setRoles(roles);

        User presenter = new User("presenter@company.com", "password");
        List<Role> roles1 = new ArrayList<>();
        presenter.setStatus(Status.ACTIVE);
        roles1.add(Role.builder().name("ROLE_PRESENTER").build());
        presenter.setRoles(roles1);

        User admin = new User("admin@company.com", "password");
        List<Role> roles2 = new ArrayList<>();
        admin.setStatus(Status.ACTIVE);
        roles2.add(Role.builder().name("ROLE_ADMIN").build());
        admin.setRoles(roles2);

        return new InMemoryUserDetailsManager(new UserDetailsImpl(listener),
                new UserDetailsImpl(presenter), new UserDetailsImpl(admin));
    }
}
