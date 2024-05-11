package com.example.Meeting.Repository;
import com.example.Meeting.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User save(User user);
    User findUserById(Long id);
}
