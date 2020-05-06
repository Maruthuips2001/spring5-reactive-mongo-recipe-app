package guru.springframework.repositories.reactiveRepository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.domain.Category;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CatogeryReactiveRespoitoryTest {

	@Autowired
	CategoryReactiveRepository categoryReactiveRepository;
	
	@Before
	public void setup() {
		categoryReactiveRepository.deleteAll().block();
	}
	
	@Test
	public void testForSave() {
		Category category = new Category();
		category.setDescription("testomg");
		
		categoryReactiveRepository.save(category).block();
		
		assertEquals(Long.valueOf(1L), categoryReactiveRepository.count().block());
		
	}
}
