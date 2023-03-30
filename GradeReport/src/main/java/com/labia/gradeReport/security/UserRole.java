package com.labia.gradeReport.security;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum UserRole {
	ADMIN(newHashSet(
			UserPermission.STUDENT_GRADE_READ_ALL, 
			UserPermission.STUDENT_GRADE_WRITE_ALL,
			UserPermission.STUDENT_GRADE_UPDATE_ALL,
			UserPermission.STUDENT_GRADE_DELETE_ALL,
			UserPermission.STUDENT_GRADE_READ_INDIVIDUAL,
			UserPermission.STUDENT_GRADE_WRITE_INDIVIDUAL,
		    UserPermission.STUDENT_GRADE_UPDATE_INDIVIDUAL,
		    UserPermission.STUDENT_GRADE_DELETE_INDIVIDUAL,
		    UserPermission.CURICULLUM_READ,
		    UserPermission.CURICULLUM_WRITE)),
	
	LECTURE(newHashSet(
			UserPermission.STUDENT_GRADE_READ_ALL, 
			UserPermission.STUDENT_GRADE_WRITE_ALL,
			UserPermission.STUDENT_GRADE_UPDATE_ALL,
			UserPermission.STUDENT_GRADE_DELETE_ALL,
			UserPermission.STUDENT_GRADE_READ_INDIVIDUAL,
			UserPermission.STUDENT_GRADE_WRITE_INDIVIDUAL,
		    UserPermission.STUDENT_GRADE_UPDATE_INDIVIDUAL,
		    UserPermission.STUDENT_GRADE_DELETE_INDIVIDUAL,
		    UserPermission.CURICULLUM_READ
			)),
	
	STUDENT(newHashSet(
			UserPermission.STUDENT_GRADE_READ_INDIVIDUAL,
			UserPermission.CURICULLUM_READ));
	
	private final Set<UserPermission> permissions;

	private UserRole(Set<UserPermission> permissions) {
		this.permissions = permissions;
	}
	
	public static final <T> Set<T> newHashSet(T... objs) {
	    Set<T> set = new HashSet<T>();
	    Collections.addAll(set, objs);
	    return set;
	}
	
	public Set<UserPermission> getPermissions() {
        return permissions;
    }
	
	public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
