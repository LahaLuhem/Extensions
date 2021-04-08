package python_reborn;

import java.util.Arrays;
import java.util.List;

/**
 * Enables a similar-ish functionality of the dynamic-type Tuple object object in languages like Python
 * into a verbose language such as Java.
 * This Tuple is mutable
 * @author LahaLuhem
 * @version 1.0.0
 */
public class Tuple<T> {
    private T[] elems;

    Tuple (T ... objs) {
        elems = objs;
    }
    
    Tuple () {
        elems = null;
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
    
    
    /**
     * Return the length of the tuple
     * @return The length
     */
    public int len (){
        return elems.length;
    }
    
    /**
     * Returns the element at a given index. Supports negative indexing
     * @param index The index of the element to be retrieved
     * @return The element at given index
     */
    public T get (int index) {
        return elems[ ((index < 0)? elems.length: 0) + index ];
    }
    
    /**
     * Allows changing of individual elements, only if the new one is of the same type
     * Does not throw an Exception if no the case
     * @param index The element to be modified
     * @param newElem The value to be modified with
     */
    public void setAt (int index, T newElem) {
        if (newElem.getClass().equals(elems[index].getClass())) elems[index] = newElem;
    }
    
    /**
     * Slices the tuple by the given range
     * @param start Starting index of the new slice
     * @param end Ending index of the new slice
     * @return A new sliced Tuple
     */
    public Tuple slice (int start, int end) {
        return new Tuple ( Arrays.copyOfRange(elems, start, end) );
    }
    
    /**
     * TO BE IMPLEMENTED PROPERLY
     * @param tup2
     * @return 
     */
    public Tuple concat (Tuple tup2) {
        List<T> tup1List = Arrays.asList(elems);
        for (Object elem : tup2.elems)
            tup1List.add((T) elem);
        
        return new Tuple (tup1List);
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