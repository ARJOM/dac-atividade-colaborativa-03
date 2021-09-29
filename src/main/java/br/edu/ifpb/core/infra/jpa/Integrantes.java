package br.edu.ifpb.core.infra.jpa;

import br.edu.ifpb.core.domain.Integrante;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class Integrantes {

    @PersistenceContext
    private EntityManager manager;

    public Integrante salvar(Integrante integrante) {
        manager.persist(integrante);
        return integrante;
    }

    public List<Integrante> todos(){
        return manager.createQuery("FROM Integrante i", Integrante.class).getResultList();
    }
}
