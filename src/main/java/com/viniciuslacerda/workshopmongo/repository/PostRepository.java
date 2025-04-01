package com.viniciuslacerda.workshopmongo.repository;

import com.viniciuslacerda.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String> {

}
