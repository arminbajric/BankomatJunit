package bankomat;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Transakcija extends Racun implements Bank {

	

	public void setTemp(ArrayList<String> temp) {
		this.temp = temp;
	}

	ArrayList<String> temp = new ArrayList<>();

	boolean checkBalance(int brojRacuna, double iznosSlanja) throws FileNotFoundException
	{
		if(super.checkBalance(brojRacuna, iznosSlanja))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	public void izvrsiTransakciju(int sourceAcc, int targetAcc, double iznos) throws IOException {

		super.smanjiStanjeRacuna(sourceAcc, iznos);
		super.povecajStanjeRacuna(targetAcc, iznos);

	}
	public void podizanjeNovca(int sourceAcc, double iznos) throws IOException {
		super.smanjiStanjeRacuna(sourceAcc, iznos);
	}
	public void uplatiNovacNaRacun(int sourceAcc,double iznos) throws IOException
	{
		super.povecajStanjeRacuna(sourceAcc, iznos);
	}
}
