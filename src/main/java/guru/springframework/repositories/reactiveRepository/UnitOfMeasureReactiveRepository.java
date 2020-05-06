package guru.springframework.repositories.reactiveRepository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import guru.springframework.domain.UnitOfMeasure;

public interface UnitOfMeasureReactiveRepository extends ReactiveMongoRepository<UnitOfMeasure, String>{

	
}
