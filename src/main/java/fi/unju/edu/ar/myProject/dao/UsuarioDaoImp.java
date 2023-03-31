package fi.unju.edu.ar.myProject.dao;

import fi.unju.edu.ar.myProject.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

  /**
   * Permite realizar la conexion con la bd
   */
  @PersistenceContext
  private EntityManager entityManager;
  @Override
  public List<Usuario> getUsuarios() {
    String query = "FROM Usuario ";
    List<Usuario> result =  entityManager.createQuery(query).getResultList();
    return result;
  }

  @Override
  public void deleleUser(Long id) {
    Usuario usuario = entityManager.find(Usuario.class, id);
    entityManager.remove(usuario);
  }
}
