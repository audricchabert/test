/**
 * 
 */
package fr.unice.polytech.si3.tse.ttan;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.unice.polytech.si3.tse.ttan.fourmis.Fourmi;
import fr.unice.polytech.si3.tse.ttan.fourmis.Nourrice;
import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.Salle;
import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.SalleNourrice;

/**
 * @author user
 *
 */
public class SalleTest {

	/**
	 * Test method for {@link fr.unice.polytech.si3.tse.ttan.plateauIndividuel.Salle#setNbCourantFourmi(java.util.List)}.
	 */
	@Test
	public void testSetNbCourantFourmi() {
		Salle e = new SalleNourrice();
		List<Fourmi> list = new ArrayList<Fourmi>();
		list.add(new Nourrice());
		e.setNbCourantFourmi(list);
		assertEquals(e.getListeFourmis().size(), list.size());
	}

}
