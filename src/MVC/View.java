package MVC;

/**
 * @author Alexey B, Nikita K
 * @version 1.0
 *
 * This class is a part of MVC, that realize output in console some information that user are asking for
 *
 */

public class View {

    /**
     *
     * Method prints object with all his fields
     * @param obj
     */

    static void viewer(Object obj) {
        System.out.println(obj.toString());
    }

}
