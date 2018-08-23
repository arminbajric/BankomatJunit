package bankomat;

import java.io.IOException;


public interface Bank {
	
	 boolean checkAccounts(int accNumber);
	 void izvrsiTransakciju(int sourceAcc, int targetAcc, double iznos) throws IOException;
	 void podizanjeNovca(int sourceAcc, double iznos) throws IOException;
	 void uplatiNovacNaRacun(int sourceAcc,double iznos) throws IOException;
}
