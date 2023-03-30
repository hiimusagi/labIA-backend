package com.labia.gradeReport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.labia.gradeReport.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
	
	@Query("SELECT u from Users u WHERE u.email like ?1")
	public Users getByEmail(String email);
	
	List<Users> findByEmail(String email);
}
