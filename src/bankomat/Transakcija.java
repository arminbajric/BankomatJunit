package bankomat;

import java.util.ArrayList;

public class Transakcija extends Racun implements Bank {

	Transakcija(ArrayList<String> temp) {
		super(temp);

	}

	public void setTemp(ArrayList<String> temp) {
		this.temp = temp;
	}

	ArrayList<String> temp = new ArrayList<>();

	@Override
	public void izvrsiTransakciju(int sourceAcc, int targetAcc, double iznos) {
		super.izvrsiTransakciju(sourceAcc, targetAcc, iznos);
	}

	@Override
	public int getBrojRacuna() {
		return super.getBrojRacuna();
	}

	public void podizanjeNovca(int sourceAcc, double iznos) {
		if (super.checkBalance(sourceAcc, iznos)) {
			super.podizanjeNovca(sourceAcc, iznos);
			System.out.println("Preuzmite svoj novac!");
		} else {
			System.out.println("Došlo je do greške.Nemate dovoljno sredstava.");
		}
	}
}
