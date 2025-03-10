package main.lessons_18;


import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;



public class UserRepository {

        private final List<User> users;

        public UserRepository() {
            users = new ArrayList<>();
            users.add(new User(1, "Valentime", "valentimelox@gmail.com"));
            users.add(new User(2, "Turok", "turcia@gmail.com"));
            users.add(new User(3, "Komarik", "kvnsila@gmail.com"));
            users.add(new User(4, "Psveshe4ka", "psveshka@gmail.com"));
        }

    public Optional<User> findUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst();
    }
    public Optional<User> findUserByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equalsIgnoreCase(email)).findFirst();
    }
    public Optional<List<User>> findAllUsers() {
        return users.isEmpty() ? Optional.empty() : Optional.of(users);
    }
}

