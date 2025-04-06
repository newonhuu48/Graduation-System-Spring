package com.graduation.services;

import com.graduation.data.entity.Role;
import com.graduation.data.entity.User;
import com.graduation.data.repository.UserRepository;
import com.graduation.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    UserRepository userRepository;

    public List<User> getAllUsers() {return userRepository.findAll();}


    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException(username);
        }

        return user;
    }


}
