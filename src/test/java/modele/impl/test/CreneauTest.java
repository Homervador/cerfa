package modele.impl.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Test;

import exception.model.ModelException;
import modele.impl.Creneau;
import modele.proxy.ProxyFormation;

public class CreneauTest {
	
	@Test
	public void testDebutInfFinDureeOk() throws ModelException {
		LocalDateTime dateDebut = LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(10,0,0,0));
		LocalDateTime dateFin = LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(13,30,0,0));
		Creneau creneau = new Creneau(dateDebut, dateFin, true, new ProxyFormation(1));
		creneau.setDateDebut(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(10,0,0,0)));
		creneau.setDateFin(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(13,30,0,0)));
	}
	
	@Test(expected = ModelException.class)
	public void testDebutInfFinDureeSup() throws ModelException {
		Creneau creneau = new Creneau(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(10,0,0,0)), LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(13,30,0,0)), true, new ProxyFormation(1));
		creneau.setDateDebut(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(10,0,0,0)));
		creneau.setDateFin(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(14,30,0,0)));
	}
	
	@Test(expected = ModelException.class)
	public void testDebutInfFinDureeInf() throws ModelException {
		Creneau creneau = new Creneau(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(10,0,0,0)), LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(13,30,0,0)), true, new ProxyFormation(1));
		creneau.setDateDebut(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(10,0,0,0)));
		creneau.setDateFin(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(11,30,0,0)));
	}
	
	@Test(expected = ModelException.class)
	public void testDebutSuppFinDureeOk() throws ModelException {
		Creneau creneau = new Creneau(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(10,0,0,0)), LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(13,30,0,0)), true, new ProxyFormation(1));
		creneau.setDateDebut(LocalDateTime.of(LocalDate.of(2017,01,02), LocalTime.of(10,0,0,0)));
		creneau.setDateFin(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(13,30,0,0)));
	}
	
	@Test(expected = ModelException.class)
	public void testDebutEqualFin() throws ModelException {
		Creneau creneau = new Creneau(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(10,0,0,0)), LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(13,30,0,0)), true, new ProxyFormation(1));
		creneau.setDateDebut(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(23,0,0,0)));
		creneau.setDateFin(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(23,0,0,0)));
	}
	
	@Test(expected = ModelException.class)
	public void testDebutnullFinOk() throws ModelException {
		Creneau creneau = new Creneau(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(10,0,0,0)), LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(13,30,0,0)), true, new ProxyFormation(1));
		creneau.setDateDebut(null);
		creneau.setDateFin(LocalDateTime.of(LocalDate.of(2017,01,02), LocalTime.of(2,30,0,0)));
	}
	
	@Test(expected = ModelException.class)
	public void testDebutOkFinNull() throws ModelException {
		Creneau creneau = new Creneau(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(10,0,0,0)), LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(13,30,0,0)), true, new ProxyFormation(1));
		creneau.setDateDebut(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(23,0,0,0)));
		creneau.setDateFin(null);
	}
	
	@Test(expected = ModelException.class)
	public void testChangeJour() throws ModelException {
		Creneau creneau = new Creneau(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(10,0,0,0)), LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(13,30,0,0)), true, new ProxyFormation(1));
		creneau.setDateDebut(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(23,0,0,0)));
		creneau.setDateFin(LocalDateTime.of(LocalDate.of(2017,01,02), LocalTime.of(2,30,0,0)));
	}
	
	@Test
	public void testConstructDebutInfFinDureeOk() throws ModelException {
		Creneau creneau = new Creneau(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(10,0,0,0)), LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(13,30,0,0)), true, new ProxyFormation(1));
	}
	
	@Test(expected = ModelException.class)
	public void testConstructDebutInfFinDureeSup() throws ModelException {
		Creneau creneau = new Creneau(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(10,0,0,0)), LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(14,30,0,0)), true, new ProxyFormation(1));
	}
	
	@Test(expected = ModelException.class)
	public void testConstructDebutInfFinDureeInf() throws ModelException {
		Creneau creneau = new Creneau(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(10,0,0,0)), LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(12,30,0,0)), true, new ProxyFormation(1));
	}
	
	@Test(expected = ModelException.class)
	public void testConstructDebutSuppFinDureeOk() throws ModelException {
		Creneau creneau = new Creneau(LocalDateTime.of(LocalDate.of(2017,02,01), LocalTime.of(10,0,0,0)), LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(13,30,0,0)), true, new ProxyFormation(1));
	}
	
	@Test(expected = ModelException.class)
	public void testConstructDebutEqualFin() throws ModelException {
		Creneau creneau = new Creneau(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(10,0,0,0)), LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(10,0,0,0)), true, new ProxyFormation(1));
	}
	
	@Test(expected = ModelException.class)
	public void testConstructDebutnullFinOk() throws ModelException {
		Creneau creneau = new Creneau(null, LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(13,30,0,0)), true, new ProxyFormation(1));
	}
	
	@Test(expected = ModelException.class)
	public void testConstructDebutOkFinNull() throws ModelException {
		Creneau creneau = new Creneau(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(10,0,0,0)), null, true, new ProxyFormation(1));
	}
	
	@Test
	public void testConstructChangeJour() throws ModelException {
		Creneau creneau = new Creneau(LocalDateTime.of(LocalDate.of(2017,01,01), LocalTime.of(23,0,0,0)), LocalDateTime.of(LocalDate.of(2017,01,02), LocalTime.of(2,30,0,0)), true, new ProxyFormation(1));
	}
}
