package com.labia.gradeReport.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.labia.gradeReport.dto.reponse.UserDetail;
import com.labia.gradeReport.models.Users;
import com.labia.gradeReport.repository.UsersRepository;
import com.labia.gradeReport.security.UserRole;

import antlr.collections.List;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailService implements UserDetailsService{
	private final UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return selectUserByUsername(username)
                .orElseThrow(() ->
                new UsernameNotFoundException(String.format("Username %s not found", username))
        );
	}
	
	
	private Optional<UserDetail> selectUserByUsername(String username) {
		Users users = usersRepository.getByEmail(username);
		UserDetail userDetail = null;
		switch (users.getRoles()) {
		case 1:
			userDetail = new UserDetail(users.getEmail(), users.getPassword(), UserRole.ADMIN.getGrantedAuthorities(), true, true ,true, true);
			break;
		case 2:
			userDetail = new UserDetail(users.getEmail(), users.getPassword(), UserRole.LECTURE.getGrantedAuthorities(), true, true ,true, true);
		case 3:
			userDetail = new UserDetail(users.getEmail(), users.getPassword(), UserRole.STUDENT.getGrantedAuthorities(), true, true ,true, true);
		default:
			break;
		}
        return Optional.of(userDetail);
    }
}
