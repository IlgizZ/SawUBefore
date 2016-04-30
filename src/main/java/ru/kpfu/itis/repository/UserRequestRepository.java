package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.UserRequest;

/**
 * Created by Ilgiz on 30.04.2016.
 */
@Repository
public interface UserRequestRepository extends JpaRepository<UserRequest, Long> {
}
