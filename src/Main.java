import Info.Customer;
import MVC.Controller;
import MVC.CustomerModel;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Customer customer = new Customer("Alex", "13371448", "Moskovskaya street, 58", 1);
            CustomerModel customerModel = new CustomerModel();
            customerModel.add(customer);
            Controller.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
