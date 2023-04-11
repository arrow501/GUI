import java.util.*;
import java.util.List;

public class Salony {
    public static void main(String[] args) {
        String[] arr = {
                "salon A", "Mercedes", "130000",
                "salon B", "Mercedes", "120000",
                "salon C", "Ford", "110000",
                "salon B", "Opel", "90000",
                "salon C", "Honda", "95000",
                "salon A", "Ford", "105000",
                "salon A", "Renault", "75000"
        };
        Map<String, List<Samochod>> salony = new HashMap<String, List<Samochod>>();

        for (int i = 0; i < arr.length; i += 3) {
            if (!salony.containsKey(arr[i])) {
                // new key
                var list = new ArrayList<Samochod>();
                list.add(new Samochod(arr[i + 2], arr[i + 1]));
                salony.put(arr[i], list);
            } else {
                // existing keys
                salony.get(arr[i]).add(new Samochod(arr[i + 2], arr[i + 1]));
            }
        }
        for (var salon : salony.entrySet()) {
            // Salon:
            System.out.println(salon.getKey() + ":");
            for (var auto : salon.getValue()) {
                // - Model, Cena
                System.out.println("\t - " + auto.getBrand() + ", " + auto.getPrice());
            }
        }

        // Cheapest Samochód
        Samochod cheapest = salony
                .values()
                .stream()
                .map(list -> Collections.min(list))
                .min((a, b) -> a.getPrice() - b.getPrice())
                .get();
        for (var salon : salony.keySet()) {
            if (salony.get(salon).contains(cheapest)) {
                System.out.println(
                        "najtanszy samochod:" + cheapest.getBrand() + ", " + cheapest.getPrice() + ", " + salon);
            }
        }
        System.out.println("najtanszy samochod:" + cheapest.getBrand() + ", " + cheapest.getPrice());
    }
}
