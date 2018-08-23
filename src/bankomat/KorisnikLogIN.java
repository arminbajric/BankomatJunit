package bankomat;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class KorisnikLogIN extends KorisnikSign  {
	
	boolean korisnikLogovan;
	ArrayList<String> temp=new ArrayList<>();
	public void setTemp(ArrayList<String> temp) {
		this.temp = temp;
	}
	public boolean isState() {
		return korisnikLogovan;
	}
	public void setBrojRacuna(int brojRacuna) {
		super.setBrojRacuna(brojRacuna);
	}
	public void setState(boolean state) {
		this.korisnikLogovan = state;
	}
	public boolean checkAccounts(int brRacuna)
	{
		return super.checkAccounts(brRacuna);
		}
	public void ispisiInformacije(int sourceAccount) throws FileNotFoundException
	{
		super.ispisiInformacije(sourceAccount);
	}
}
