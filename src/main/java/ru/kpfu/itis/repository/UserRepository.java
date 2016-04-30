package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.User;

import java.util.List;

/**
 * Created by mikl on 30.04.2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM Users where sex = :sex", nativeQuery = true)
    List<User> findUsersByParams(@Param("sex") String sex);
}
