package python_reborn;

import java.util.Arrays;

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
     * Concatenates the current tuple with a given one
     * @param tup2 The Tuple to be concatenated
     * @return A new concatenated Tuple
     */
    public Tuple concat (Tuple tup2) {
        T[] result = Arrays.copyOf(elems, elems.length + tup2.elems.length);
        System.arraycopy(tup2.elems, 0, result, elems.length, tup2.elems.length);
        
        return new Tuple (result);
    }
    
    /**
     * Concatenates to the current tuple, all tuples supplied to it
     * @param tups Variable size list to be concatenated
     * @return A new concatenated Tuple
     */
    public Tuple concat (Tuple... tups) {
        Tuple concated = new Tuple();
        concated.elems = elems;
        
        for (Tuple tup : tups) concated = concated.concat(tup);
        
        return concated;
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