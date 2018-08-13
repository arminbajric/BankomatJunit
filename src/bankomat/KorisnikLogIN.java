package bankomat;

import java.util.ArrayList;

public class KorisnikLogIN extends KorisnikSign  {
	KorisnikLogIN(ArrayList<String> temp) {
		super(temp);
		// TODO Auto-generated constructor stub
	}
	boolean korisnikLogovan;
	ArrayList<String> temp=new ArrayList<>();
	public void setTemp(ArrayList<String> temp) {
		this.temp = temp;
	}
	public boolean isState() {
		return korisnikLogovan;
	}
	public void setState(boolean state) {
		this.korisnikLogovan = state;
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
