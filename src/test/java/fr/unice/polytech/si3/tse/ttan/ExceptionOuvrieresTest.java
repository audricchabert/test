/**
 * 
 */
package fr.unice.polytech.si3.tse.ttan;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.ExceptionOuvrieres;

/**
 * @author alavail
 *
 */
public class ExceptionOuvrieresTest {

	/**
	 * Test method for {@link fr.unice.polytech.si3.tse.ttan.plateauIndividuel.ExceptionOuvrieres#ExceptionOuvrieres()}.
	 */
	@Test
	public void testExceptionOuvrieres() {
		ExceptionOuvrieres eo = new ExceptionOuvrieres();
		assertEquals(eo.getClass().getName(), ExceptionOuvrieres.class.getName());
	}

	/**
	 * Test method for {@link fr.unice.polytech.si3.tse.ttan.plateauIndividuel.ExceptionOuvrieres#ExceptionOuvrieres(java.lang.String)}.
	 */
	@Test
	public void testExceptionOuvrieresString() {
		ExceptionOuvrieres eo = new ExceptionOuvrieres("Test Message");
		assertEquals(eo.getMessage(), "Test Message");
	}

}
