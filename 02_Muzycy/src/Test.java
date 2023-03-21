import Skrzypek;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Test {

    public static void main(String[] args) {
    System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));

    
        Muzyk[] muzycy = {new Skrzypek("Aleks", 2),				// Imie, czas wystapienia (w godz.)
                       	  new Wiolonczelista("Bartek", 1),
                          new Flecista("Czarek", 0.5)
						};
		for (Muzyk m : muzycy)
			System.out.println("Muzyk: " + m.imie() + '\n' +
							   "Instrument: " + m.instrument() + '\n' +
                               "Czas wystąpienia: " + m.czas() + " godz. " + '\n' +
                               "Stawka godzinowa: " + m.stawka() + '\n');
	
		System.out.println(Muzyk.maxHonorarium(muzycy));		// muzyk otrzymujący najwyższe honorarium za występ
	 
    }
}
