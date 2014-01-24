package fr.unice.polytech.si3.tse.ttan;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import fr.unice.polytech.si3.tse.ttan.utils.Constantes;

public class ConstantesTest {
	
	/**
	 * Test si la classe est privée ou non
	 * code récupéré sur : http://stackoverflow.com/questions/4520216/how-to-add-test-coverage-to-a-private-constructor
	 * @throws Exception
	 */
	  @Test
	    public void testConstructeurPrivate() throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException
	    {
	        Class<?>[] classeConstruct = {Constantes.class};
	        for(Class<?> classe : classeConstruct)
	        {
	            Constructor<?> constructor = classe.getDeclaredConstructor();
	            constructor.setAccessible(true);
	            assertNotNull(constructor.newInstance());
	        }
	    }
	
}
