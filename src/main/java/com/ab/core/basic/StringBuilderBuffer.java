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
 * StringBuffer and StringBuilder are similar, but
 * StringBuilder is faster and preferred over StringBuffer for the single-threaded program.
 * If thread safety is needed, then StringBuffer is used.
 *
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
        System.out.println("a=" + a);
        System.out.println("b=" + b);

        //insert(int offset, String str)
        StringBuilder sb1 = new StringBuilder("animals").insert(7,'-').insert(0, "-").insert(4, "-");
        System.out.println(sb1);

        var sb = new StringBuilder().append("reddish");
        //in substring and delete
        //start is inclusive and end is exclusive
        //If start is equal to end, no changes are made in case of delete and nothing is returned in case of substring.
        //substring returns string and delete returns same string builder instance
        System.out.println(sb.substring(2));
        System.out.println(sb.substring(1,3));
        System.out.println(sb.substring(3,3));//will return empty string
        //System.out.println(sb.substring(3,10));//end is invalid throws StringIndexOutOfBoundsException
        //System.out.println(sb.substring(10,3));//start is invalid throws StringIndexOutOfBoundsException

        sb.deleteCharAt(0);
        sb.delete(1, 2);
        sb.delete(3, 3);//will not do anything
        sb.delete(3, 10);//end is invalid but it returns character till end
        //sb.delete(10,3);//start as invalid throws StringIndexOutOfBoundsException
        System.out.println(sb);

        StringBuilder builder = new StringBuilder("pigeon dirty");
        builder.replace(3, 6, "sty");
        System.out.println(builder);  // pigsty dirty

        builder.replace(3, 100, "");
        System.out.println(builder);
    }
}
