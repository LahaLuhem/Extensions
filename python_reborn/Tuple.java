package python_reborn;

/**
 * Enables a similarish functionality of the a dynam0c-type Tuple object object in languages like Python
 * into a verbose language such as Java.
 * @author LahaLuhem
 * @version 1.0.0
 */
public class Tuple<T> {
    private T[] elems;

    Tuple (T ... objs) {
        elems = objs;
    }

    @Override
    public String toString () {
        String seq = "( ";
        for (T elem : elems)
            if (elem instanceof String) seq += "\"" + elem + "\" ";
            else seq += elem + " ";
        
        seq += ")";
        return seq;
    }
    
    
    /**
     * Only for testing purposes, can be removed before release
     */
    public static void main (String[] args) {
        Tuple tuple = new Tuple (
                                    13,
                                    "Hello",
                                    42.69,
                                    new Tuple ("try", "recursives")
                                );
        
        System.out.println(tuple);
    }
}