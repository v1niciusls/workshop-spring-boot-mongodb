package com.viniciuslacerda.workshopmongo.resources;

import com.viniciuslacerda.workshopmongo.domain.User;
import com.viniciuslacerda.workshopmongo.dto.UserDTO;
import com.viniciuslacerda.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = userService.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody User user){
          User newuser = userService.insert(user);
          return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(newuser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> delete(@PathVariable String id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
