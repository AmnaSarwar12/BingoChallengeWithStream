import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static int counter = 0;
    public static void main(String[] args) {
       int seed = 1;
       var streamB = Stream.iterate(seed, i -> i <= 15, i-> i+1 )
               .map(i -> "B" + i);
       //streamB.forEach(System.out::println);

        seed += 15;
        var streamI = Stream.iterate(seed, i -> i + 1 )
                .limit(15)
                .map(i -> "I" + i);
       // streamI.forEach(System.out::println);

        seed += 15;
        int nseed =  seed;
        String[] oLabels = new String[15];
        Arrays.setAll(oLabels, i -> "N" + (nseed + i));
        var streamN = Arrays.stream(oLabels);


        seed += 15;
        var streamG = Stream.of("G46","G47","G48","G49","G50","G51","G52","G58","G59","G60","G61","G62",
        "G63","G64","G65");

        seed += 15;
        int rseed = seed;
        var streamO = Stream.generate(Main::getCounter)
                .limit(15)
                .map(i -> "O" + (rseed + i));
        //streamO.forEach(System.out::println);

        var streamBI = Stream.concat(streamB, streamI);
        var streamNG = Stream.concat(streamN, streamG);
        var streamBING = Stream.concat(streamBI,streamNG);
        Stream.concat(streamBING, streamO).forEach(System.out::println);

    }

    public static int getCounter(){
        return counter++;
    }
}