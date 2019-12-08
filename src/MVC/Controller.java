package MVC;

import Info.Customer;
import Info.Order;
import SaveService.FileView;
import SaveService.SavingAndDownload;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.GregorianCalendar;

/**
 * @author Alexey B
 * @version 1.0
 *
 * This class is a part of MVC, that realize interaction between user and program
 *
 */
public class Controller {

   private FileView fileView = new FileView(SavingAndDownload.download());
   private View view = new View();

    public Controller() throws IOException, ClassNotFoundException {
    }

    private enum commands {

        getOrder("getOrderInfo"), getCustomer("getCustomerInfo"), setOrder("setOrder"), setCustomer("setCustomer"),addOrder("addOrder"),
        addCustomer("addCustomer"), deleteOrder("deleteOrder"), deleteCustomer("deleteCustomer"), clear("clear"), show("show"), exit("exit");

        private String title;
        commands(String title) {
            this.title = title;
        }

    }

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
        view.outInfo(commands.exit + " - End current session and save information in data base\n");     //+
    }


     public void start() throws IOException {
        view.outInfo("Sales department : ");
        view.outInfo("Order(number, customer, date, cost), Customer(name, phone number, address)");
        getCommandList();
        Reader reader = new InputStreamReader(System.in);
        while (inputCommand(reader));

    }

    private boolean inputCommand(Reader in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        tokenizer.nextToken();
        String currentCommand = tokenizer.sval;
        if (currentCommand != null) {
            switch (currentCommand) {
                case "exit": {
                    SavingAndDownload.save(fileView);
                    view.outInfo("Program successfully completed.");
                    return false;
                }
                case "show": {
                    if (fileView.getOrderList().isEmpty() && fileView.getCustomerList().isEmpty()) {
                        view.outInfo("Directory is empty.");
                        break;
                    } else {

                        if (!fileView.getOrderList().isEmpty()) {
                            view.outInfo(fileView.getOrderList().toString());
                        } else
                            view.outInfo("There're not any Orders in the data base.");

                        if (!fileView.getCustomerList().isEmpty()) {
                            view.outInfo(fileView.getCustomerList().toString());
                        } else
                            view.outInfo("There're not any Customers in the data base.");
                        view.outInfo("All elements is showed.");
                    }
                    break;
                }
                case "clear": {
                    fileView.getCustomerList().clear();
                    fileView.getOrderList().clear();
                    view.outInfo("Info successfully cleared from the directory.");
                    break;
                }
                case "getOrder": {
                    getOrderInfo(in);
                    break;
                }
                case "deleteOrder": {
                    deleteOrderInfo(in);
                    view.outInfo("Info successfully deleted.");
                    break;
                }
                case "getCustomer": {
                    getCustomerInfo(in);
                    break;
                }
                case "deleteCustomer": {
                    deleteCustomerInfo(in);
                    view.outInfo("Info successfully deleted.");
                    break;
                }
                case "addCustomer": {
                    addCustomer(in);
                    view.outInfo("Info successfully added");
                    break;
                }
                case "addOrder": {
                    addOrder(in);
                    view.outInfo("Info successfully added");
                    break;
                }
                case "setOrder": {
                    setOrder(in);
                    view.outInfo("Info successfully updated.");
                    break;
                }
                case "setCustomer": {
                    setCustomer(in);
                    view.outInfo("Info successfully updated.");
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

    private void getOrderInfo(Reader in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        tokenizer.nextToken();
        if (tokenizer.sval != null) {
            view.outInfo("Incorrect input");
        }
        else {
            int index = (int) tokenizer.nval;
            view.orderViewer(fileView.getOrderList().get(index-1)); //needs id
        }
    }

    private void getCustomerInfo(Reader in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        tokenizer.nextToken();
        if (tokenizer.sval != null) {
            view.outInfo("Incorrect input");
        }
        else {
            int index = (int) tokenizer.nval;
            view.customerViewer(fileView.getCustomerList().get(index-1)); //needs id
        }
    }

    private void deleteOrderInfo(Reader in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        tokenizer.nextToken();
        if (tokenizer.sval != null) {
            view.outInfo("Incorrect input");
        }
        else {
            int index = (int) tokenizer.nval;
            fileView.getOrderList().remove(index-1); //needs id
        }
    }


    private void deleteCustomerInfo(Reader in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        tokenizer.nextToken();
        if (tokenizer.sval != null) {
            view.outInfo("Incorrect input");
        }
        else {
            int index = (int) tokenizer.nval;
            fileView.getCustomerList().remove(index-1); //needs id
        }
    }


    private void addCustomer(Reader in) throws IOException {
        String name, address, phoneNumber;
        int numOrder;
        StreamTokenizer input = new StreamTokenizer(in);
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
            fileView.getCustomerList().add(new Customer(name, phoneNumber, address, numOrder));
        } catch (IllegalArgumentException e) {
            view.outInfo(e.getMessage());
        }
    }


    private void addOrder(Reader in) throws IOException {
        int num;
        double orderSum;
        int year, month, day;
        String name, address, phoneNumber;

        StreamTokenizer input = new StreamTokenizer(in);
        input.nextToken();
        num = (int) input.nval;
        if (fileView.getOrderList().numCheck(num)) {
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
                fileView.getOrderList().add(new Order(num, new Customer(name, phoneNumber, address, num), new GregorianCalendar(year, month, day), orderSum));
            } catch (IllegalArgumentException e) {
                view.outInfo(e.getMessage());
            }
        }
    }

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
            fileView.getCustomerList().set(new Customer(name, phoneNumber, address, numOrder), position-1);
        } catch (IllegalArgumentException e) {
            view.outInfo(e.getMessage());
        }

    }

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
                fileView.getOrderList().set(new Order(num, new Customer(name, phoneNumber, address, num), new GregorianCalendar(year, month, day), orderSum), position-1);
            } catch (IllegalArgumentException | BadInputExсeption e) {
                view.outInfo(e.getMessage());
            }

    }

}
