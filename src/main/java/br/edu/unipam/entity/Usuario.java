package br.edu.unipam.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
/**
 *
 * @author celsojunio11
 */
@Entity
@NamedQuery(name =  Usuario.GET_ALL_USERS, query = "select u from Usuario u order by u.nome")
public class Usuario extends AbstractEntity {
public class Usuario extends AbstractEntity implements Serializable {

    public static final String GET_ALL_USERS = "Usuario.getAllUsers";

    private String nome;

    @NotEmpty
    @NotNull
    @Pattern(regexp = "/^[a-z0-9.]+@[a-z0-9]+\\.[a-z]+\\.([a-z]+)?$/i")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @Column(nullable = false)
    private String email;

    @OneToMany
        //(mappedBy = "usuario")
    private Collection<Tarefa> tarefas = new ArrayList<>();

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String Email) {
        this.email = Email;
    }
   
    
}