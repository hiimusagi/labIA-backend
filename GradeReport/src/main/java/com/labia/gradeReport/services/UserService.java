package com.labia.gradeReport.services;

import com.labia.gradeReport.models.Users;
import com.labia.gradeReport.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> users = usersRepository.findByEmail(username);
        if(users.isPresent()){
            return users.get();
        }
        return null;
    }

    public Users getAuthenticatedUser(Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();
        Optional<Users> users = usersRepository.findByEmail(email);
        if (!users.isPresent()){
            throw new NullPointerException("Can't get User !!!");
        }
        return users.get();
    }
}
