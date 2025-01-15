package com.forohub.alura.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Aquí puedes conectar tu lógica para obtener usuarios desde una base de datos
        if ("admin".equals(username)) {
            return User.builder()
                    .username("admin")
                    .password("{noop}password") // {noop} para usar contraseña sin encriptar
                    .roles("ADMIN")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }
}
