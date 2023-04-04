package fi.unju.edu.ar.myProject.controllers;

import fi.unju.edu.ar.myProject.dao.UsuarioDao;
import fi.unju.edu.ar.myProject.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutController {
  @Autowired
  private UsuarioDao usuarioDao;
  @RequestMapping(value = "api/login", method = RequestMethod.POST)
  public String login(@RequestBody Usuario usuario){
   if(usuarioDao.verifyCredentials(usuario)){
     return "usuario encontrado";
   };
   return "Usuario no encontrado";
  }
}
