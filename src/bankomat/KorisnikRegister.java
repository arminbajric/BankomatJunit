package bankomat;

import java.util.ArrayList;

public class KorisnikRegister extends KorisnikSign  {
	ArrayList<String> temp = new ArrayList<>();

	

	public void setTemp(ArrayList<String> temp) {
		this.temp = temp;
	}

	@Override
	public void kreirajKorisnika(String imeVlasnika, double stanjeRacuna) {
		super.kreirajKorisnika(imeVlasnika, stanjeRacuna);
	}

	@Override
	public boolean checkAccounts(int brRacuna) {
		return super.checkAccounts(brRacuna);
	}
}
