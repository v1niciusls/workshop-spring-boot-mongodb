package com.viniciuslacerda.workshopmongo.services;

import com.viniciuslacerda.workshopmongo.domain.Post;
import com.viniciuslacerda.workshopmongo.domain.User;
import com.viniciuslacerda.workshopmongo.dto.UserDTO;
import com.viniciuslacerda.workshopmongo.repository.PostRepository;
import com.viniciuslacerda.workshopmongo.repository.UserRepository;
import com.viniciuslacerda.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> findAll(){
       return userRepository.findAll();
    }


    public User findById(String id){
       Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Usuário nao encontrado"));
    }


    public User insert(User user){
        return userRepository.insert(user);
    }

    public void delete(String id){
        if(!userRepository.existsById(id)){
            throw new ObjectNotFoundException("Nao encontrado");
        }
         userRepository.deleteById(id);
    }

    public User update(User obj){
        User newObj = userRepository.findById(obj.getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        updateObj(newObj,obj);
        return userRepository.save(newObj);
    }

    private void updateObj(User newObj, User obj) {
        newObj.setEmail(obj.getEmail());
        newObj.setName(obj.getName());
    }

    public User fromDTO(UserDTO objDto) {
        return new User(null, objDto.getName(), objDto.getEmail());
    }




}
