package com.project.Scrum.APP.services;

import com.project.Scrum.APP.models.Role;
import com.project.Scrum.APP.models.User;
import com.project.Scrum.APP.repositories.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private IUserRepository iUserRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        user = new User();
        user.setId(1);
        user.setUsername("Ana");
        user.setPassword("1234");
        user.setRole(Role.ADMIN);
    }

    @Test
    void test_Create_User() {
        when(iUserRepository.save(any(User.class))).thenReturn(user);

        User user1 = userService.createUser(user);

        assertNotNull(user1);
        assertEquals("Ana", user1.getUsername());
        assertEquals("1234", user1.getPassword());
        assertEquals(Role.ADMIN, user1.getRole());


        verify(iUserRepository, times(1)).save(any(User.class));
    }

    @Test
    void deleteUser() {
        when(iUserRepository.findById(2)).thenReturn(Optional.of(user));

        userService.deleteUser(2);

        verify(iUserRepository, times(1)).deleteById(2);
    }
}
