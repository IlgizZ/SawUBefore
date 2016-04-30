package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.kpfu.itis.model.Push;

import java.util.List;

/**
 * Created by mikl on 30.04.2016.
 */
public interface PushRepository extends JpaRepository<Push, Long> {

}
