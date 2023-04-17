package com.amir.Diploma.services;

import com.amir.Diploma.dtos.RegistrationUserDTO;
import com.amir.Diploma.exceptions.UserAlreadyExistException;
import com.amir.Diploma.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {

    public User registerNewUserAccount(RegistrationUserDTO userDto) throws UserAlreadyExistException;

    User getUserById(Long id);

    List<User> getAllUsers();
}
