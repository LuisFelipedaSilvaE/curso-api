package org.example.api.services;

import org.example.api.domain.User;

public interface UserService {

    User findById(Integer id);
}
