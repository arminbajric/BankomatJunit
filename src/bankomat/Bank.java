package bankomat;

import java.util.ArrayList;

public interface Bank {
	 void setTemp(ArrayList<String> temp) ;
	 ArrayList<String> getTemp();
	 boolean checkAccounts(int accNumber);
	 void izvrsiTransakciju(int sourceAcc, int targetAcc, double iznos);
	 void podizanjeNovca(int sourceAcc, double iznos);
	 void uplatiNovacNaRacun(int sourceAcc,double iznos);
}
