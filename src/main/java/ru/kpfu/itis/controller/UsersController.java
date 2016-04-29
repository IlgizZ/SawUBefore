package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.form.GeolocationForm;
import ru.kpfu.itis.model.Geolocation;
import ru.kpfu.itis.model.Push;
import ru.kpfu.itis.repository.GeolocationRepository;
import ru.kpfu.itis.util.TransformGeolocationFomToGeolocation;

@Controller
@RequestMapping(value = "/users/")
public class UsersController {
    @Autowired
    TransformGeolocationFomToGeolocation transformGeolocationFomToGeolocation;

    @Autowired
    GeolocationRepository geolocationRepository;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Push saveGeolocation(@RequestParam GeolocationForm geolocationForm) {
        Geolocation geolocation = transformGeolocationFomToGeolocation.apply(geolocationForm);
        geolocationRepository.save(geolocation);
        return null;
    }

}
