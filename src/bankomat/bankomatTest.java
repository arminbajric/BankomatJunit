package bankomat;

import java.io.IOException;

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
		System.out.println("3.Uplati novac na ra�un");
		System.out.println("4.Ispisi informacije o racunu");
		System.out.println("0.Izlaz");
	}

	public static void main(String[] args) throws IOException {

		// privremeni arraylist preko kojeg se updajtuje glavna baza podataka
		

		Racun test;
		KorisnikSign korisnik;
// okida�i za switch selekciju
		int trigger = -1;
		int trigger2 = -1;
		ispisiLoginRegister();

		while (trigger != 0) {

			switch (trigger) {
			case 1:
				// prilikom logovanja kreira se nova instanca te se updejtuje baza podataka
				korisnik = new KorisnikLogIN();
				// logovanje korisnika sa jedinstvenim brojem ra�una
				System.out.println();
				System.out.println("Broj ra�una:");

				int brRacuna = getInputInt();
//provjera da li se broj ra�una nalazi u bazi
korisnik.setBrojRacuna(brRacuna);
				if (korisnik.checkAccounts(brRacuna)) {

					// ispis korisni�kog menija
					ispisiMeni();
					while (trigger2 != 0) {
						trigger2 = getInputInt();
						switch (trigger2) {
						case 1:
//podizanje novca sa ra�una
							test = new Transakcija();
							System.out.println("Iznos za podizanje:");
							double iznos = getInputDbl();
							if (iznos > 0) {
								test.podizanjeNovca(brRacuna, iznos);
							} else {
								System.out.println("Pogre�an unos iznosa!Poku�ajte ponovo.");
							}
							ispisiMeni();
							System.out.println();
							break;
						case 2:
//transakcija novca sa jednog ra�una na drugi
							test = new Transakcija();

							System.out.println("Broj izvornog ra�una");
							int sourceAcc = getInputInt();
							int targetAcc;

							System.out.println("Broj odredi�nog ra�una");
							targetAcc = getInputInt();

							System.out.println("Iznos za transakciju");

							double value = getInputDbl();
							// validacija stanja ra�una,ra�una,odredi�nog ra�una te une�ene vrijednosti za
							// transakciju
							if (test.checkBalance(sourceAcc, value)) {
								
								if (value > 0 && test.checkAccounts(sourceAcc) && test.checkAccounts(targetAcc)) {
									test.izvrsiTransakciju(sourceAcc, targetAcc, value);
								} else {
									System.out.println("Gre�ka!.Poku�ajte ponovo.");
								}
							} else {
								System.out.println("Nemate dovoljno novca na ra�unu!");
							}

							ispisiMeni();
							System.out.println();
							break;
						case 3:
							test=new Transakcija();
							System.out.println("Unesite iznos za uplatu:");
							 iznos=getInputDbl();
							 if(iznos>0)
							 {
								test.povecajStanjeRacuna(brRacuna, iznos); 
							 }
							break;
						case 4:
							korisnik.ispisiInformacije(brRacuna);
							ispisiMeni();
							System.out.println();
							break;
						case 0:

							ispisiLoginRegister();
							System.out.println();
							break;
						}

					}
				} else {

					System.out.println("Do�lo je do gre�ke!");
					ispisiLoginRegister();
				}
				break;
			case 2:

				korisnik = new KorisnikRegister();

				System.out.println("Unesite ime vlasnika:");
				String imeVlasnika = unos().nextLine();

				System.out.println("Stanje racuna:");

				double stanjeRacuna = getInputDbl();
				korisnik.kreirajKorisnika(imeVlasnika, stanjeRacuna);
				System.out.println("Vas broj racuna je: " + korisnik.getBrojRacuna());
				ispisiLoginRegister();
			
			
				System.out.println();
				break;
			}
			trigger2 = -1;
			trigger = getInputInt();
		}
	}

}
