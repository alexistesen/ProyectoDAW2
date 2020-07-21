package com.cibertec;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cibertec.model.Pais;
import com.cibertec.service.IPaisService;

@SpringBootTest
public class PaisTest {

	@Autowired
	private IPaisService paisService;
	
	@Test
	void crearPaisTest() {
		Pais p1 = new Pais();
		p1.setNombre("Peru");
				
		Pais p2 = new Pais();
		p2.setNombre("Brasil");
		
		Pais p3 = new Pais();
		p3.setNombre("Argentina");
		
		Pais resp1 = paisService.save(p1);
		Pais resp2 = paisService.save(p2);
		Pais resp3 = paisService.save(p3);
		
		assertTrue( (resp1.getNombre().equalsIgnoreCase(p1.getNombre())) &&
				(resp2.getNombre().equalsIgnoreCase(p2.getNombre())) &&
				(resp3.getNombre().equalsIgnoreCase(p3.getNombre())) );
	
	}
	
}
