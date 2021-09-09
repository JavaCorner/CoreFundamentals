package com.ab.core.basic;

/**
 * @author Arpit Bhardwaj
 *
 * Keyword	Type	                    Example         Range
 * boolean	true/false	                true            true/false
 * byte	    8-bit integral value	    123             2 pow 8 = 256 = -128 to 127
 * short	16-bit integral value	    123             2 pow 16 = 65,536 = -32,768 to 32,767
 * int	    32-bit integral value	    123             2 pow 32 = 4,294,967,296 = -2,147,483,648 to 2,147,483,647
 * long	    64-bit integral value	    123L            2 pow 64 = 18,446,744,073,709,551,616 = -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
 * float	32-bit floating-point value	123.45f         Difficult to say
 * double	64-bit floating-point value	123.456         Difficult to say
 * char	    16-bit Unicode value	    'a'             2 pow 16 = 65,536 = 0 to 65,535
 *
 * The byte, short, int, and long types are used for numbers without decimal points.
 * The float and double types are used for floating-point (decimal) values.
 * A float requires the letter f following the number so Java knows it is a float.
 * In most computer systems, floating-point numbers are stored in scientific notation. This means the numbers are stored as two numbers, a and b, of the form a x 10b.
 *
 * short and char are closely related, as both are stored as integral types with the same 16-bit length.
 * The primary difference is that short is signed, which means it splits its range across the positive and negative integers.
 * Alternatively, char is unsigned, which means range is strictly positive including 0.
 * Therefore, char can hold a higher positive numeric value than short, but cannot hold any negative numbers.
 *
 * Java allows you to specify digits in several other formats:
 * Binary       (digits 0–1)                       which uses the number 0 followed by b or B as a prefix—for example, 0b10, 0B10
 * Octal        (digits 0–7)                       which uses the number 0 as a prefix—for example, 017
 * Hexadecimal  (digits 0–9 and letters A–F/a–f)   which uses 0x or 0X as a prefix—for example, 0xFF, 0xff, 0XFf.
 *
 * Hexadecimal is caseinsensitive so all of these examples mean the same value.
 * Underscores in numbers are allowed to make them easier to read.
 * You can add underscores anywhere except at the beginning, at the end, right before a decimal, or right after a decimal.
 *
 * Bydefault all whole numbers literals are treated as int starting from short ending range
 * Bydefault all decimal numbers literals are treated as double
 */
public class PrimitiveTypes {

    public static void main(String[] args) {
        int i22 = 010;
        int j33 = 07;
        System.out.println(i22);
        System.out.println(j33);

        double num1 = 2.718;
        //double num2 = 2._718;
        double num3 = 2.7_1_8;
        //double num4 = 2.718_;
        double num5 = 2______________3;

        byte b = 127;
        short s = 32767;
        char c = 65535;
        int i = 2147483647;
        long l1 = 2147483647;                   //here the literal is treated as an int and compiler cast it to long
        //long l2 = 2147483648;                 //compile error- need to add l or L to avoid compile error and treat it as long value
        long l3 = 2147483648L;
        long l4 = 9223372036854775807L;

        float f1 = 2147483647;                  //here the literal is treated as an int and compiler cast it to float
        //float f2 = 2147483648;                //compile error - as the literal value is treated as int and its out of range as per int range
                                                // need to add l or L to avoid compile error and treat it as long value
        float f3 = 2147483648L;
        //float f4 = 99999999999999999999999999999999999999L;//compile error as the value treated as long but out of range as per long range
        float f5 =  99999999999999999999999999999999999999F;

        //float f6 = 1.24;                      //here the literal is treated as double, unless postfixes with f. Double cannot be widened to float
        double d = 99999999999999999999999999999999999999F;
    }
}
