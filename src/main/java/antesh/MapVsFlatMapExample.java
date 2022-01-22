package antesh;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* The map() and flatmap() are two important operations in the new functional Java 8.
* Both represent functional operation and they are also methods in java.util.stream.Stream class
* but the map is used for transformation and flatmap is used for both transformation and flattening,
* that's why it's called the flatmap.
* The key difference between map() and flatmap() function is that when you use a map(),
* it applies a function on each element of the stream and stores the value returned by the function
* into a new Stream. This way one stream is transformed into another like a Stream of String is
* transformed into a Stream of Integer where each element is the length of the corresponding Stream.
*
* The key thing to remember is that the function used for transformation in the map() returns a single value.
* If map() uses a function, which, instead of returning a single value returns a Stream of values
* then you have a Stream of Stream of values, and flatmap() is used to flat that into a Stream of values.
*
* For example, if we have a Stream of String containing {"12", "34"}, and a method getPermutations() which
* returns a list of permutations of given String. When you apply that function into each String of Stream
* using map you will get something like [["12","21"],["34","43"]], but if you use flatmap, you get a Stream
* of Strings e.g. ["12", "21", "34", "43"].
*
* How Stream.map() works in Java 8? Example
The Stream.map() function performs map functional operation i.e. it takes a Stream and transforms it to another
* Stream. It applies a function on each element of Stream and stores return value into new Stream.

This way you can transform a Stream of String into a Stream of Integer where Integer could be the length of String
* if you supply the length() function. This is a very powerful function that is very helpful while dealing with
* collection in Java.

Here is an example of Stream.map() in Java 8:

List listOfIntegers = Stream.of("1", "2", "3", "4")
               .map(Integer::valueOf)
               .collect(Collectors.toList());

In this example, we have a Stream of String values which represent numbers, by using the map() function
* we have converted this Stream to Stream of Integers. How? by applying Integer.valueOf() on each element of Stream.
* That's how "1" converted to integer 1 and so on. Once the transformation is done, we have collected the result
* into a List by converting Stream to List using Collectors.

*
* */

public class MapVsFlatMapExample {

    public static void main(String[] args) {
        List<Employee> employees = Employee.getEmployees();

        //Map transforms the Stream of objects and there will be only 1:1 mapping. i.e.
        //1 object from stream will be transformed into another based on transform function at a time
        //when you use map() function, it applies a map function on each element of the stream
        // and stores the value returned by the function into new stream
        //input: stream --->transform map() ---> output: another stream {Stream<String> --map()--> Stream<Integer>}
        //here only employees with even number employee iD will be transformed and collected
        List<String> employeesMapResults = employees.stream()
                .filter(emp -> emp.getId() % 2 == 0)
                .map(Employee::getFirstName)
                .collect(Collectors.toList());

        System.out.println(employeesMapResults + "\n");

        List listOfIntegers = Stream.of("1", "2", "3", "4")
                .map(Integer::valueOf)
                .collect(Collectors.toList());  // {1, 2, 3, 4}


        List<Employee> employeeList = Stream.of(employees, employees, employees)
                .flatMap(list->list.stream())
                .collect(Collectors.toList());
        System.out.println(employeeList + "\n");

    }
}
