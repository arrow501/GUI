import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    public static enum CompareBy{
        AGE, NAME;
    }
    private CompareBy criterion;
    public PersonComparator(CompareBy criterion) {
        this.criterion = criterion;
    }

    @Override
    public int compare(Person o1, Person o2) {
        return switch(criterion){
            case AGE -> o1.getAge() - o2.getAge();
            case NAME -> o1.getName().compareTo(o2.getName());
        };
    }
}
