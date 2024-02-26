package org.example.service;

import org.example.model.User;
import org.example.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserService userService;


    @Test
    public void InsertUser() {
        // Instantiate a user
        User userToInsert = new User();
        userToInsert.setUserID(3);
        userToInsert.setUsername("testUser");
        userToInsert.setEmail("test@example.com");
        userToInsert.setPassword("123456789");


        when(userService.createUser(any(User.class))).thenReturn(userToInsert);

        User insertedUser = userService.createUser(userToInsert);
        System.out.println(insertedUser.getUsername());


        assertNotNull(insertedUser);

    }
}
