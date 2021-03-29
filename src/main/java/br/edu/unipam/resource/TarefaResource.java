package br.edu.unipam.resource;
import br.edu.unipam.entity.Tarefa;
import br.edu.unipam.service.UsuarioService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author celsojunio11
 */
@Path("tarefa") 

@Path("tarefa") 
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TarefaResource {
    

    @Inject
    private TarefaService tarefaService;
    

    @GET
    @Path("list") 
    //ListarTodos
    public List<Tarefa> listar ()
    {
          return entityManager.createQuery("select t from Tarefa t order by t.Descricao", Tarefa.class).getResultList();
    }

    
    @Path("list") /
    //ListarPorUsuario
    public List<Tarefa> listarPorUsuario (Long id)
    {
        Usuario user = usuarioService.localizarPorId(id);
        return entityManager.createQuery(
                "select t from Tarefa t where t.usuario = :user", Tarefa.class)
                .setParameter("user", user)
                .getResultList();
    }

   



}