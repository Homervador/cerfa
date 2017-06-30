package modele.impl.test;

import java.time.LocalDate;
import org.junit.Test;

import exception.model.ModelException;
import modele.impl.FinancementStagiaire;
import modele.proxy.ProxyFinancement;
import modele.proxy.ProxyStagiaire;

public class FiancementStagiaireTest {

	@Test
	public void testDebutInfFin() throws ModelException {
		LocalDate dateDebut = LocalDate.of(2017, 01, 01);
		LocalDate dateFin = LocalDate.of(2018,01,01);
		FinancementStagiaire fs = new FinancementStagiaire(new ProxyStagiaire(1), new ProxyFinancement(1), dateDebut, dateFin);
		fs.setDateDebut(LocalDate.of(2017,01,01));
		fs.setDateFin(LocalDate.of(2018,01,01));
	}
	
	@Test 
	public void testDebutEgaleFin() throws ModelException {
		LocalDate dateDebut = LocalDate.of(2017, 01, 01);
		LocalDate dateFin = LocalDate.of(2018,01,01);
		FinancementStagiaire fs = new FinancementStagiaire(new ProxyStagiaire(1), new ProxyFinancement(1), dateDebut, dateFin);
		fs.setDateDebut(LocalDate.of(2017,01,01));
		fs.setDateFin(LocalDate.of(2017,01,01));
	}
	
	@Test (expected = ModelException.class)
	public void testDebutSuppFin() throws ModelException {
		LocalDate dateDebut = LocalDate.of(2017, 01, 01);
		LocalDate dateFin = LocalDate.of(2018,01,01);
		FinancementStagiaire fs = new FinancementStagiaire(new ProxyStagiaire(1), new ProxyFinancement(1), dateDebut, dateFin);
		fs.setDateDebut(LocalDate.of(2019,01,01));
		fs.setDateFin(LocalDate.of(2018,01,01));
	}
	
	@Test
	public void testConstrucDebutInfFin() throws ModelException {
		FinancementStagiaire financementStagiaire = new FinancementStagiaire(new ProxyStagiaire(1), new ProxyFinancement(1), LocalDate.of(2017, 01, 01), LocalDate.of(2018,01,01));
	}
	
	@Test
	public void testConstructDebutEgaleFin() throws ModelException {
		FinancementStagiaire financementStagiaire = new FinancementStagiaire(new ProxyStagiaire(1), new ProxyFinancement(1), LocalDate.of(2017, 01, 01), LocalDate.of(2017,01,01));
	}
	
	@Test (expected = ModelException.class)
	public void testConstructDebutSuppFin() throws ModelException {
		FinancementStagiaire financementStagiaire = new FinancementStagiaire(new ProxyStagiaire(1), new ProxyFinancement(1), LocalDate.of(2019, 01, 01), LocalDate.of(2018,01,01));
	}

}
