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

	boolean checkBalance(int brojRacuna, double iznosSlanja)
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
	public void izvrsiTransakciju(int sourceAcc, int targetAcc, double iznos) {

		super.smanjiStanjeRacuna(sourceAcc, iznos);
		super.povecajStanjeRacuna(targetAcc, iznos);

	}
	public void podizanjeNovca(int sourceAcc, double iznos) {
		super.smanjiStanjeRacuna(sourceAcc, iznos);
	}
	public void uplatiNovacNaRacun(int sourceAcc,double iznos)
	{
		super.povecajStanjeRacuna(sourceAcc, iznos);
	}
}
