import Info.Customer;
import Info.Order;
import MVC.Controller;
import MVC.CustomerModel;
import MVC.OrderModel;
import MVC.View;
import SaveService.FileView;
import SaveService.SavingAndDownload;

import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main implements Serializable {
    public static void main(String[] args) {
        View view = new View();
        try {
                Customer customer = new Customer("Test", "999999", "Test street, 9", 1);
                Calendar calendar = new GregorianCalendar(2019, Calendar.DECEMBER, 5);
                Order order = new Order(1,customer, calendar, 250000);
            OrderModel orderModel = new OrderModel();
            orderModel.add(order);
            CustomerModel customerModel = new CustomerModel();
            customerModel.add(customer);

            FileView fileView = new FileView();
            fileView.setOrderList(orderModel.getRuntime());
            fileView.setCustomerList(customerModel.getRuntime());
            SavingAndDownload.save(fileView);

                Controller controller = new Controller();
                controller.start();

        } catch (IOException | ClassNotFoundException e) {
            view.outInfo("Incorrect data base!");
            e.printStackTrace();
        }
    }
}
