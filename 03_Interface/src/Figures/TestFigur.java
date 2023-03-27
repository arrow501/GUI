package Figures;

public class TestFigur {
   
    public static void main(String[] args)
    {   
        zadanie("5"); // ==================================
            
        Figure fig[] = new Figure[2];
        fig[0] = new Circle(10, 10, 5);                    // położenie koła = srodek = (10,10), promień = 5
        fig[1] = new Rectangle(20, 20, 15, 10);    // położenie prostokąta = lewy górny wierzchołek = (20,20), szerokość = 15, wysokość = 10
      
            // polimorficzne wywołanie metody toString() z klas Kolo/Prostokat,
            // a nie z klasy Figure
        for (Figure f : fig)              // pętla for-each
            System.out.println(f);    // System.out.println(f.toString());
      
        fig[0].pozycja(12, 12);                    
        fig[1].pozycja(25, 30);

        zadanie("6a"); // ==================================
        System.out.println(
            "Pole koła: " + fig[0].getArea() + "\n" +
            "Obwód Koła: " + fig[0].getPerimeter() + "\n" +
            "Pole prostokątu: " + fig[1].getArea() + "\n" +
            "Obwód Prostokątu: " + fig[1].getPerimeter()
            );

        zadanie("6b"); // ==================================
        Figure p2 = new Prostokat2(20, 20, 10, 5, '*'); 
        ((Prostokat2)p2).rysuj(); 
        // p2.rysuj nie działa ponieważ Figure nie implemetuje interface'u Draw

        zadanie("6c"); // ===================================

        Kolo2 k2 = new Kolo2(15, 20, 5);
        k2.przesunDo(50, 40); 
        System.out.println(k2);
        k2.powrot(); 
        System.out.println(k2);
    }
    public static void zadanie(String numer){
        System.out.println("\n== Zadanie " + numer + " ======================\n");
    }
}