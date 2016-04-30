package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Push;

import java.util.List;

/**
 * Created by mikl on 30.04.2016.
 */
@Repository
public interface PushRepository extends JpaRepository<Push, Long> {
    @Query(value = "SELECT * FROM push WHERE form_user_id = :id AND is_read = false", nativeQuery = true)
    List<Push> findNotReadPush(@Param("id") Long id);
}
