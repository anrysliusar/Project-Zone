package com.sliusar.projectzone.security.config;

import com.sliusar.projectzone.models.User;
import com.sliusar.projectzone.services.implementation.UserServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailService implements UserDetailsService {

    private UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        return CustomUserDetails.fromUserEntityToUserDetails(user);
    }
}
