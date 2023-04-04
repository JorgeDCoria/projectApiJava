package fi.unju.edu.ar.myProject.dao;

import fi.unju.edu.ar.myProject.model.Usuario;

import java.util.List;

public interface UsuarioDao {
  List<Usuario> getUsuarios();

  void deleleUser(Long id);

  void adduser(Usuario usuario);

  Usuario verifyCredentials(Usuario usuario);
}
