package bankomat;

import java.util.ArrayList;

public class KorisnikSign extends Racun  {
	
	ArrayList<String> temp = new ArrayList<>();

	KorisnikSign(ArrayList<String> temp) {
		super(temp);
	}

	public void setTemp(ArrayList<String> temp) {
		this.temp = temp;
	}
	@Override
	public boolean checkAccounts(int brRacuna) {
		return super.checkAccounts(brRacuna);
	}
	public void kreirajKorisnika(String imeVlasnika, double stanjeRacuna)
	{
		super.kreirajKorisnika(imeVlasnika, stanjeRacuna);
	}
}
