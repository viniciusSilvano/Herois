package com.stefanini.heroi;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stefanini.heroi.bo.partida.DueloFactory;
import com.stefanini.heroi.bo.partida.IDuelo;
import com.stefanini.heroi.config.BeanConfig;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BeanConfig.class})
public class DueloTeste extends TestCase {
	DueloFactory dueloFactory = DueloFactory.getInstance();
	
	
	@Test
	public void noSingletonTest() {
		IDuelo duelo1 = null;
		IDuelo duelo2 = null;
		try {
			duelo1 = dueloFactory.getObject();
			duelo2 = dueloFactory.getObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(duelo1 != null && duelo2 != null) {
			assertEquals(false, duelo1.equals(duelo2));	
		}
	}

}
