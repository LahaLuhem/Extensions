/**
 * Enables a similarish functionality of the a dynam0c-type Tuple object object in languages like Python
 * into a verbose language such as Java.
 * @author LahaLuhem
 * @version 1.0.0
 */
public class Tuple {
    Obj[] elems;

    Tuple (Obj ... objs) {
        elems = objs;
    }

    @Override
    public String toString () {
        String seq = "( ";
        for (Obj elem : elems)
            seq += elem + " ";

        seq += ")";
        return seq;
    }
    
    
    /**
     * Only for testing purposes, can be removed before realease
     */
    public static void main (String[] args) {
        Tuple tuple = new Tuple (
                                    new Obj(13),
                                    new Obj ("Hello"),
                                    new Obj (42.69),
                                    new Obj ( new Tuple (new Obj("try"), new Obj("recursives")) )
                                );
        
        System.out.println(tuple);
    }
}

class Obj<T> extends java.lang.Object {
    Object element;
    Types orgType;

    Obj (int num){
        element = (Object) num;
        orgType = Types.Int;
    }
    Obj (char c){
        element = (Object) c;
        orgType = Types.Char;
    }
    Obj (double num) {
        element = (Object) num;
        orgType = Types.Double;
    }
    Obj (float num) {
        element = (Object) num;
        orgType = Types.Float;
    }
    Obj (String str) {
        element = (Object) str;
        orgType = Types.String;
    }
    Obj (T obj) {
        element = obj;
        orgType = Types.CustomObj;
    }

    
    @Override
    public String toString () {
        switch (orgType) {
            case Int: return "" + ((Integer)element);
            case Char: return "" + ((Character)element);
            case Double: return "" + ((Double)element);
            case Float: return "" + ((Float)element);
            
            case String: return "\"" + (String)element + "\"";
            
            case CustomObj: return element.toString();
            
            default: return "";
        }
    }
}

enum Types {
    Int,
    Char,
    Double,
    Float,
    String,

    CustomObj
}