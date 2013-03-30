/**
 * 
 */
package fr.unice.polytech.si3.tse.ttan;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.ExceptionNourrices;

/**
 * @author alavail
 *
 */
public class ExceptionNourricesTest {

	/**
	 * Test method for {@link fr.unice.polytech.si3.tse.ttan.plateauIndividuel.ExceptionNourrices#ExceptionNourrices()}.
	 */
	@Test
	public void testExceptionNourrices() {
		ExceptionNourrices en = new ExceptionNourrices();
		assertEquals(en.getClass().getName(), ExceptionNourrices.class.getName());
	}

	/**
	 * Test method for {@link fr.unice.polytech.si3.tse.ttan.plateauIndividuel.ExceptionNourrices#ExceptionNourrices(java.lang.String)}.
	 */
	@Test
	public void testExceptionNourricesString() {
		ExceptionNourrices en = new ExceptionNourrices("Test Message");
		assertEquals(en.getMessage(), "Test Message");
	}

}
