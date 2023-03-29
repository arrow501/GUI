import java.util.*;

public class Test {

    public static void main(String[] args) {

        // tworzenie listy osób
        List<Person> lista = Arrays.asList(
                new Person("Anna", 23),
                new Person("Maria", 22),
                new Person("Anna", 20),
                new Person("Wojciech", 21));
        // sortowanie według podanego komparatora (po imię)
        Collections.sort(lista, new PersonComparator(PersonComparator.CompareBy.NAME));
        System.out.println(lista);

        // sortowanie według podanego komparatora (po wieku)
        Collections.sort(lista, new PersonComparator(PersonComparator.CompareBy.AGE));

        // lub zamiast komparatora "po wieku" napisać wyrażenie lambda w miejscu /* ...
        // */
        Collections.sort(lista, (p1, p2) -> p1.getAge() - p2.getAge());
        System.out.println(lista);

        // sortowanie według porządku naturalnego określonego w klasie Person
        Collections.sort(lista);
        System.out.println(lista);
    }

}