package com.project.Scrum.APP.controllers;

import com.project.Scrum.APP.models.ERole;
import com.project.Scrum.APP.models.User;
import com.project.Scrum.APP.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockController;

    private User user;
    private User userAdmin;
    private User userManager;
    private List<User> userList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockController = MockMvcBuilders.standaloneSetup(userController).build();

        user = new User();
        user.setId(3);
        user.setUsername("Valen");
        user.setPassword("1234");
        user.setRole(ERole.USER);

        userAdmin = new User();
        userAdmin.setId(1);
        userAdmin.setUsername("Ana");
        userAdmin.setPassword("1234");
        userAdmin.setRole(ERole.ADMIN);

        userManager = new User();
        userManager.setId(2);
        userManager.setUsername("Kris");
        userManager.setPassword("1234");
        userManager.setRole(ERole.MANAGER);


        userList.add(userAdmin);
        userList.add(userManager);
        userList.add(user);

    }

    @Test
    void test_Create_Admin() throws Exception {
        when(userService.createUser(any(User.class))).thenReturn(userAdmin);

        String adminJson =
                "{\"id\": 1,\n"
                + "\"username\": \"Ana\",\n"
                + "\"password\": \"1234\",\n"
                + "\"role\": \"ADMIN\"}";

        mockController
                .perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(adminJson))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"id\": 1,\n"
                        + "\"username\": \"Ana\",\n"
                        + "\"password\": \"1234\",\n"
                        + "\"role\": \"ADMIN\"}"));
    }

    @Test
    void test_Create_Manager() throws Exception {
        when(userService.createUser(any(User.class))).thenReturn(userManager);

        String managerJson =
                "{\"id\": 2,\n"
                + "\"username\": \"Kris\",\n"
                + "\"password\": \"1234\",\n"
                + "\"role\": \"MANAGER\"}";

        mockController
                .perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(managerJson))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"id\": 2,\n"
                        + "\"username\": \"Kris\",\n"
                        + "\"password\": \"1234\",\n"
                        + "\"role\": \"MANAGER\"}"));
    }

    @Test
    void test_Create_User() throws Exception {
        when(userService.createUser(any(User.class))).thenReturn(user);

        String userJson =
                "{\"id\": 3,\n"
                + "\"username\": \"Valen\",\n"
                + "\"password\": \"1234\",\n"
                + "\"role\": \"USER\"}";

        mockController
                .perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"id\": 3,\n"
                        + "\"username\": \"Valen\",\n"
                        + "\"password\": \"1234\",\n"
                        + "\"role\": \"USER\"}"));
    }

}