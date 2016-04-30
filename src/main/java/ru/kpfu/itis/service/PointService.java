package ru.kpfu.itis.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Point;

/**
 * Created by Ilgiz on 30.04.2016.
 */
@Service
public interface PointService {
    public void savePoint(Point point);
}
