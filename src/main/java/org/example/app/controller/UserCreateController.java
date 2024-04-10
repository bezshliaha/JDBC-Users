package org.example.app.controller;

import org.example.app.service.UserCreateService;
import org.example.app.utils.AppStarter;
import org.example.app.view.UserCreateView;

public class UserCreateController {
    UserCreateView view;
    UserCreateService service;

    public UserCreateController(UserCreateService service, UserCreateView view) {
        this.view = view;
        this.service = service;
    }

    public void createUser() {
        view.getOutput(service.createUser(view.getData()));
        AppStarter.startApp();
    }
}
