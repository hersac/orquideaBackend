package com.hersac.orquidea.Services;

import java.io.IOException;
import java.util.List;

import com.hersac.orquidea.Models.User;
import com.hersac.orquidea.Repositories.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService  {
    
    @Autowired
    UserRepository userRepository;

    //Get
    public List<User> userList(){
        return userRepository.findAll();
    }

    public User userFindById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    //Post
    public User userAdd(User info){
        return userRepository.save(info);
    }

    public User userValidation(User infoUsuario, final HttpServletResponse response) throws IOException {

        User usuarioActual = userRepository.findByEmailUser(infoUsuario.getUserEmail());

        if(usuarioActual!=null && usuarioActual.getUserPasswd().equals(infoUsuario.getUserPasswd())) {
            usuarioActual.setUserPasswd("");
            return usuarioActual;
        } else{
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        } 
    }

    //Put
    public User userUpdate(Long id, User info){
        User newUser = userRepository.findById(id).orElse(null);

        newUser.setUserName(info.getUserName());
        newUser.setUserLastName(info.getUserLastName());
        newUser.setUserBirthday(info.getUserBirthday());
        newUser.setUserEmail(info.getUserEmail());
        newUser.setUserPasswd(info.getUserPasswd());
        newUser.setUserTel(info.getUserTel());
        newUser.setUserCountry(info.getUserCountry());
        newUser.setUserState(info.getUserState());
        newUser.setUserCity(info.getUserCity());
        newUser.setUserImageProfile(info.getUserImageProfile());

        User userUpdate = userRepository.save(newUser);
        return userUpdate;
    }

    //Delete
    public ResponseEntity<?> userDelete(Long id){
        User user = userRepository.findById(id).orElse(null);
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> deleteAll(){
        userRepository.deleteAll();
        return ResponseEntity.ok().build();
    }

}


