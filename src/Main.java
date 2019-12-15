import Info.Customer;
import Info.Order;
import MVC.*;
import SaveService.FileView;
import SaveService.SavingAndDownload;

import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main implements Serializable {
    public static void main(String[] args) {
        try {
            Customer customer = new Customer("Vk", "(495)123456", "Saint-Peterburg", 0);
            Calendar calendar = new GregorianCalendar(2006, Calendar.OCTOBER, 1);
            Order order = new Order(0,customer, calendar, 40000);

            Customer customer2 = new Customer("Telegram", "(495)654321", "Moscow", 1);
            Calendar calendar2 = new GregorianCalendar(2013, Calendar.AUGUST, 14);
            Order order2 = new Order(1,customer2, calendar2, 55000);

            Customer customer3 = new Customer("Instagram", "4375885", "New York", 2);
            Calendar calendar3 = new GregorianCalendar(2006, Calendar.OCTOBER, 6);
            Order order3 = new Order(2,customer3, calendar3, 65000);

            OrderModel orderModel = new OrderModel();
            orderModel.add(order);
            orderModel.add(order2);
            orderModel.add(order3);
            CustomerModel customerModel = new CustomerModel();
            customerModel.add(customer);
            customerModel.add(customer2);
            customerModel.add(customer3);
            SavingAndDownload storageService = new SavingAndDownload();
            View view = new View(orderModel, customerModel);
            FileView mainFileView = new FileView(customerModel.getRuntime(), orderModel.getRuntime());
            mainFileView.setOrderList(orderModel.getRuntime());
            mainFileView.setCustomerList(customerModel.getRuntime());
            storageService.save(mainFileView);
//
//           OrderModel orderModel = new OrderModel();
//           CustomerModel customerModel = new CustomerModel();
//           SavingAndDownload storageService = new SavingAndDownload();
//           View view = new View(orderModel, customerModel);
            Controller controller = new Controller(storageService,view);
            controller.start();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (BadInputExсeption e1) {
            e1.getMessage();
        }
    }
}