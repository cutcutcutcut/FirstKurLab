package MVC;

import SaveService.FileView;
import SaveService.SavingAndDownload;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;

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

        getOrder("getOrderInfo"), getCustomer("getCosumerInfo"), setOrder("setOrder"), setCustomer("setCustomer"),addOrder("addOrder"),
        addCostumer("addCostumer"), deleteOrder("deleteOrder"), deleteCustomer("deleteCustomer"), clear("clear"), show("show"), exit("exit");

        private String title;
        commands(String title) {
            this.title = title;
        }

    }

    private void getCommandList() {
        view.outInfo("\nCommands:\n");
        view.outInfo(commands.getOrder + " - returns Order information from directory by id");
        view.outInfo(commands.getCustomer + " - returns Customer information from directory by id");
        view.outInfo(commands.setOrder + " - change an object of Order from directory by id");
        view.outInfo(commands.setCustomer + " - change an object of Costumer from directory by id");
        view.outInfo(commands.addOrder + " - add an object of Order in directory");
        view.outInfo(commands.addCostumer + " - add an object of Costumer in directory");
        view.outInfo(commands.deleteOrder + " - delete an Order object from directory by id");
        view.outInfo(commands.deleteCustomer + " - delete an Customer object from directory by id");
        view.outInfo(commands.clear + " - delete all elements from directory"); //+
        view.outInfo(commands.show + " - display contents of the directory"); //+
        view.outInfo(commands.exit + " - End current session");  //+

    }


   public void start() throws IOException {
        view.outInfo("Sales department : ");
        view.outInfo("Order(number, costumer, date, cost), Costumer(name, phone number, address)");
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
                    view.outInfo(fileView.getOrderList().toString());
                    view.outInfo("");
                    view.outInfo(fileView.getCustomerList().toString());
                    break;
                }
                case "clear": {
                    fileView.getCustomerList().clear();
                    fileView.getOrderList().clear();
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
            view.viewer(fileView.getOrderList().get(index+1)); //needs id
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
            fileView.getCustomerList().get(index); //needs id
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
            fileView.getOrderList().remove(index); //needs id
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
            fileView.getCustomerList().remove(index); //needs id
        }
    }

    private void addOrder(Reader in) throws IOException {

    }


}
