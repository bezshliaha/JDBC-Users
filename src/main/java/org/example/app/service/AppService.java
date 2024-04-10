package org.example.app.service;

import org.example.app.controller.UserCreateController;
import org.example.app.controller.UserDeleteController;
import org.example.app.controller.UserReadController;
import org.example.app.controller.UserUpdateController;
import org.example.app.repository.UserCreateRepsitory;
import org.example.app.repository.UserDeleteRepository;
import org.example.app.repository.UserReadRepository;
import org.example.app.repository.UserUpdateRepository;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.view.UserCreateView;
import org.example.app.exeptions.OptionException;
import org.example.app.view.UserDeleteView;
import org.example.app.view.UserReadView;
import org.example.app.view.UserUpdateView;

public class AppService {
    public void createUser() {
        UserCreateRepsitory repsitory = new UserCreateRepsitory();
        UserCreateService service = new UserCreateService(repsitory);
        UserCreateView view = new UserCreateView();
        UserCreateController controller = new UserCreateController(service, view);
        controller.createUser();
    }

    public void readUsers() {
        UserReadRepository repsitory = new UserReadRepository();
        UserReadService service = new UserReadService(repsitory);
        UserReadView view = new UserReadView();
        UserReadController controller = new UserReadController(service, view);
        controller.readUsers();
    }

    public void deleteUser() {
        UserDeleteRepository repsitory = new UserDeleteRepository();
        UserDeleteService service = new UserDeleteService(repsitory);
        UserDeleteView view = new UserDeleteView();
        UserDeleteController controller = new UserDeleteController(service, view);
        controller.deleteUser();
    }

    public void updateUser() {
        UserUpdateRepository repsitory = new UserUpdateRepository();
        UserUpdateService service = new UserUpdateService(repsitory);
        UserUpdateView view = new UserUpdateView();
        UserUpdateController controller = new UserUpdateController(service, view);
        controller.updateUser();
    }

    public void getNoSuchOption(int choice) {
        int[] menuChoices = {0, 1, 2, 3, 4};
        if (!contains(menuChoices, choice)) {
            try {
                throw new OptionException(Constants.INCORRECT_VALUE_MSG);
            } catch (OptionException e) {
                System.out.println(e.getMessage());
                AppStarter.startApp();
            }
        }
    }

    public static boolean contains(final int[] options, final int value) {
        boolean result = false;
        for (int i : options) {
            if (i == value) {
                result = true;
                break;
            }
        }
        return result;
    }
}
