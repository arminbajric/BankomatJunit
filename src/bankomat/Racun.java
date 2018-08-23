package bankomat;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Scanner;
public class Racun  implements Bank  {
	private int brojRacuna;
	
	 private File file;
	
		
	

	public void kreirajKorisnika(String imeVlasnika, double stanjeRacuna)

	{

		do {

			brojRacuna = (int) (Math.random() * 100000);
			file=new File(brojRacuna+".txt");
		} while (file.exists()|| brojRacuna < 10000);
 file=new File(brojRacuna+".txt");
try {
	if(file.createNewFile())
	{
		
		try {
			PrintWriter writer = null;
			 writer = new PrintWriter(new FileWriter(file));
			
			writer.write(imeVlasnika);
			writer.println();
			writer.write( String.valueOf(stanjeRacuna));
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Registrovani ste");}
	
} catch (IOException e) {
	
}


	}

	

	

	public int getBrojRacuna() {

		return brojRacuna;
	}

	public boolean checkAccounts(int accNumber) {

		
		file =new File(accNumber+".txt");
		if (file.exists()) {
			return true;
		}
		else
		{
			return false;
		}
		
	}

	protected void povecajStanjeRacuna(int brojRacuna, double iznos) throws IOException {
		file =new File(brojRacuna+".txt");
		Scanner unos=new Scanner(file);
		String value,ime;
		ime=unos.nextLine();
		value=unos.nextLine();
		iznos+=Double.parseDouble(value);
		PrintWriter writer = null;
		 writer = new PrintWriter(new FileWriter(file));
		 writer.write(ime);
		 writer.println();
		 writer.write(String.valueOf(iznos));
		 writer.close();
		 unos.close();
	}

	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	protected void smanjiStanjeRacuna(int brojRacuna, double iznos) throws IOException {
		file =new File(brojRacuna+".txt");
		Scanner unos=new Scanner(file);
		String value,ime;
		ime=unos.nextLine();
		value=unos.nextLine();
		double stanje=Double.parseDouble(value);
		stanje+=-iznos;
		PrintWriter writer = null;
		 writer = new PrintWriter(new FileWriter(file));
		 writer.write(ime);
		 writer.println();
		 writer.write(String.valueOf(stanje));
		 writer.close();
		 unos.close();
	}

	boolean checkBalance(int brojRacuna, double iznosSlanja) throws FileNotFoundException {
		file =new File(brojRacuna+".txt");
		Scanner unos=new Scanner(file);
		String value,ime;
		ime=unos.nextLine();
		value=unos.nextLine();
		double balance=Double.parseDouble(value);
			if (balance >= iznosSlanja) {
				unos.close();
				return true;
			}
			else
			{ 
				unos.close();
				return false;
			}

		
	}

	public void ispisiInformacije(int sourceAccount) throws FileNotFoundException {
		file =new File(brojRacuna+".txt");
		Scanner unos=new Scanner(file);
		String value,ime;
		ime=unos.nextLine();
		value=unos.nextLine();
		System.out.println("Broj racuna: " + sourceAccount);
		System.out.println("Ime vlasnika:" + ime);
		System.out.println("Stanje racuna: " + value);
	}

	@Override
	public void izvrsiTransakciju(int sourceAcc, int targetAcc, double iznos) throws IOException {

		this.smanjiStanjeRacuna(sourceAcc, iznos);
		this.povecajStanjeRacuna(targetAcc, iznos);
	}

	@Override
	public void podizanjeNovca(int sourceAcc, double iznos) throws IOException {
		this.smanjiStanjeRacuna(sourceAcc, iznos);

	}

	@Override
	public void uplatiNovacNaRacun(int sourceAcc, double iznos) throws IOException {
	

	}





	
	

}
