package org.example.api.resources;

import org.example.api.domain.User;
import org.example.api.domain.dto.UserDTO;
import org.example.api.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService service;

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {

        return ResponseEntity.ok().body(mapper.map(service.findById(id), UserDTO.class));
    }
}
