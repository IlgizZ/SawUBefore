package ru.kpfu.itis.service;

import ru.kpfu.itis.model.Push;

import java.util.List;

/**
 * Created by mikl on 30.04.2016.
 */
public interface PushService {
    public List<Push> findNotReadPush(Long id);
}
