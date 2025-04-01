package com.viniciuslacerda.workshopmongo.config;

import com.viniciuslacerda.workshopmongo.domain.Post;
import com.viniciuslacerda.workshopmongo.domain.User;
import com.viniciuslacerda.workshopmongo.dto.AuthorDTO;
import com.viniciuslacerda.workshopmongo.repository.PostRepository;
import com.viniciuslacerda.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User("1", "maria", "maria@gmail.com");
        User jorge = new User("2", "jorge", "jorge@gmail.com");
        User pedro = new User("3", "pedro", "pedro@gmail.com");

        userRepository.saveAll(Arrays.asList(pedro,jorge,maria));

        Post post1 = new Post(null,sdf.parse("21/03/2018"),"Partiu viagem","vou viajar para sao paulo abraços!",new AuthorDTO(maria));
        Post post2 = new Post(null,sdf.parse("23/03/2018"),"Bom dia","Acordei feliz hoje!",new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(maria);


    }
}



