import java.util.Arrays;

public abstract class Spiewak {
    private String imie;
    private int id;
    private static int ID = 1;
    
    public Spiewak(String imie){
        this.imie = imie;
        this.id = ID++;
    }
    
    abstract String spiewaj();
    
    
    public String toString(){
        return "(" + getId() + ") " + getImie() + ": " + spiewaj();
    }
    static Spiewak najglosniej(Spiewak[] spiewacy){
        return Arrays.stream(spiewacy)
            .max((Spiewak s) -> glosnosc(s.spiewaj()))
            .get();
    }
    static int glosnosc(String spiew){

        char max_letter = 0;
        char max_number = 0;

        for (char c: spiew.toCharArray()) {
            if(c >= 'a' && c <= 'z' && max_letter < c){
                max_letter = c;
            } else if ( c >= '0' && c <= '9' && max_number < c){
                max_number = c;
            }
        }
        return (int)(max_letter + max_number);
    }

    private int getId(){
        return id;
    }
    private String getImie(){
        return imie;
    }
}