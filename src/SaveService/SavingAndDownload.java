package SaveService;

import java.io.*;

/**
 * Class for serialization and deserialization FileView object in database
 * @author Alexey B
 * @version 1.4.2
 */

public class SavingAndDownload implements Serializable {

    private static final File DATA_BASE = new File("C://Users//bekht//Desktop", "database.txt");

    /**
     * Serialization method for saving data in database
     * @param fileView FileView object to ser.
     * @throws IOException exception class for input
     */
    public void save(FileView fileView) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(DATA_BASE));
        objectOutputStream.writeObject(fileView);
        objectOutputStream.close();
    }

    /**
     * Deserialization method for download data from database
     * @return FileView object or null(if database file is empty)
     * @throws IOException exception class for output
     * @throws ClassNotFoundException exception class for class causes
     */
    public FileView download() throws IOException, ClassNotFoundException {
        FileView info = new FileView();
        if (DATA_BASE.length() != 0) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(DATA_BASE));
            info = (FileView) objectInputStream.readObject();
            objectInputStream.close();
        }
        else return null;
        return info;
    }
}
