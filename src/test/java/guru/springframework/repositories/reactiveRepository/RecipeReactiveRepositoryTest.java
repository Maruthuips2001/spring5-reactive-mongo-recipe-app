package guru.springframework.repositories.reactiveRepository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.domain.Recipe;

@RunWith(SpringRunner.class)
@DataMongoTest
public class RecipeReactiveRepositoryTest {

	@Autowired
	RecipeReactiveRepository recipeReactiveRepository;
	
	@Before
	public void setup() {
		recipeReactiveRepository.deleteAll().block();
	}
	
	@Test
	public void testForSave() {
		Recipe recipe = new Recipe();
		recipe.setDescription("test");
		
		recipeReactiveRepository.save(recipe).block();
		
		assertEquals(Long.valueOf(1L), recipeReactiveRepository.count().block());
	}
}
