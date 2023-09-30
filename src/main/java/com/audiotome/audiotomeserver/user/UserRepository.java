package com.audiotome.audiotomeserver.user;

<<<<<<< HEAD
import org.springframework.data.domain.Pageable;
=======
>>>>>>> 17faaac ( new server hosting)
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

<<<<<<< HEAD
public interface UserRepository extends JpaRepository<User,Long> {
=======
public interface UserRepository extends JpaRepository<User, Long> {
>>>>>>> 17faaac ( new server hosting)
    Optional<User> findByEmail(String email);
}
