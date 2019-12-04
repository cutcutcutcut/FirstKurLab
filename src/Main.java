import Info.Customer;
import MVC.Controller;
import MVC.CustomerModel;
import MVC.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        try {
                Controller controller = new Controller();
                controller.start();

        } catch (IOException | ClassNotFoundException e) {
            view.outInfo("Incorrect data base!");
        }
    }
}
