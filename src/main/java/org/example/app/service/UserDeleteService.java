package org.example.app.service;

import org.example.app.exeptions.UpdateException;
import org.example.app.repository.UserDeleteRepository;
import org.example.app.utils.Constants;
import org.example.app.utils.IdValidator;
import org.example.app.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserDeleteService {
    UserDeleteRepository repository;

    public UserDeleteService(UserDeleteRepository repository) {
        this.repository = repository;
    }

    public String deleteUser(String[] data) {
        Map<String, String> errors = validateData(data);
        if (!errors.isEmpty()) {
            try {
                throw new UpdateException("Check inputs", errors);
            } catch (UpdateException ue) {
                return ue.getErrors(errors);
            }
        }
        return repository.deleteUser(covertData(data));
    }

    private Map<String, String> validateData(String[] data) {
        Map<String, String> errors = new HashMap<>();
        if (IdValidator.isIdValid(data[0]))
            errors.put("id", Constants.WRONG_ID_MSG);
        return errors;
    }

    private User covertData(String[] data) {
        User user = new User();
        user.setId(Integer.parseInt(data[0]));
        return user;
    }
}
