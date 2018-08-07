package bankomat;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class bankomatTest {
	
	public static Scanner unos() {
		Scanner unos = new Scanner(System.in);
		return unos;
	}

	public static int getInputInt() {
		
		int a = 0;
		try {
			System.out.println("Unesite vrijednost:");
			a = unos().nextInt();
		} catch (InputMismatchException e) {
			getInputInt();
		}
		return a;
	}

	public static double getInputDbl() {
		
		double a = 0;
		try {
			System.out.println("Unesite vrijednost:");
			a = unos().nextDouble();
		} catch (InputMismatchException e) {
			getInputInt();
		}
		return a;
	}

	// metoda za ispisivanje pocetnog menija
	public static void ispisiLoginRegister() {
		System.out.println("1.Login");
		System.out.println("2.Register");
		System.out.println("0.Kraj");
	}

//metoda koja ispisuje logged in meni
	public static void ispisiMeni() {
		System.out.println("1.Podizanje novca");
		System.out.println("2.Transfer novca");
		System.out.println("3.Ispisi informacije o racunu");
		System.out.println("0.Izlaz");
	}

	public static void main(String[] args) {
		
		// privremeni arraylist preko kojeg se updajtuje glavna baza podataka
		ArrayList<String> temp = new ArrayList<>();

		Racun test;
		KorisnikSign korisnik;
// okidaèi za switch selekciju
		int trigger = -1;
		int trigger2 = -1;
		ispisiLoginRegister();

		while (trigger != 0) {

			trigger = getInputInt();
			switch (trigger) {
			case 1:
				// prilikom logovanja kreira se nova instanca te se updejtuje baza podataka
				korisnik = new KorisnikLogIN(temp);
				// logovanje korisnika sa jedinstvenim brojem raèuna

				System.out.println("Broj raèuna:");

				int brRacuna = getInputInt();
//provjera da li se broj raèuna nalazi u bazi
				if (korisnik.checkAccounts(brRacuna)) {

					// definisanje stanja da je korisnik logovan
					korisnik.setState(true);
					// ispis korisnièkog menija
					ispisiMeni();
					while (trigger2 != 0) {
						trigger2 = getInputInt();
						switch (trigger2) {
						case 1:

							test = new Transakcija(temp);
							System.out.println("Iznos za podizanje:");
							double iznos = getInputDbl();
							if(iznos>0)
							{
							test.podizanjeNovca(brRacuna, iznos);
							}
							else
							{
								System.out.println("Pogrešan unos iznosa!Pokušajte ponovo.");
							}
							ispisiMeni();
							break;
						case 2:

							test = new Transakcija(temp);

							System.out.println("Broj izvornog raèuna");
							int sourceAcc = getInputInt();
							int targetAcc;

							System.out.println("Broj odredišnog raèuna");
							targetAcc = getInputInt();

							System.out.println("Iznos za transakciju");

							double value = getInputDbl();
							if(value>0)
							{
							test.izvrsiTransakciju(sourceAcc, targetAcc, value);
							}
							else
							{
								System.out.println("Pogrešan unos iznosa!.Pokušajte ponovo.");
							}
							ispisiMeni();
							break;
						case 3:
							korisnik.ispisiInformacije(brRacuna);
							ispisiMeni();
							break;
						case 0:
							korisnik.setState(false);

						}
					}
				} else {

					System.out.println("Došlo je do greške!");
				}
				break;
			case 2:
              
				korisnik = new KorisnikRegister(temp);

				

				System.out.println("Unesite ime vlasnika:");
				String imeVlasnika = unos().nextLine();

				System.out.println("Stanje racuna:");

				double stanjeRacuna = getInputDbl();
				korisnik.kreirajKorisnika(imeVlasnika, stanjeRacuna);
				System.out.println("Vas broj racuna je: " + korisnik.getBrojRacuna());
				ispisiLoginRegister();
				temp = korisnik.getTemp();
				System.out.println(korisnik.getTemp());
				break;
			}
		}
	}

}
