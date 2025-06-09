package org.example.api.resources;

import org.example.api.domain.User;
import org.example.api.domain.dto.UserDTO;
import org.example.api.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserResourceTest {

    @InjectMocks
    private UserResource resource;

    @Mock
    private UserServiceImpl service;

    @Mock
    private ModelMapper mapper;

    public static final Integer ID = 1;
    public static final String NAME = "Jonathan";
    public static final String EMAIL = "jona@gmail.com";
    public static final String PASSWORD = "J0J0";

    private User user;
    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUsers();
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    public void startUsers() {
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
    }
}