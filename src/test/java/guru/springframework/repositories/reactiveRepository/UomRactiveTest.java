package guru.springframework.repositories.reactiveRepository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.domain.UnitOfMeasure;

@RunWith(SpringRunner.class)
@DataMongoTest
public class UomRactiveTest {

	@Autowired
	UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository;
	
	@Before
	public void setup() {
		unitOfMeasureReactiveRepository.deleteAll().block();
	}
	
	@Test
	public void testUomSave() {
		UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
		unitOfMeasure.setDescription("testing");
		
		unitOfMeasureReactiveRepository.save(unitOfMeasure).block();
		
		Long count = unitOfMeasureReactiveRepository.count().block();
		
		assertEquals(Long.valueOf(1L), count);
		
		
	}
}
