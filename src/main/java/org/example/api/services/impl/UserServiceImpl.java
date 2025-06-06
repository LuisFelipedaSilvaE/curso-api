package org.example.api.services.impl;

import org.example.api.domain.User;
import org.example.api.domain.dto.UserDTO;
import org.example.api.repositories.UserRepository;
import org.example.api.services.UserService;
import org.example.api.services.exceptions.DataIntegrityViolationException;
import org.example.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> user = repository.findById(id);

        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User create(UserDTO userDTO) {
        findByEmail(userDTO);
        return repository.save(mapper.map(userDTO, User.class));
    }

    @Override
    public User update(UserDTO userDTO) {
        findByEmail(userDTO);
        return repository.save(mapper.map(userDTO, User.class));
    }

    private void findByEmail(UserDTO userDTO) {
        Optional<User> user = repository.findByEmail(userDTO.getEmail());
        if (user.isPresent() && !user.get().getId().equals(userDTO.getId())) {
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema");
        }
    }
}
