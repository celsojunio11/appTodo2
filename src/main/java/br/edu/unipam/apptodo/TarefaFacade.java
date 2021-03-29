package br.edu.unipam.apptodo;

import br.edu.unipam.entity.Tarefa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author celsojunio11
 */
@Stateless
public class TarefaFacade extends AbstractFacade<Tarefa> {

    @PersistenceContext(unitName = "pu_todo")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TarefaFacade() {
        super(Tarefa.class);
    }

}