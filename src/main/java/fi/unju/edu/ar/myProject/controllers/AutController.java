package fi.unju.edu.ar.myProject.controllers;

import fi.unju.edu.ar.myProject.dao.UsuarioDao;
import fi.unju.edu.ar.myProject.model.Usuario;
import fi.unju.edu.ar.myProject.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutController {
  @Autowired
  private UsuarioDao usuarioDao;
  @Autowired
  private JWTutil jwt;
  @RequestMapping(value = "api/login", method = RequestMethod.POST)
  public String login(@RequestBody Usuario usuario){
  Usuario userLog = usuarioDao.verifyCredentials(usuario);

  if(userLog!=null){

      String token = jwt.create(String.valueOf(userLog.getId()), userLog.getEmail());
     return token;
   };
   return "Usuario no encontrado";
  }
}
