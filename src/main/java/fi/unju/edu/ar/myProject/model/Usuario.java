package fi.unju.edu.ar.myProject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
  @Column(name ="id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="name")
  private String nombre;
  @Column(name="lastname")
  private String apellido;
  @Column(name="email")
  private String email;

  @Column(name="phone", nullable = true)
  private String telefono;
  @Column(name="password")
  private String password;

  public Usuario () {};
  public Usuario( String nombre, String apellido, String email, String telefono, String password) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.telefono = telefono;
    this.password = password;
  }
  public Usuario(Long id, String nombre, String apellido, String email, String telefono, String password) {
    this.id= id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.telefono = telefono;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
