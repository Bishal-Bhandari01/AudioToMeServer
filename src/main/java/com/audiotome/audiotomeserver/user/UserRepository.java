package com.audiotome.audiotomeserver.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    List<User> findByRegistrationDate(LocalDate today);

    List<User> findByRegistrationDateBetween(LocalDate startDate, LocalDate endDate);

//    @Modifying
//    @Query("UPDATE _user u SET u.password=:pass WHERE u.email=:email")
//    void updatePasswordByEmail(String email,String pass);
}
