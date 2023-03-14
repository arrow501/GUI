import java.util.Arrays;
import java.util.Comparator;

abstract class Muzyk {

	private String imie;
	private double czas;

	// konstruktor
	protected Muzyk(String imie, double czas) {
		this.imie = imie;
		this.czas = czas;
	}

	// metoda getter
	protected String imie() {
		return this.imie;
	}

	// metoda getter
	protected double czas() {
		return this.czas;
	}

	// metody abstrakcyjne
	abstract protected String instrument();

	abstract protected double stawka();

	public String toString() {
		return "Imie: " + imie() + ", Czas: " + czas() + ", Stawka: " + stawka() + ";";
	}

	public static Muzyk maxHonorarium(Muzyk[] muzycy) {
		Muzyk max = Arrays.stream(muzycy)
				.max(Comparator.comparing(muzyk -> muzyk.stawka() * muzyk.czas()))
				.get();
		return max;
	}

}