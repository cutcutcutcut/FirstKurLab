package Info;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Alexey B
 * @version 1.4.2
 * This is one of the info classes, that contains information about orderer
 *
 */

public class Customer implements Serializable {
    private String name, address, phoneNumber;
    private int numOrder;
    private UUID idCustomer;

    /**
     * Constructor that takes all field and create object
     * @param name name of customer/company
     * @param phoneNumber number phone of customer
     * @param address address of customer
     * @param numOrder number linked order
     */
    public Customer(String name, String phoneNumber, String address, int numOrder) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.numOrder = numOrder;
        idCustomer = UUID.randomUUID();
    }

    /**
     * getter id of id field Customer Object
     * @return UUID object
     */

    public UUID getIdCustomer() {
        return idCustomer;
    }

    /**
     * getter number of the linked order
     * @return integer
     */
    public int getNumOrder() {
        return numOrder;
    }

    /**
     * setter of the number linked order
     * @param numOrder that will
     */
    public void setNumOrder(int numOrder) {
        this.numOrder = numOrder;
    }

    /**
     * Getter field phone number
     * @return string
     */

    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * Setter for field phoneNumber
     * @param phoneNumber string
     */

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter field that contains address
     * @return string address
     */

    public String getAddress() {
        return address;
    }

    /**
     *
     * Setter for field  address
     * @param address string
     */

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter field  name of an orderer
     * @return string
     */

    public String getName() {
        return name;
    }

    /**
     *
     * Setter for field name
     * @param name string
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method realizes the conversion object in string
     * @return string
     */
    @Override
    public String toString() {
        return "\t\tName - " + name + "\n\t\tAddress - " + address + "\n\t\tPhone number - " + phoneNumber + "\n\t\t" + "NumOrder = " + numOrder + "\n";
    }

}
