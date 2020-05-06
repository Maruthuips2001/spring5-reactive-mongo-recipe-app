package guru.springframework.repositories.reactiveRepository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import guru.springframework.domain.Recipe;

public interface RecipeReactiveRepository extends ReactiveMongoRepository<Recipe, String>{

}
