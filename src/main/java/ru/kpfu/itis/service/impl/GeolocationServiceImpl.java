package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.repository.GeolocationRepository;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.GeolocationService;


@Service
public class GeolocationServiceImpl implements GeolocationService {
    @Autowired
    GeolocationRepository geolocationRepository;

    @Autowired
    UserRepository userRepository;

}
