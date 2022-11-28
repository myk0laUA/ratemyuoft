package cli;

import filterInterfaceAdapters.FilterFailError;
import interfaceAdapter.Controller;
import interfaceAdapter.Presenter;
import useCase.InvalidInputException;

import java.io.IOException;
import java.util.Scanner;

public class WelcomeMenu implements WelcomeMenuInterface{
    @Override
    public void displayWelcomeMenu(Presenter presenter) {
        presenter.outputMessage("\n" + "Avaliable Actions" + "\n" + "1. Register as new User" + "\n" +
                "2. Log in (if you already have an account)" + "\n");
        presenter.outputMessage("Please, enter the number of the option to proceed"+ "\n");
    }

    @Override
    public void choseLoginOrRegister(Scanner scanner, Controller controller, Presenter presenter,
                                     RegisterInterface registerInterface, LogInInterface logInInterface,
                                     MainMenuInterface mainMenuInterface,
                                     ShowUsersInterface showUsersInterface, Filter filter)
            throws IOException, ClassNotFoundException, InvalidInputException, FilterFailError {

        String choice = scanner.nextLine();
        if(choice.contains("1")){

            registerInterface.register(scanner,controller,presenter,mainMenuInterface,
                    this ,logInInterface,showUsersInterface, filter);


        } else if (choice.contains("2")) {
            logInInterface.login(scanner,controller,presenter, mainMenuInterface,
                    this,registerInterface,showUsersInterface, filter);

        } else{
            displayWelcomeMenu(presenter);
            choseLoginOrRegister(scanner,controller,presenter,registerInterface,logInInterface,
                    mainMenuInterface,showUsersInterface, filter);
        }
    }
}
