package org.example.alzo;

import org.example.alzo.daos.UserRepository;
import org.example.alzo.entities.User;
import org.example.alzo.servicesImp.UserServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class TestUserService extends MockitoExtension {
    @Mock
    private UserRepository userRepository ;
    @InjectMocks
    private UserServiceImp userServiceImp ;

    @Test
    void testGetTasksByUserId() {

        User user1 =User.builder().userID(1L).build() ;
        User user2 =User.builder().userID(2L).build();

        List<User> listUsers = List.of(user1,user2) ;


        when(userRepository.findAll()).thenReturn(listUsers);

        List<User> expectedUsers = userServiceImp.getAllUsers();

        Assertions.assertEquals(listUsers, expectedUsers);
    }

}
