package Ables;

import java.util.Arrays;
import java.util.Comparator;

class Main{
    public static void main(String[] args) {
        Speakable[] speaks = new Speakable[5];
        Flyable[] flies = new Flyable[5];

        // Speakables
        speaks[0] = new Bird();
        speaks[1] = new Plane();
        speaks[2] = new UFO();
        speaks[3] = new Bird(){
            // Rooster
            @Override
            public String speak(){
                return "cock-a-doodle-doo";
            }

            @Override
            public double distance(){
                return 5;
            }
        };
        speaks[4] = new Speakable() {
            @Override
            public String speak(){
                return "Meow~ x3";
            }
        };

        // Flyables
        flies[0] = new Virus();
        flies[1] = new Bird();
        flies[2] = new UFO();
        flies[3] = Flyable.hybrid(flies[0], flies[2]);
        flies[4] = Flyable.hybrid(flies[1], new Plane());

        System.out.println("Speakables: \n" + Arrays.toString(speaks));
        System.out.println("Flyables: \n" + Arrays.toString(flies));

        System.out.println("The loudest object is: " + getLoudest(speaks)+ ".");
        System.out.println("The worst flier is: " + getShortestFlyer(flies)+ ".");
    }
    static Speakable getLoudest(Speakable[] speakables){
        return Arrays.stream(speakables)
            .max(Comparator.comparing(
                speakable -> speakable.speak().length()))
            .get();
    }
    static Flyable getShortestFlyer(Flyable[] flyables){
        return Arrays.stream(flyables)
            .min(Comparator.comparing(flyable -> flyable.distance()))
            .get();
    }
}


