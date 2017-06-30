package modele.impl.test;

import org.junit.Test;

import exception.model.ModelException;
import modele.impl.Specialite;

public class SpecialiteTest {
	
	@Test(expected = ModelException.class)
	public void testFourCharAlpha() throws ModelException {
		Specialite specialite = new Specialite("Libelle", "000");
		specialite.setCode("AAAA");
	}
	
	@Test(expected = ModelException.class)
	public void testFourCharNum() throws ModelException {
		Specialite specialite = new Specialite("Libelle", "000");
		specialite.setCode("1111");
	}
	
	@Test(expected = ModelException.class)
	public void testThirdCharAlph() throws ModelException {
		Specialite specialite = new Specialite("Libelle", "000");
		specialite.setCode("AAA");
	}
	
	@Test
	public void testThirdCharNum() throws ModelException {
		Specialite specialite = new Specialite("Libelle", "000");
		specialite.setCode("123");
	}
	
	@Test(expected = ModelException.class)
	public void testNullValue() throws ModelException {
		Specialite specialite = new Specialite("Libelle", "000");
		specialite.setCode(null);
	}
	
	@Test(expected = ModelException.class)
	public void testTwoCharAlpha() throws ModelException {
		Specialite specialite = new Specialite("Libelle", "000");
		specialite.setCode("AA");
	}
	
	@Test(expected = ModelException.class)
	public void testTwoCharNum() throws ModelException {
		Specialite specialite = new Specialite("Libelle", "000");
		specialite.setCode("11");
	}
	
	@Test(expected = ModelException.class)
	public void testAlphaAndNumChar() throws ModelException {
		Specialite specialite = new Specialite("Libelle", "000");
		specialite.setCode("11B");
	}
	
	@Test(expected = ModelException.class)
	public void testWithEmptyCharForTree() throws ModelException {
		Specialite specialite = new Specialite("Libelle", "000");
		specialite.setCode("  1");
	}
	
	@Test(expected = ModelException.class)
	public void testWithEmptyBeforeAndAfterChar() throws ModelException {
		Specialite specialite = new Specialite("Libelle", "000");
		specialite.setCode(" 111 ");
	}
	
	@Test(expected = ModelException.class)
	public void testWithEmptyChar() throws ModelException {
		Specialite specialite = new Specialite("Libelle", "000");
		specialite.setCode("   ");
	}
	
	@Test(expected = ModelException.class)
	public void testConstructFourCharAlpha() throws ModelException {
		Specialite specialite = new Specialite("Libelle", "AAAA");
	}
	
	@Test(expected = ModelException.class)
	public void testConstructFourCharNum() throws ModelException {
		Specialite specialite = new Specialite("Libelle", "1111");
	}
	
	@Test(expected = ModelException.class)
	public void testConstructThirdCharAlph() throws ModelException {
		Specialite specialite = new Specialite("Libelle", "AAA");
	}
	
	@Test
	public void testConstructThirdCharNum() throws ModelException {
		Specialite specialite = new Specialite("Libelle", "123");
	}
	
	@Test(expected = ModelException.class)
	public void testConstructNullValue() throws ModelException {
		Specialite specialite = new Specialite("Libelle", null);
	}
	
	@Test(expected = ModelException.class)
	public void testConstructTwoCharAlpha() throws ModelException {
		Specialite specialite = new Specialite("Libelle", "AA");
	}
	
	@Test(expected = ModelException.class)
	public void testConstructTwoCharNum() throws ModelException {
		Specialite specialite = new Specialite("Libelle", "11");
	}
	
	@Test(expected = ModelException.class)
	public void testConstructAlphaAndNumChar() throws ModelException {
		Specialite specialite = new Specialite("Libelle", "11B");
	}
	
	@Test(expected = ModelException.class)
	public void testConstructWithEmptyCharForTree() throws ModelException {
		Specialite specialite = new Specialite("Libelle", "  1");
	}
	
	@Test(expected = ModelException.class)
	public void testConstructWithEmptyBeforeAndAfterChar() throws ModelException {
		Specialite specialite = new Specialite("Libelle", " 111 ");
	}
	
	@Test(expected = ModelException.class)
	public void testConstructWithEmptyChar() throws ModelException {
		Specialite specialite = new Specialite("Libelle", "   ");
	}
}
