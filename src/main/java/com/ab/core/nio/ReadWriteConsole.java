package com.ab.core.nio;

import java.io.Console;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Arpit Bhardwaj
 *
 * Run below command
 *
 * C:\Users\ARPIBHAR\IdeaProjects\CoreFundamentals\target\classes>java com.ab.core.nio.ReadWriteConsole
 */
public class ReadWriteConsole {
    public static void main(String[] args) {
        //console object is singleton and synchronized console
        Console console = System.console();//console is null here as intellij by default gives no console
        //writer object is singleton
        PrintWriter writer = console.writer();//no need to close (closing is redundant)
        writer.println("What is you name >");

        //reader object is singleton
        Reader reader = console.reader();//no need to close (closing is redundant)

        String name = console.readLine();
        writer.printf("Hello %s\n", name);

        writer.printf("What is your password %s?", name);
        char[] password = console.readPassword();

        writer.printf("%s is an easy password to guess!", new String(password));

        writer.printf("%s what are your favourite colors?", name);

        String colors = console.readLine();

        List<String> providedColors = new Scanner(colors)
                .useDelimiter(" ")
                .tokens()
                .collect(Collectors.toList());

        writer.println(providedColors);

    }
}
