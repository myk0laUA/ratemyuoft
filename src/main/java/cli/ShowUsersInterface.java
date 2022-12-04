package cli;

import logInInterfaceAdapter.LogInController;
import logInInterfaceAdapter.LogInPresenter;

import java.io.IOException;
import java.util.Scanner;

public interface ShowUsersInterface {
    void showUsers(Scanner scanner, LogInPresenter logInPresenter, LogInController logInController)
            throws IOException, ClassNotFoundException;

}