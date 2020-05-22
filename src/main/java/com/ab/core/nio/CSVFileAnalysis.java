package com.ab.core.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Arpit Bhardwaj
 */
public class CSVFileAnalysis {
    public static void main(String[] args) {
        Path path = Paths.get("files/data.csv");
        //Function<String,Person> lineToPerson = line -> lineToPerson(line);

        try (/*BufferedReader reader = Files.newBufferedReader(path);*/
             Stream<String> lines = Files.lines(path);) {

            //Stream<String> lines = reader.lines();
            /*lines.filter(line -> !line.startsWith("#"))
                    .map(lineToPerson)
                    .forEach(System.out::println);*/

            lines.filter(line -> !line.startsWith("#"))
                    .flatMap(CSVFileAnalysis::lineToPerson)
                    .forEach(System.out::println);

            /*String line = reader.readLine();
            while (line != null){
                if (!line.startsWith("#")){
                    Person person = lineToPerson.apply(line);
                    System.out.println("Person = " + person);
                }
                line = reader.readLine();
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Stream<Person> lineToPerson(String line) {
        try{
            String[] elements = line.split(";");
            String name = elements[0];
            int age = Integer.parseInt(elements[1]);
            String city = elements[2];
            return Stream.of(new Person(name,age,city));
        }catch (Exception e){

        }
        return Stream.empty();
    }
}
