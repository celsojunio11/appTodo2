package br.edu.unipam.service;

import br.edu.unipam.entity.Tarefa;
import br.edu.unipam.entity.Usuario;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
/**
 *
 * @author celsojunio11
 * ACID - Atomicidade / Consistência / Isolamento / Durabilidade
 * Se der erro, rollback na transação; senão
 */
@Transactional
public class TarefaService {
    @PersistenceContext(name = "pu_todo")
    private EntityManager entityManager;
    
    @Inject //injeção de dependência
    private UsuarioService usuarioService;
    
    //inserir
    public Tarefa salvar(Tarefa tarefa, Long id) {
        Usuario user = usuarioService.localizarPorId(id);

        if (user != null)
        {
            tarefa.setUsuario(user);
            tarefa.setDataCriacao(new Date());
            entityManager.persist(tarefa);
            return tarefa;
        }
        return tarefa;
        return null;
    }

    //Encontrar usuário por ID
    public Tarefa localizarPorId(Long id) {
        Tarefa tarefaBd = entityManager.find(Tarefa.class, id);
        return tarefaBd;
    }

    //Remover
    public void remover(Long id) {
    public String remover(Long id) {
        Tarefa tarefa  = localizarPorId(id);
        if (tarefa != null) {
            entityManager.remove(tarefa);
            return null;
        }
        return "Erro";
    }

    //Editar
    public Tarefa editar(Tarefa tarefa, Long id) {
        Tarefa tarefaBd = localizarPorId(tarefa.getId());
        if (tarefaBd == null)
        {
            return null;
        }
        Usuario userBd = usuarioService.localizarPorId(id);
        if (userBd == null)
        {
            return null;
        }
        tarefa.setUsuario(userBd);
        tarefa.setDataAlteracao(new Date());
        entityManager.merge(tarefa);
        return tarefa;
    }
    //Listar 
    public List<Tarefa> listar ()
    {
        return entityManager.createQuery("select t from Tarefa t order by t.Descricao", Tarefa.class).getResultList();
    }
    
    //Listar por Usuario
    public List<Tarefa> listarPorUsuario (Long id)
    {
        Usuario user = usuarioService.localizarPorId(id);

        if (user == null)
        {
            return null;
        }
        return entityManager.createQuery(
                "select t from Tarefa t where t.usuario = :user", Tarefa.class)
                .setParameter("user", user)
                .getResultList();
    }
}