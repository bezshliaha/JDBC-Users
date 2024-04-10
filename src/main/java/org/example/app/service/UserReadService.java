package org.example.app.service;

import org.example.app.repository.UserReadRepository;
import org.example.app.entity.User;
import org.example.app.utils.Constants;


import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UserReadService {
    UserReadRepository repository;

    public UserReadService(UserReadRepository repository) {
        this.repository = repository;
    }

    public String readUsers() {
        List<User> list = repository.readUsers();
        if (list != null) {
            if (!list.isEmpty()) {
                AtomicInteger cnt = new AtomicInteger(1);
                StringBuilder sb = new StringBuilder();
                list.forEach((user ->
                        sb.append(cnt.getAndIncrement())
                                .append(") id: ")
                                .append(user.getId())
                                .append(", ")
                                .append(user.getName())
                                .append(", ")
                                .append(user.getEmail())
                                .append("\n")
                ));
                return "\n--------USERS--------\n" + sb;

            } else return Constants.DATA_ABSENT_MSG;
        } else return Constants.DATA_ABSENT_MSG;
    }
}
