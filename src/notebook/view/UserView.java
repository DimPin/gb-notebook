package notebook.view;

import notebook.controller.UserController;
import notebook.model.User;
import notebook.util.Commands;

import java.util.List;
import java.util.Scanner;

public class UserView {
    private final UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void run(){
        Commands com;

        while (true) {
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    String firstName = prompt("Имя: ");
                    String lastName = prompt("Фамилия: ");
                    String phone = prompt("Номер телефона: ");
                    userController.saveUser(new User(firstName, lastName, phone));
                    break;
                case READ:
                    String id = prompt("Идентификатор пользователя: ");
                    try {
                        User user = userController.readUser(Long.parseLong(id));
                        System.out.println(user);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case LIST:
                    List<User> users = userController.getAllUsers();
                    for(User user: users) {
                        System.out.println(user);
                    }
                    break;
                case UPDATE:
                    long userId = Long.parseLong(prompt("Введите id пользователя: "));
                    String updateName = prompt("Имя: ");
                    String updateLastName = prompt("Фамилия: ");
                    String updatePhone = prompt("Номер телефона: ");
                    User updatedUser = new User(updateName, updateLastName, updatePhone);
                    userController.userUpdate(userId, updatedUser);
                    break;
                case REMOVE:
                    long userRemoveId = Long.parseLong(prompt("Введите id пользователя: "));
                    userController.userRemove(userRemoveId);
                    break;
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}