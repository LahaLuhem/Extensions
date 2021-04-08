package python_reborn;

/**
 * Enables a similar-ish functionality of the dynamic-type Tuple object object in languages like Python
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
        StringBuilder seq = new StringBuilder("( ");
        for (T elem : elems)
            if (elem instanceof String) seq.append("\"").append(elem).append("\", ");
            else seq.append(elem).append (", ");
        
        seq = seq.deleteCharAt(seq.length()-2);
        seq.append(")");
        
        return seq.toString();
    }
    
    
    public int len (){
        return elems.length;
    }
    
    /**
     * Only for testing purposes, can be removed before release
     * @param args Command-line arguments to be supplied
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