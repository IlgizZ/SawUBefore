package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Point;

/**
 * Created by mikl on 30.04.2016.
 */
@Repository
public interface PointRepository extends JpaRepository<Point,Long> {

}
