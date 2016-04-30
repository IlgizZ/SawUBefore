package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Point;
import ru.kpfu.itis.repository.PointRepository;
import ru.kpfu.itis.service.PointService;

/**
 * Created by mikl on 30.04.2016.
 */
@Service
public class PointServiceImpl implements PointService {
    @Autowired
    PointRepository pointRepository;

    @Override
    public void savePoint(Point point) {
        pointRepository.save(point);
    }
}
