package main.lessons_18;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();


        int searchId = 2;
        userRepository.findUserById(searchId).ifPresentOrElse(
                user -> System.out.println(user),
                () -> System.out.println("Не найден" + searchId));

        String searchEmail = "kvnsila@gmail.com";
        userRepository.findUserByEmail(searchEmail).ifPresentOrElse(
                user -> System.out.println(user),
                () -> System.out.println(searchEmail + " не найден"));


        userRepository.findAllUsers().ifPresentOrElse(
                userList -> System.out.println("Всего пользователей: " + userList.size()),
                () -> System.out.println("Тут пусто никто не зарегался"));

    }
}
