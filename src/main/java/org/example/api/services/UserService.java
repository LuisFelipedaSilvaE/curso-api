package org.example.api.services;

import org.example.api.domain.User;
import org.example.api.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
    User create(UserDTO userDTO);
}
