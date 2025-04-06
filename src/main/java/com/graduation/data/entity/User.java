package com.graduation.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.bytebuddy.dynamic.ClassFileLocator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;



    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }


    @Override
    public HashSet<SimpleGrantedAuthority> getAuthorities() {

        //THINK ABOUT THIS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        @SuppressWarnings("unchecked")
        HashSet<SimpleGrantedAuthority> authorities = (HashSet<SimpleGrantedAuthority>)SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        //authorities.add( new SimpleGrantedAuthority(this.role) );

        return authorities;
    }
}
