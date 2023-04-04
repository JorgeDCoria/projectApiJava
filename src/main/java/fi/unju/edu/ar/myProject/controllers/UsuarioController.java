package fi.unju.edu.ar.myProject.controllers;

import fi.unju.edu.ar.myProject.dao.UsuarioDao;
import fi.unju.edu.ar.myProject.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;
    @RequestMapping(value = "api/usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario newUser = new Usuario(id ,"jorge", "Coria", "coriajorge.dev.apu@gmail.com","3884611503", "coria");
        return newUser;
    }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> updateUsuarios(){
       return usuarioDao.getUsuarios();
    }
   @RequestMapping(value="api/usuario/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
        usuarioDao.deleleUser(id);
    }

    @RequestMapping(value="api/usuario", method = RequestMethod.POST)
    public void adduser(@RequestBody Usuario usuario){
      usuarioDao.adduser(usuario);
    }
}
