package ru.itis.conferences.controllers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.itis.conferences.config.SpringSecurityWebAuxTestConfig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SpringSecurityWebAuxTestConfig.class
)
@AutoConfigureMockMvc
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithUserDetails("admin@company.com")
    void getAdminPage() throws Exception {
        this.mockMvc.perform(get("/admin/users"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void remoteUser() {
    }

    @Test
    @WithUserDetails("listener@company.com")
    void getPageForCreateUser() throws Exception {
        this.mockMvc.perform(get("/admin/creature"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    void addNewUser() {
    }

    @Test
    void getPageForDeleteUser() {
    }

    @Test
    @WithUserDetails("presenter@company.com")
    void getPageForUpdateUser() throws Exception {
        this.mockMvc.perform(get("/admin/update"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    void updateUser() {
    }
}