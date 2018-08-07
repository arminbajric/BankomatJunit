package bankomat;

import java.util.ArrayList;

public class KorisnikSign extends Racun implements Bank {
	private boolean state;
	ArrayList<String> temp = new ArrayList<>();

	KorisnikSign(ArrayList<String> temp) {
		super(temp);
	}

	public void setTemp(ArrayList<String> temp) {
		this.temp = temp;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	@Override
	public boolean checkAccounts(int brRacuna) {
		return super.checkAccounts(brRacuna);
	}

}
