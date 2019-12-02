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

    private static FileView fileView = new FileView(CustomerModel.getRuntime(), OrderModel.getRuntime());

    private enum commands {

        get("get"), setOrder("setOrder"), setCustomer("setCustomer"),addOrder("addOrder"),
        addCostumer("addCostumer"), delete("delete"), clear("clear"), show("show"), exit("exit");

        private String title;
        commands(String title) {
            this.title = title;
        }

    }

    private static void getCommandList() {
        View.outInfo("\nCommands:\n");
        View.outInfo(commands.get + " - returns information from directory by index"); //+
        View.outInfo(commands.setOrder + " - change an object of Order from directory by index");
        View.outInfo(commands.setCustomer + " - change an object of Costumer from directory by index");
        View.outInfo(commands.addOrder + " - add an object of Order in directory");
        View.outInfo(commands.addCostumer + " - add an object of Costumer in directory");
        View.outInfo(commands.delete + " - delete an object from directory by index"); //+
        View.outInfo(commands.clear + " - delete all elements from directory"); //+
        View.outInfo(commands.show + " - display contents of the directory"); //+
        View.outInfo(commands.exit + " - End current session");  //+

    }


   public static void start() throws IOException {
        View.outInfo("Sales department : ");
        View.outInfo("Order(number, costumer, date, cost), Costumer(name, phone number, address)");
        getCommandList();
        Reader reader = new InputStreamReader(System.in);
        while (inputCommand(reader));

    }

    private static boolean inputCommand(Reader in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        tokenizer.nextToken();
        String currentCommand = tokenizer.sval;
        if (currentCommand != null) {
            switch (currentCommand) {
                case "exit": {
                    SavingAndDownload.save(fileView);
                    View.outInfo("Program successfully completed.");
                    return false;
                }
                case "show": {
                    View.outInfo(fileView.getString());
                    break;
                }
                case "clear": {
                    fileView.clear();
                    break;
                }
                case "get": {
                    getInfo(in);
                    break;
                }
                case "delete": {
                    deleteInfo(in);
                    break;
                }

                default:
                    View.outInfo("There is not this command in command list. Try again..");
            }
        }
        else {
            View.outInfo("Error. Empty input, try again..");
        }
        return true;
    }

    private static void getInfo(Reader in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        tokenizer.nextToken();
        if (tokenizer.sval != null) {
            View.outInfo("Incorrect input");
        }
        else {
            int index = (int) tokenizer.nval;
            fileView.getInfo(index);
        }
    }

    private static void deleteInfo(Reader in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        tokenizer.nextToken();
        if (tokenizer.sval != null) {
            View.outInfo("Incorrect input");
        }
        else {
            int index = (int) tokenizer.nval;
            fileView.deleteInfo(index);
        }
    }

    private static void addOrder(Reader in) throws IOException {

    }


}
