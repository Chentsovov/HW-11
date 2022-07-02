import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//Ex1
        List<String> input = Arrays.asList("1. First", "2. Second", "3. Third", "4. Fourth", "5. Fifth", "6. Sixth",
                "7. Seventh", "8. Eighth");
        List<String> res1 = Ex1.getOddNames(input);
        System.out.println("========================================================================================");
        System.out.println(res1);

//Ex2
        List<String> res2 = Ex1.getReverseOrder(input);
        System.out.println("========================================================================================");
        System.out.println(res2);

//Ex3
        String[] input2 = new String[]{"1, 2, 0", "4, 5"}; //массив строк
        String res3 = Ex1.arrayToStringSort(input2);
        System.out.println("========================================================================================");
        System.out.println(res3);

//Ex4
        Stream<Long> digits = Ex1.getEndlessStream(1L, 25214903917L, 11L, (long) Math.pow(2, 48));
        System.out.println("========================================================================================");
        digits.limit(10).forEach(x -> System.out.println(x + " "));

//Ex5
        Stream<String> first = Stream.of("a", "b", "c", "d", "e", "f", "g", "h");
        Stream<String> second = Stream.of("1", "2", "3", "4", "5", "6");
        Stream<String> res = Ex1.zip(first, second);
        List<String> ress = res.collect(Collectors.toList()); //преобразует поток в список
        System.out.println("========================================================================================");
        ress.forEach(System.out::print);


}
}