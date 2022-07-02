import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;



public class Ex1 {


    public static List<String> getOddNames(List<String> input) {
//Метод принимает на вход список имен. Вернуть строку в виде:
// "1. Ivan, 3. Peter ...",
// с именами из списка, стоящими под нечетным индексом (1, 3 и т.д.).
        return IntStream.range(0, input.size()).filter(n -> n % 2 != 0).mapToObj(input::get).collect(Collectors.toList());
//Метод range() в классе IntStream в Java используется для возврата последовательного упорядоченного IntStream из startInclusive в endExclusive с шагом, равным 1.
//Для фильтрации элементов в потоке применяется метод filter(), который представляет промежуточную операцию. Он принимает в качестве параметра некоторое условие в виде объекта Predicate<T> и возвращает новый поток из элементов, которые удовлетворяют этому условию:
//mapToObj() в классе IntStream на Java возвращает объектно-ориентированный поток, состоящий из результатов применения данной функции к элементам этого потока.
//В метод collect() нужно передать специальный объект — collector . Этот объект вычитывает все данные из потока, преобразует их к определенной коллекции и возвращает ее. А следом за ним эту же коллекцию возвращает и сам метод collect.
// метод ToList() перебирает каждый элемент предоставленной коллекции и добавляет их в новый экземпляр List и возвращает этот экземпляр.
    }
//..доделать , чтобы нумерацию добавлял..


    public static List<String> getReverseOrder(List<String> input) {
//Метод принимает на вход список из строк (можно список из Задания 1).
// Возвращает список этих строк в верхнем регистре и отсортированные по
// убыванию (от Z до А).
        return input.stream().map(String::toUpperCase).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
// получить последовательный поток по списку и вызвать map() метод для применения заданной функции к элементам потока. Этот подход можно использовать, когда вам нужен новый список, а исходный список оставить без изменений.
//Comparator.reverseOrder() который возвращает компаратор, который сравнивает объекты в обратном порядке.

    }

    public static String arrayToStringSort(String[] strings) {
//Дан массив:
//["1, 2, 0", "4, 5"]
//Получить из массива все числа, вернуть в отсортированном виде,
// разделенные запятой, то есть
//"0, 1, 2, 4, 5"
            return Arrays.stream(strings) // массив в поток
                    .flatMap(s -> Stream.of(s.split(", "))) // Этот метод принимает одну функцию в качестве аргумента, эта функция принимает один параметр T в качестве входного аргумента и возвращает один поток параметра R в качестве возвращаемого значения
                    .map(Integer::valueOf)// переобарзовывает в инт
                    .sorted(/*Integer::compareTo*/)//сортировка в естественном прядке ,с аргументом пока не разобрался
                    .map(String::valueOf) //обратно в строку
                    .collect(Collectors.joining(", ")); //Collectors.joining() метод возвращает Collector который объединяет входные элементы в одну строку.
        }

        public static Stream<Long> getEndlessStream(Long seed, Long a, Long c, Long m) {
//Используя Stream.iterate сделайте бесконечный стрим рандомных чисел,
// но не используя Math.random. Реализуйте свой "линейный конгруэнтный генератор".
// Для этого начните с x[0] = seed и затем каждый следующий
// элемент x[n + 1] = 1 (a x[n] + c) % m, для корректных значений a, c, и m.
// Необходимо имплементировать метод, который принимает на вход параметры a,
// c, m и seed и возвращает Stream<Long>. Для теста используйте
// данные a = 25214903917, c = 11 и m = 2^48 (2 в степени 48).
            return Stream.iterate(new Long[]{seed, a, c, m}, n -> new Long[]{(n[1] * n[0] + n[2]) % n[3], n[1], n[2], n[3]})
                    .map(n -> n[0]);
        }

        public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
//Напишите метод public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
// который "перемешивает" элементы из стримов first и second, останавливается
// тогда, когда у одного из стримов закончатся элементы.
            Iterator<T> iteratorFirst = first.iterator();
            Iterator<T> iteratorSecond = second.iterator();
            Stream<T> resultStream = Stream.empty();

            while (iteratorFirst.hasNext() && iteratorSecond.hasNext()) {
                resultStream = Stream.concat(resultStream, Stream.of(iteratorFirst.next(), iteratorSecond.next()));
            }

            return resultStream;
        }


    }

