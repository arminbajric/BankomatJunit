package bankomat;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Test;

public class BankomatJunit {
	@Test
public void provjeriRacun()
{
new Racun();	
}
	@Test
	public void provjeriTransakcija()
	{
	new Transakcija();	
	}
	@Test
	public void provjeriKorisnikSign()
	{
	new KorisnikSign();	
	}
	@Test
	public void provjeriKorisnikRegister()
	{
	new KorisnikRegister();	
	}
	@Test
	public void provjeriKorisnikLogIn()
	{
	new KorisnikLogIN();	
	}
	@Test
	public void provjeriKorisnickiracun()
	{
		Racun test=new Racun();
		assertTrue(test.checkAccounts(22));
		assertFalse(test.checkAccounts(3));
		
	}
	@Test
	public void provjeriStanjeRacuna() throws FileNotFoundException
	{
		Racun test=new Racun();
		assertTrue(test.checkBalance(22,2));
		assertFalse(test.checkBalance(22,100000000));
	}
	@Test
	public void korisnikLogIN()
	{
		Racun test=new KorisnikLogIN();
		assertTrue(test.checkAccounts(22));
		assertFalse(test.checkAccounts(3));
	}
	@Test
	public void provjeriKorisnikRegisterRacun()
	{
		Racun test=new KorisnikRegister();
		assertTrue(test.checkAccounts(22));
		assertFalse(test.checkAccounts(3));
	}
	@Test
	public void provjeriTransakciju() throws FileNotFoundException
	{
		Racun test=new Transakcija();
		assertTrue(test.checkBalance(22,2));
		assertFalse(test.checkBalance(22,1000000));
	}

}

