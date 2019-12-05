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
                Customer customer = new Customer("Vk", "(495)123456", "Saint-Peterburg, st. Nevkaya, 28", 1);
                Calendar calendar = new GregorianCalendar(2006, Calendar.OCTOBER, 1);
                Order order = new Order(1,customer, calendar, 40000);

            Customer customer2 = new Customer("Telegram", "(495)654321", "Moscow, Not found information, -", 2);
            Calendar calendar2 = new GregorianCalendar(2019, Calendar.DECEMBER, 5);
            Order order2 = new Order(2,customer2, calendar2, 55000);

            Customer customer3 = new Customer("Instagram", "4375885", "New York, st. Wanamakers, 12 ", 3);
            Calendar calendar3 = new GregorianCalendar(2006, Calendar.OCTOBER, 6);
            Order order3 = new Order(3,customer3, calendar3, 65000);

            OrderModel orderModel = new OrderModel();
            orderModel.add(order);
            orderModel.add(order2);
            orderModel.add(order3);
            CustomerModel customerModel = new CustomerModel();
            customerModel.add(customer);
            customerModel.add(customer2);
            customerModel.add(customer3);

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
