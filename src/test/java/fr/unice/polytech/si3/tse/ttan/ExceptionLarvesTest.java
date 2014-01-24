/**
 * 
 */
package fr.unice.polytech.si3.tse.ttan;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.unice.polytech.si3.tse.ttan.plateauIndividuel.ExceptionLarves;

/**
 * @author alavail
 *
 */
public class ExceptionLarvesTest {

	/**
	 * Test method for {@link fr.unice.polytech.si3.tse.ttan.plateauIndividuel.ExceptionLarves#ExceptionLarves()}.
	 */
	@Test
	public void testExceptionLarves() {
		ExceptionLarves el = new ExceptionLarves();
		assertEquals(el.getClass().getName(), ExceptionLarves.class.getName());
	}

	/**
	 * Test method for {@link fr.unice.polytech.si3.tse.ttan.plateauIndividuel.ExceptionLarves#ExceptionLarves(java.lang.String)}.
	 */
	@Test
	public void testExceptionLarvesString() {
		ExceptionLarves el = new ExceptionLarves("Test Message");
		assertEquals(el.getMessage(), "Test Message");
	}

}
