package bankomat;

import java.util.ArrayList;

public class Racun implements Bank {
	private int brojRacuna;

	private ArrayList<String> baza = new ArrayList<>();

	Racun(ArrayList<String> temp) {
		this.baza = temp;
	}

	public void kreirajKorisnika(String imeVlasnika, double stanjeRacuna)

	{

		do {

			brojRacuna = (int) (Math.random() * 100000);
		} while (baza.contains(String.valueOf(brojRacuna)) || brojRacuna < 10000);

		baza.add(String.valueOf(brojRacuna));
		baza.add(imeVlasnika);
		baza.add(String.valueOf(stanjeRacuna));

	}

	public ArrayList<String> getTemp() {
		return baza;
	}

	public void setTemp(ArrayList<String> baza) {
		this.baza = baza;
	}

	public int getBrojRacuna() {

		return brojRacuna;
	}

	public boolean checkAccounts(int accNumber) {

		boolean provjera = false;
		String acNumber = String.valueOf(accNumber);
		if (this.baza.contains(acNumber)) {
			provjera = true;
		}
		return provjera;
	}

	protected void povecajStanjeRacuna(int brojRacuna, double iznos) {
		int indeks = baza.indexOf(Integer.toString(brojRacuna));
		double stanje = Double.parseDouble((String) baza.get(indeks + 2));
		stanje += iznos;
		baza.set((indeks + 2), Double.toString(stanje));
	}

	protected void smanjiStanjeRacuna(int brojRacuna, double iznos) {
		int indeks = baza.indexOf(Integer.toString(brojRacuna));
		double stanje = Double.parseDouble((String) baza.get(indeks + 2));
		stanje -= iznos;
		baza.set((indeks + 2), Double.toString(stanje));
	}

	boolean checkBalance(int brojRacuna, double iznosSlanja) {
		int indeks;
		double balance;
		boolean provjera = false;
		if (baza.contains(Integer.toString(brojRacuna))) {
			indeks = baza.indexOf(Integer.toString(brojRacuna));
			balance = Double.parseDouble((String) baza.get(indeks + 2));
			if (balance > iznosSlanja) {
				provjera = true;
			}
		}

		return provjera;
	}

	public void ispisiInformacije(int sourceAccount) {
		int indeks = baza.indexOf(String.valueOf(sourceAccount));
		System.out.println("Broj racuna: " + baza.get(indeks));
		System.out.println("Ime vlasnika:" + baza.get(indeks + 1));
		System.out.println("Stanje racuna: " + baza.get(indeks + 2));
	}

	@Override
	public void izvrsiTransakciju(int sourceAcc, int targetAcc, double iznos) {

		this.smanjiStanjeRacuna(sourceAcc, iznos);
		this.povecajStanjeRacuna(targetAcc, iznos);
	}

	@Override
	public void podizanjeNovca(int sourceAcc, double iznos) {
		this.smanjiStanjeRacuna(sourceAcc, iznos);

	}

	@Override
	public void uplatiNovacNaRacun(int sourceAcc, double iznos) {
		// TODO Auto-generated method stub

	}

}
