package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.model.User;

/**
 * Created by mikl on 30.04.2016.
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
