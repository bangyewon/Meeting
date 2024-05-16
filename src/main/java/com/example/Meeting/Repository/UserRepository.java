package com.example.Meeting.Repository;
import com.example.Meeting.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User save(User user);
    User findUserById(Long id);
    void deleteById(Long id);
    Optional<User> findByLoginId(String email); //못찾을 수도 있기에 Optinal

}

