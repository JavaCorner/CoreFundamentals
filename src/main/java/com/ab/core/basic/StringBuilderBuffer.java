package com.ab.core.basic;

/**
 * @author Arpit Bhardwaj
 *
 *  String extends nothing implements CharSequence, Serializable and Comparable
 *  AbstractStringBuilder implements CharSequence, Apendable
 *  StringBuilder extends AbstractStringBuilder implements CharSequence, Serializable
 *  StringBuffer extends AbstractStringBuilder implements CharSequence, Serializable
 *
 *  Objects of String are immutable, and objects of StringBuffer and StringBuilder are mutable.
 *  StringBuffer and StringBuilder are similar, but
 *  StringBuilder is faster and preferred over StringBuffer for the single-threaded program.
 *  If thread safety is needed, then StringBuffer is used.
 *
 *  StringBuilder default capacity is 16 and it autoexpand if required
 */
public class StringBuilderBuffer {
    public static void main(String[] args) {
        String str = "Geeks";
        //convert str to string builder and buffer
        StringBuilder sBuilder = new StringBuilder(str);
        StringBuffer sBuffer = new StringBuffer(str);

        //convert string builder and buffer to string
        sBuilder.toString();
        sBuffer.toString();

        //append() adds the parameter to the StringBuilder and returns a reference to the current StringBuilder.
        StringBuilder a = new StringBuilder("abc");
        StringBuilder b = a.append("de");
        b = b.append("f").append("g");
        System.out.println("a=" + a);                       //a=abcdefg
        System.out.println("b=" + b);                       //b=abcdefg

        //insert(int offset, String str) - insert shifts characters to right
        StringBuilder sb1 = new StringBuilder("animals")
                .insert(7,'-')
                .insert(0, "-")
                .insert(4, "-");

        System.out.println(sb1);                            //-ani-mals-

        //in substring and delete, start is inclusive and end is exclusive and optional
        //substring returns new string builder instance and delete returns same string builder instance
        //substring is an immutable operation while delete or deleteCharAt is mutable
        var sb = new StringBuilder().append("reddish");
        System.out.println(sb.substring(2));           //ddish
        System.out.println(sb.substring(1,3));              //ed
        System.out.println(sb.substring(3,3));              //will return empty string
        //System.out.println(sb.substring(3,10));           //end is invalid throws StringIndexOutOfBoundsException
        //System.out.println(sb.substring(10,3));           //start is invalid throws StringIndexOutOfBoundsException

        sb.deleteCharAt(0);                           //eddish
        sb.delete(1, 2);                                    //edish
        sb.delete(3, 3);                                    //will not do anything
        sb.delete(3, 10);                                   //end is invalid but it deletes character till end
        //sb.delete(10,3);                                  //start as invalid throws StringIndexOutOfBoundsException
        System.out.println(sb);                             //edi

        StringBuilder builder = new StringBuilder("pigeon dirty");
        builder.replace(3, 6, "sty");
        System.out.println(builder);                        // pigsty dirty

        builder.replace(3, 100, "");
        System.out.println(builder);                        //pig

        //StringBuilder did not implement equals(). If you call equals() on two StringBuilder instances, it will check default reference equality.
        StringBuilder one = new StringBuilder("abc");
        StringBuilder two = new StringBuilder("abc");
        System.out.println(one.equals(two));                        //false
        System.out.println(one.toString().equals(two.toString()));  //true

    }
}
