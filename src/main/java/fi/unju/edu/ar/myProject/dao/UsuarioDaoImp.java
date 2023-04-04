package fi.unju.edu.ar.myProject.dao;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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

  @Override
  public void adduser(Usuario usuario) {
    Argon2 argon = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
    String hash = argon.hash(1, 1024,1, usuario.getPassword());
    usuario.setPassword(hash);
    entityManager.merge(usuario);
  }

  @Override
  public Usuario verifyCredentials(Usuario usuario) {
    String query = "FROM Usuario WHERE  email = :email";
    List<Usuario> usuarios =  entityManager.createQuery(query)
            .setParameter("email", usuario.getEmail())
            .getResultList();
    if(usuarios.isEmpty()) return null;
    Argon2 argon = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
    if(argon.verify(usuarios.get(0).getPassword(), usuario.getPassword())) return usuarios.get(0);
    return null;


  }

}
