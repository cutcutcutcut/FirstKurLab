package MVC;

import Info.Customer;
import Info.Order;
import SaveService.FileView;
import SaveService.SavingAndDownload;

import java.io.*;
import java.util.GregorianCalendar;

/**
 * @author Alexey B
 * @version 1.4.2
 *
 * This class is a part of MVC, that realize interaction between user and program
 *
 */

public class Controller implements Serializable {

    private FileView fileView;
    private SavingAndDownload storageService;
    private View view;
    private OrderModel orderModel;
    private CustomerModel customerModel;

    /**
     * Constructor creates object of the Controller class to takes users command
     * @param storageService object of SavingAndDownload class for download and save values in database
     * @param view object of View class for output
     * @throws IOException exception class for output/input
     * @throws ClassNotFoundException exception class for class causes
     */
    public Controller(SavingAndDownload storageService, View view) throws IOException, ClassNotFoundException {
        this.storageService = storageService;
        this.fileView = storageService.download();
        this.view = view;
        orderModel = new OrderModel(fileView);
        customerModel = new CustomerModel(fileView);
    }

    /**
     * the container of commands names for user
     * contains constructor for link string to each element
     */
    private enum commands {

        getOrder("getOrderInfo"), getCustomer("getCustomerInfo"), setOrder("setOrder"), setCustomer("setCustomer"),addOrder("addOrder"),
        addCustomer("addCustomer"), deleteOrder("deleteOrder"), deleteCustomer("deleteCustomer"), clear("clear"), show("show"), exit("exit"),
        search("search"), addFromFile("addFromFile");

        private String title;
        commands(String title) {
            this.title = title;
        }

    }

    /**
     * Method output list of commands and their description
     */
    private void getCommandList() {
        view.outInfo("\nCommands:\n");
        view.outInfo(commands.getOrder + " - returns Order information from directory");                //+
        view.outInfo(commands.getCustomer + " - returns Customer information from directory");          //+
        view.outInfo(commands.setOrder + " - change an object of Order from directory");                //+
        view.outInfo(commands.setCustomer + " - change an object of Customer from directory");          //+
        view.outInfo(commands.addOrder + " - add an object of Order in directory");                     //+
        view.outInfo(commands.addCustomer + " - add an object of Customer in directory");               //+
        view.outInfo(commands.deleteOrder + " - delete an Order object from directory");                //+
        view.outInfo(commands.deleteCustomer + " - delete an Customer object from directory");          //+
        view.outInfo(commands.clear + " - delete all elements from directory");                         //+
        view.outInfo(commands.show + " - display contents of the directory");                           //+
        view.outInfo(commands.exit + " - End current session and save information in data base");       //+
        view.outInfo(commands.search + " - Search all information by entered template");                //+
        view.outInfo(commands.addFromFile + " - Add information from file by name\n");
    }

    /**
     * Enter to the program
     * using method for output commands and method for users command until EXIT
     * @throws IOException exception class for output/input
     */
     public void start() throws IOException, ClassNotFoundException {
        view.outInfo("Sales department : ");
        view.outInfo("Order(number, customer, date, cost), Customer(name, phone number, address)");
        getCommandList();
        Reader reader = new InputStreamReader(System.in);
        while (inputCommand(reader));

    }

    /**
     * Method realize input commands by user
     * @param in object of Reader class
     * @return boolean
     * @throws IOException exception class for output/input
     */
    private boolean inputCommand(Reader in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        tokenizer.nextToken();
        String currentCommand = tokenizer.sval;
        if (currentCommand != null) {
            switch (currentCommand) {
                case "exit": {
                    fileView.setOrderList(orderModel.getRuntime());
                    fileView.setCustomerList(customerModel.getRuntime());
                    storageService.save(fileView);
                    view.outInfo("Program successfully completed.");
                    return false;
                }
                case "show": {
                    if (orderModel.isEmpty() && customerModel.isEmpty()) {
                        view.outInfo("Directory is empty.");
                        break;
                    } else {

                        if (!orderModel.isEmpty()) {
                            view.orderViewer();
                        } else
                            view.outInfo("There're not any Orders in the data base.");

                        if (!customerModel.isEmpty()) {
                            view.customerViewer();
                        } else
                            view.outInfo("There're not any Customers in the data base.");
                        view.outInfo("All elements is showed.");
                    }
                    break;
                }
                case "clear": {
                    orderModel.clear();
                    customerModel.clear();
                    view.outInfo("Info successfully cleared from the directory.");
                    break;
                }
                case "getOrder": {
                    getOrderInfo(in);
                    break;
                }
                case "deleteOrder": {
                    deleteOrderInfo(in);
                    break;
                }
                case "getCustomer": {
                    getCustomerInfo(in);
                    break;
                }
                case "deleteCustomer": {
                    deleteCustomerInfo(in);
                    break;
                }
                case "addCustomer": {
                    addCustomer(in);
                    break;
                }
                case "addOrder": {
                    addOrder(in);
                    break;
                }
                case "setOrder": {
                    setOrder(in);
                    break;
                }
                case "setCustomer": {
                    setCustomer(in);
                    break;
                }
                case "search": {
                    templateSearch(in);
                    break;
                }
                case "addFromFile": {
                      fileAdding(in);
                    break;
                }

                default:
                    view.outInfo("There is not this command in command list. Try again..");
            }
        }
        else {
            view.outInfo("Error. Empty input, try again..");
        }
        return true;
    }

    /**
     * Method for getOrder command
     * getting Customer object by id, which searches by index
     * @param in object of Reader class
     * @throws IOException exception class for output/input
     */
    private void getOrderInfo(Reader in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        tokenizer.nextToken();
        if (tokenizer.sval != null) {
            view.outInfo("Incorrect input");
        }
        else if ((int)tokenizer.nval < 0 || (int) tokenizer.nval >= view.getCustomerMapSize()) {
            view.outInfo("Incorrect number.");
        }
        else {
            int index = (int) tokenizer.nval;
            view.outInfo(orderModel.get(view.getOrderId(index)).toString());
        }
    }

    /**
     * Method for getCustomer command
     * getting Customer object by id, which searches by index from user
     * @param in object of Reader class
     * @throws IOException exception class for output/input
     */
    private void getCustomerInfo(Reader in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        tokenizer.nextToken();
        if (tokenizer.sval != null) {
            view.outInfo("Incorrect input");
        }
        else if ((int)tokenizer.nval < 0 || (int) tokenizer.nval >= view.getCustomerMapSize()) {
            view.outInfo("Incorrect number.");
        }
        else {
            int index = (int) tokenizer.nval;
            view.outInfo(customerModel.get(view.getCustomerId(index)).toString());
        }
    }

    /**
     * Method for deleteOrder command
     * delete Customer info by id that search by index from user
     * @param in object of Reader class
     * @throws IOException exception class for output/input
     */
    private void deleteOrderInfo(Reader in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        tokenizer.nextToken();
        if (tokenizer.sval != null) {
            view.outInfo("Incorrect input");
        }
        else if ((int)tokenizer.nval < 0 || (int) tokenizer.nval >= view.getOrderMapSize()) {
            view.outInfo("Incorrect number.");
        }
        else {
            int index = (int) tokenizer.nval;
            int num = orderModel.getNumById(view.getOrderId(index));
            orderModel.remove(view.getOrderId(index));
            for (int i = 0 ; i < customerModel.getRuntime().size(); i++) {
                if (customerModel.getRuntime().get(i).getNumOrder() == num) {
                    customerModel.remove(view.getCustomerId(i+1));
                }
            }
            view.outInfo("Order(and linked costumers) info successfully deleted.");
        }
    }

    /**
     * Method for deleteCustomer command
     * delete Customer info by id that search by index from user
     * @param in object of Reader class
     * @throws IOException exception class for output/input
     */
    private void deleteCustomerInfo(Reader in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        tokenizer.nextToken();
        if (tokenizer.sval != null) {
            view.outInfo("Incorrect input");
        }
        else if ((int)tokenizer.nval < 0 || (int) tokenizer.nval >= view.getCustomerMapSize()) {
            view.outInfo("Incorrect number.");
        }
        else {
            int index = (int) tokenizer.nval;
            index++;
            int num = customerModel.getNumById(view.getCustomerId(index));
            customerModel.remove(view.getCustomerId(index));
            for (int i = 0 ; i < orderModel.getRuntime().size(); i++) {
                if (orderModel.getRuntime().get(i).getNum() == num) {
                    orderModel.remove(view.getOrderId(i+1));
                }
            }
            view.outInfo("Customer(and linked orders) info successfully deleted.");
        }
    }

    /**
     * Method for addCustomer command
     * add new Object of Customer class in CustomerModel
     * @param in object of Reader class
     * @throws IOException exception class for output/input
     */
    private void addCustomer(Reader in) throws IOException {
        String name, address, phoneNumber;
        int numOrder;
        StreamTokenizer input = new StreamTokenizer(in);
        input.nextToken();

            name = input.sval;
        input.nextToken();

            address = input.sval;
        input.nextToken();


        if(input.sval != null) {
            phoneNumber = input.sval;
        }
        else {
            phoneNumber = Integer.toString((int)input.nval);
        }
        input.nextToken();

        numOrder = (int) input.nval;

        try {
            customerModel.add(new Customer(name, phoneNumber, address, numOrder));
            view.outInfo("Info successfully added");

        } catch (IllegalArgumentException e) {
            view.outInfo(e.getMessage());
        }
    }

    /**
     * Method for addOrder command
     * add new Object of Order class in OrderModel
     * @param in object of Reader class
     * @throws IOException exception class for output/input
     */
    private void addOrder(Reader in) throws IOException {
        int num;
        double orderSum;
        int year, month, day;
        String name, address, phoneNumber;

        StreamTokenizer input = new StreamTokenizer(in);
        input.nextToken();
        num = (int) input.nval;
        if (num < 0 || orderModel.numCheck(num)) {
            view.outInfo("Incorrect order number.");
        }
        else {
            input.nextToken();

            orderSum = input.nval;
            input.nextToken();

            year = (int) input.nval;
            input.nextToken();

            month = (int) input.nval;
            input.nextToken();

            day = (int) input.nval;
            input.nextToken();

            name = input.sval;
            input.nextToken();

                address = input.sval;
            input.nextToken();


            if (input.sval != null) {
                phoneNumber = input.sval;
            } else {
                phoneNumber = Integer.toString((int) input.nval);
            }

            try {
                orderModel.add(new Order(num, new Customer(name, phoneNumber, address, num), new GregorianCalendar(year, month, day), orderSum));
                view.outInfo("Info successfully added");

            } catch (IllegalArgumentException e) {
                view.outInfo(e.getMessage());
            }
        }
    }

    /**
     * Method for setCustomer command
     * takes new parameters from user and change Customer object by id that search by index from user
     * @param in object of Reader class
     * @throws IOException exception class for output/input
     */
    private void setCustomer(Reader in) throws IOException {
        String name, address, phoneNumber;
        int numOrder, position;
        StreamTokenizer input = new StreamTokenizer(in);
        input.nextToken();

        position = (int) input.nval;
        input.nextToken();

        if(input.sval != null) {
            name = input.sval;
        }
        else {
            name = Double.toString(input.nval);
        }
        input.nextToken();

        if(input.sval != null) {
            address = input.sval;
        }
        else {
            address = Double.toString(input.nval);
        }
        input.nextToken();


        if(input.sval != null) {
            phoneNumber = input.sval;
        }
        else {
            phoneNumber = Integer.toString((int)input.nval);
        }
        input.nextToken();
        numOrder = (int) input.nval;

        try {
            customerModel.set(new Customer(name, phoneNumber, address, numOrder), view.getCustomerId(position+1));
            view.outInfo("Info successfully updated.");

        } catch (IllegalArgumentException e) {
            view.outInfo("Incorrect input. Try again..");
        }

    }


    /**
     * Method for setOrder command
     * takes new parameters from user and change Order(and linked Customer) object by id that search by index from user
     * @param in object of Reader class
     * @throws IOException exception class for output/input
     */
    private void setOrder(Reader in) throws IOException {
        int num, position;
        double orderSum;
        int year, month, day;
        String name, address, phoneNumber;

        StreamTokenizer input = new StreamTokenizer(in);
        input.nextToken();
        position = (int) input.nval;
        input.nextToken();
        num = (int) input.nval;

            input.nextToken();

            orderSum = input.nval;

            input.nextToken();
            year = (int) input.nval;

            input.nextToken();
            month = (int) input.nval;

            input.nextToken();
            day = (int) input.nval;

            input.nextToken();

            if (input.sval != null) {
                name = input.sval;
            } else {
                name = Double.toString(input.nval);
            }
            input.nextToken();

            if (input.sval != null) {
                address = input.sval;
            } else {
                address = Double.toString(input.nval);
            }
            input.nextToken();


            if (input.sval != null) {
                phoneNumber = input.sval;
            } else {
                phoneNumber = Integer.toString((int) input.nval);
            }

            try {
                orderModel.set(new Order(num, new Customer(name, phoneNumber, address, num), new GregorianCalendar(year, month, day), orderSum), view.getOrderId(position+1));
                customerModel.set(new Customer(name, phoneNumber, address, num), view.getCustomerId(customerModel.getIndexByNum(num)+1));
                view.outInfo("Info successfully updated.");
            } catch (IllegalArgumentException | BadInputExсeption e) {
                view.outInfo("Incorrect input. Try again..");
            }

    }

    /**
     * Method for searching information by template
     * @param in object Reader class
     * @throws IOException exception class for input
     */
    private void templateSearch(Reader in) throws IOException {
        StreamTokenizer input = new StreamTokenizer(in);
        input.nextToken();
        String template = input.sval;

        if (input.sval == null) {
            template = Integer.toString((int) input.nval);
        }

        view.outInfo("" + orderModel.templateSearch(template) + "\n" +  customerModel.templateSearch(template));
    }

    /**
     * Method for adding Order and Customers objects from file by name
     * @param in object Reader class
     * @throws IOException exception class for input
     */
    private void fileAdding(Reader in) throws IOException {
        StreamTokenizer input = new StreamTokenizer(in);
        input.nextToken();
        String name = input.sval;
        if (input.sval == null) {
              name = Integer.toString((int) input.nval);
           }
        File file = new File("C://Users//bekht//Desktop", name);
        if (file.length() == 0) view.outInfo("File is empty or does not exist.");
        else {
            view.outInfo(orderModel.fileAdding(file));
            view.outInfo(customerModel.fileAdding(file));
        }
    }

}
