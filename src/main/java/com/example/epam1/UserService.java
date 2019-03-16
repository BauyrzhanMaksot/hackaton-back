package com.example.epam1;

import com.example.epam1.repository.RoleRepository;
import com.example.epam1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public User register(UserDto userDto) {
        if (userDto.getLogin() == null || userDto.getPassword() == null || userDto.getEmail() == null) {
            return null;
        }
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Optional<Role> role = roleRepository.findById(Long.valueOf(1));
        if (role.isPresent()){
            user.setRole(role.get());
        }
        user.setEmail(userDto.getEmail());
        return userRepository.save(user);
    }

    public User getUser() {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByLogin(login);
    }

    public HttpStatus updateUser(User user) {
        userRepository.save(user);
        return HttpStatus.OK;
    }
}
