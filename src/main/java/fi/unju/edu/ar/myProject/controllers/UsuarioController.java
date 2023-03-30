package fi.unju.edu.ar.myProject.controllers;

import fi.unju.edu.ar.myProject.dao.UsuarioDao;
import fi.unju.edu.ar.myProject.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    /*
    @RequestMapping(value = "usuario")
    public Usuario deleteUsuario(){
        Usuario newUser = new Usuario("jorge", "Coria", "coriajorge.dev.apu@gmail.com","3884611503", "coria");
        return newUser;
    }
    @RequestMapping(value = "usuario")
    public Usuario findUsuario(){
        Usuario newUser = new Usuario("jorge", "Coria", "coriajorge.dev.apu@gmail.com","3884611503", "coria");
        return newUser;
    } */
}
