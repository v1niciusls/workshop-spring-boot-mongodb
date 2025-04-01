package com.viniciuslacerda.workshopmongo.services;

import com.viniciuslacerda.workshopmongo.domain.Post;
import com.viniciuslacerda.workshopmongo.repository.PostRepository;
import com.viniciuslacerda.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("post nao encontrado"));
    }


}
