package com.labia.gradeReport.models;

import com.labia.gradeReport.security.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "passwords")
    private String userPassword;

    @Column(name = "roles")
    private Integer roles;

    @Column(name = "email")
    private String email;

    @Transient
    private final boolean isAccountNonExpired = true;

    @Transient
    private final boolean isAccountNonLocked = true;

    @Transient
    private final boolean isCredentialsNonExpired = true;

    @Transient
    private final boolean isEnabled = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        switch (roles){
            case 1: return Arrays.asList(new SimpleGrantedAuthority(UserRole.ADMIN.name()));
            case 2: return Arrays.asList(new SimpleGrantedAuthority(UserRole.LECTURE.name()));
            case 3: return Arrays.asList(new SimpleGrantedAuthority(UserRole.STUDENT.name()));
        }
        return null;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
