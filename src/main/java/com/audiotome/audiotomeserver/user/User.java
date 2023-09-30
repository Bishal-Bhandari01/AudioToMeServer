package com.audiotome.audiotomeserver.user;
<<<<<<< HEAD
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
=======

import com.audiotome.audiotomeserver.role.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "_user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue
>>>>>>> 17faaac ( new server hosting)
    public Long id;
    public String firstName;
    public String lastName;
    public String middleName;
    public String email;
    public String dob;
    public String password;
    public String address;
    public String contactNum;
    public String uProfile;
<<<<<<< HEAD
    public UserEnum role;
    public String registerDate;
    public String lastLoginDate;

=======

    @Enumerated(EnumType.STRING)
    public Role role;

    public String registrationDate;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
>>>>>>> 17faaac ( new server hosting)
}
