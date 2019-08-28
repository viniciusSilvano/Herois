package com.stefanini.heroi;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stefanini.heroi.bo.partida.Duelo;
import com.stefanini.heroi.config.FactoryBeanConfig;
import com.stefanini.heroi.model.DueloFactory;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FactoryBeanConfig.class})
public class DueloTeste extends TestCase {
	DueloFactory dueloFactory = DueloFactory.getInstance();
	
	
	@Test
	public void noSingletonTest() {
		Duelo duelo1 = null;
		Duelo duelo2 = null;
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
