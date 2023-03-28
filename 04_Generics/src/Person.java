public class Person implements Comparable<Person> {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "(" + getName() + ", " + getAge() + ")";
    }
    @Override
    public int compareTo(Person o) {
        if(this.getName().equals(o.getName()))
            return this.getAge() - o.getAge();
        return this.getName().compareTo(o.getName());
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}
