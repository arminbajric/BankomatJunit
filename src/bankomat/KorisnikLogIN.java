package bankomat;

import java.util.ArrayList;

public class KorisnikLogIN extends KorisnikSign implements Bank {
	KorisnikLogIN(ArrayList<String> temp) {
		super(temp);
		// TODO Auto-generated constructor stub
	}
	boolean state;
	ArrayList<String> temp=new ArrayList<>();
	public void setTemp(ArrayList<String> temp) {
		this.temp = temp;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public boolean checkAccounts(int brRacuna)
	{
		return super.checkAccounts(brRacuna);
		}
	public void ispisiInformacije(int sourceAccount)
	{
		super.ispisiInformacije(sourceAccount);
	}
}
