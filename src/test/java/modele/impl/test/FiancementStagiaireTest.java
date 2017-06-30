package modele.impl.test;

import java.time.LocalDate;
import org.junit.Test;

import exception.model.ModelException;
import modele.impl.Financement;
import modele.impl.FinancementStagiaire;
import modele.impl.Stagiaire;

public class FiancementStagiaireTest {

	@Test
	public void testDebutInfFin() throws ModelException {
		LocalDate dateDebut = LocalDate.of(2017, 01, 01);
		LocalDate dateFin = LocalDate.of(2018,01,01);
		Stagiaire stagiaire = new Stagiaire(1, "Cousteau", "Jean-Jacques", false);
		Financement financement = new Financement(1, "Paiement perso");
		FinancementStagiaire finansementStagiaire = new FinancementStagiaire(stagiaire, financement, LocalDate.of(2016,01,01), LocalDate.of(2016,06,01));
		FinancementStagiaire fs = new FinancementStagiaire(stagiaire, financement, dateDebut, dateFin);
		fs.setDateDebut(LocalDate.of(2017,01,01));
		fs.setDateFin(LocalDate.of(2018,01,01));
	}
	
	@Test 
	public void testDebutEgaleFin() throws ModelException {
		LocalDate dateDebut = LocalDate.of(2017, 01, 01);
		LocalDate dateFin = LocalDate.of(2018,01,01);
		Stagiaire stagiaire = new Stagiaire(1, "Cousteau", "Jean-Jacques", false);
		Financement financement = new Financement(1, "Paiement perso");
		FinancementStagiaire finansementStagiaire = new FinancementStagiaire(stagiaire, financement, LocalDate.of(2016,01,01), LocalDate.of(2016,06,01));
		stagiaire.getListFinancementsStagiaires().add(finansementStagiaire);
		FinancementStagiaire fs = new FinancementStagiaire(stagiaire, financement, dateDebut, dateFin);
		fs.setDateDebut(LocalDate.of(2017,01,01));
		fs.setDateFin(LocalDate.of(2017,01,01));
	}
	
	@Test (expected = ModelException.class)
	public void testDebutSuppFin() throws ModelException {
		LocalDate dateDebut = LocalDate.of(2017, 01, 01);
		LocalDate dateFin = LocalDate.of(2018,01,01);
		Stagiaire stagiaire = new Stagiaire(1, "Cousteau", "Jean-Jacques", false);
		Financement financement = new Financement(1, "Paiement perso");
		FinancementStagiaire finansementStagiaire = new FinancementStagiaire(stagiaire, financement, LocalDate.of(2016,01,01), LocalDate.of(2016,06,01));
		stagiaire.getListFinancementsStagiaires().add(finansementStagiaire);
		FinancementStagiaire fs = new FinancementStagiaire(stagiaire, financement, dateDebut, dateFin);
		fs.setDateDebut(LocalDate.of(2019,01,01));
		fs.setDateFin(LocalDate.of(2018,01,01));
	}
	
	@Test (expected = ModelException.class)
	public void testDebutDansIntervalExist() throws ModelException {
		LocalDate dateDebut = LocalDate.of(2017, 01, 01);
		LocalDate dateFin = LocalDate.of(2018,01,01);
		Stagiaire stagiaire = new Stagiaire(1, "Cousteau", "Jean-Jacques", false);
		Financement financement = new Financement(1, "Paiement perso");
		FinancementStagiaire finansementStagiaire = new FinancementStagiaire(stagiaire, financement, LocalDate.of(2016,01,01), LocalDate.of(2017,06,01));
		stagiaire.getListFinancementsStagiaires().add(finansementStagiaire);
		FinancementStagiaire fs = new FinancementStagiaire(stagiaire, financement, dateDebut, dateFin);
		fs.setDateDebut(LocalDate.of(2017,01,01));
		fs.setDateFin(LocalDate.of(2018,01,01));
	}
	@Test (expected = ModelException.class)
	public void testFinDansIntervalExist() throws ModelException {
		LocalDate dateDebut = LocalDate.of(2017, 01, 01);
		LocalDate dateFin = LocalDate.of(2018,01,01);
		Stagiaire stagiaire = new Stagiaire(1, "Cousteau", "Jean-Jacques", false);
		Financement financement = new Financement(1, "Paiement perso");
		stagiaire.getListFinancementsStagiaires().add(new FinancementStagiaire(stagiaire, financement, LocalDate.of(2017,06,01), LocalDate.of(2018,06,01)));		
		FinancementStagiaire fs = new FinancementStagiaire(stagiaire, financement, dateDebut, dateFin);
		fs.setDateDebut(LocalDate.of(2017,01,01));
		fs.setDateFin(LocalDate.of(2018,01,01));
	}
	
	@Test (expected = ModelException.class)
	public void testDebutEgalDateFinIntervalExist() throws ModelException {
		LocalDate dateDebut = LocalDate.of(2017, 01, 01);
		LocalDate dateFin = LocalDate.of(2018,01,01);
		Stagiaire stagiaire = new Stagiaire(1, "Cousteau", "Jean-Jacques", false);
		Financement financement = new Financement(1, "Paiement perso");
		FinancementStagiaire finansementStagiaire = new FinancementStagiaire(stagiaire, financement, LocalDate.of(2016,06,01), LocalDate.of(2017,01,01));
		stagiaire.getListFinancementsStagiaires().add(finansementStagiaire);
		FinancementStagiaire fs = new FinancementStagiaire(stagiaire, financement, dateDebut, dateFin);
		fs.setDateDebut(LocalDate.of(2017,01,01));
		fs.setDateFin(LocalDate.of(2018,01,01));
	}
	
	@Test (expected = ModelException.class)
	public void testDebutEgalDateDebutIntervalExist() throws ModelException {
		LocalDate dateDebut = LocalDate.of(2017, 01, 01);
		LocalDate dateFin = LocalDate.of(2018,01,01);
		Stagiaire stagiaire = new Stagiaire(1, "Cousteau", "Jean-Jacques", false);
		Financement financement = new Financement(1, "Paiement perso");
		FinancementStagiaire finansementStagiaire = new FinancementStagiaire(stagiaire, financement, LocalDate.of(2017,01,01), LocalDate.of(2017,01,01));
		stagiaire.getListFinancementsStagiaires().add(finansementStagiaire);
		FinancementStagiaire fs = new FinancementStagiaire(stagiaire, financement, dateDebut, dateFin);
		fs.setDateDebut(LocalDate.of(2017,01,01));
		fs.setDateFin(LocalDate.of(2018,01,01));
	}
	
	@Test (expected = ModelException.class)
	public void testFinEgalDateFinIntervalExist() throws ModelException {
		LocalDate dateDebut = LocalDate.of(2017, 01, 01);
		LocalDate dateFin = LocalDate.of(2018,01,01);
		Stagiaire stagiaire = new Stagiaire(1, "Cousteau", "Jean-Jacques", false);
		Financement financement = new Financement(1, "Paiement perso");
		FinancementStagiaire finansementStagiaire = new FinancementStagiaire(stagiaire, financement, LocalDate.of(2017,06,01), LocalDate.of(2018,01,01));
		stagiaire.getListFinancementsStagiaires().add(finansementStagiaire);
		FinancementStagiaire fs = new FinancementStagiaire(stagiaire, financement, dateDebut, dateFin);
		fs.setDateDebut(LocalDate.of(2017,01,01));
		fs.setDateFin(LocalDate.of(2018,01,01));
	}
	
	@Test (expected = ModelException.class)
	public void testFinEgalDateDebutIntervalExist() throws ModelException {
		LocalDate dateDebut = LocalDate.of(2017, 01, 01);
		LocalDate dateFin = LocalDate.of(2018,01,01);
		Stagiaire stagiaire = new Stagiaire(1, "Cousteau", "Jean-Jacques", false);
		Financement financement = new Financement(1, "Paiement perso");
		FinancementStagiaire finansementStagiaire = new FinancementStagiaire(stagiaire, financement, LocalDate.of(2018,01,01), LocalDate.of(2019,01,01));
		stagiaire.getListFinancementsStagiaires().add(finansementStagiaire);
		FinancementStagiaire fs = new FinancementStagiaire(stagiaire, financement, dateDebut, dateFin);
		fs.setDateDebut(LocalDate.of(2017,01,01));
		fs.setDateFin(LocalDate.of(2018,01,01));
	}
	
	@Test
	public void testConstrucDebutInfFin() throws ModelException {
		LocalDate dateFin = LocalDate.of(2018,01,01);
		Stagiaire stagiaire = new Stagiaire(1, "Cousteau", "Jean-Jacques", false);
		Financement financement = new Financement(1, "Paiement perso");
		FinancementStagiaire finansementStagiaire = new FinancementStagiaire(stagiaire, financement, LocalDate.of(2016,01,01), LocalDate.of(2016,06,01));
		FinancementStagiaire financementStagiaire = new FinancementStagiaire(stagiaire, financement, LocalDate.of(2017, 01, 01), LocalDate.of(2018,01,01));
	}
	
	@Test
	public void testConstructDebutEgaleFin() throws ModelException {
		LocalDate dateFin = LocalDate.of(2018,01,01);
		Stagiaire stagiaire = new Stagiaire(1, "Cousteau", "Jean-Jacques", false);
		Financement financement = new Financement(1, "Paiement perso");
		FinancementStagiaire finansementStagiaire = new FinancementStagiaire(stagiaire, financement, LocalDate.of(2016,01,01), LocalDate.of(2016,06,01));
		FinancementStagiaire financementStagiaire = new FinancementStagiaire(stagiaire, financement, LocalDate.of(2017, 01, 01), LocalDate.of(2017,01,01));
	}
	
	@Test (expected = ModelException.class)
	public void testConstructDebutSuppFin() throws ModelException {
		LocalDate dateFin = LocalDate.of(2018,01,01);
		Stagiaire stagiaire = new Stagiaire(1, "Cousteau", "Jean-Jacques", false);
		Financement financement = new Financement(1, "Paiement perso");
		FinancementStagiaire finansementStagiaire = new FinancementStagiaire(stagiaire, financement, LocalDate.of(2016,01,01), LocalDate.of(2016,06,01));
		FinancementStagiaire financementStagiaire = new FinancementStagiaire(stagiaire, financement, LocalDate.of(2019, 01, 01), LocalDate.of(2018,01,01));
	}
	
	@Test (expected = ModelException.class)
	public void testConstrucDebutDansIntervalExist() throws ModelException {
		
		LocalDate dateFin = LocalDate.of(2018,01,01);
		Stagiaire stagiaire = new Stagiaire(1, "Cousteau", "Jean-Jacques", false);
		Financement financement = new Financement(1, "Paiement perso");
		FinancementStagiaire finansementStagiaire = new FinancementStagiaire(stagiaire, financement, LocalDate.of(2016,01,01), LocalDate.of(2016,06,01));
		FinancementStagiaire financementStagiaire = new FinancementStagiaire(stagiaire, financement, LocalDate.of(2017, 01, 01), LocalDate.of(2018,01,01));
	}
	
	

}
