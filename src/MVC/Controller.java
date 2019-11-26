package MVC;

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

    private static final String[] COMMANDS = {
            "get", "setOrder", "setCostumer", "addOrder",
            "addCostumer", "delete","clear", "show", "exit"
    };

    private static void getCommandList() {
        View.outInfo("\nCommands:\n");
        View.outInfo(COMMANDS[0] + " - returns information from directory by index \n");
        View.outInfo(COMMANDS[1] + " - change an object of Order from directory by index \n");
        View.outInfo(COMMANDS[2] + " - change an object of Costumer from directory by index \n");
        View.outInfo(COMMANDS[3] + " - add an object of Order in directory\n");
        View.outInfo(COMMANDS[4] + " - add an object of Costumer in directory\n");
        View.outInfo(COMMANDS[5] + " - delete an object from directory by index\n");
        View.outInfo(COMMANDS[6] + " - delete all elements from directory\n");
        View.outInfo(COMMANDS[7] + " - display contents of the directory\n");
        View.outInfo(COMMANDS[8] + " - End current session\n");

    }


    static void start() throws IOException {
        View.outInfo("\nSales department : ");
        View.outInfo("Order(number, costumer, date, cost), Costumer(name, phone number, address)\n");
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
                    Model.updateDataBase();
                    View.outInfo("Program successfully completed.");
                    return false;
                }
                case "show": {
                    Model.showInfo();
                    break;
                }
                case "clear": {
                    Model.clearInfo();
                    break;
                }
                case "get": {
                    getInfo(in);
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
        int index = (int)tokenizer.nval;
        Model.getInfo(index);
    }



}
