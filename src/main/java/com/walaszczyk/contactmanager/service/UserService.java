package com.walaszczyk.contactmanager.service;

import com.walaszczyk.contactmanager.domain.User;
import com.walaszczyk.contactmanager.dto.UserDataDTO;
import com.walaszczyk.contactmanager.repository.UserRepository;
import com.walaszczyk.contactmanager.security.JWTAuthenticationFilter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private ModelMapper modelMapper;


    public String signUp(UserDataDTO userDto) {
        User user = modelMapper.map(userDto, User.class);
        user = userRepository.save(user);
        return JWTAuthenticationFilter.generateToken(user.getEmail());
    }
}
