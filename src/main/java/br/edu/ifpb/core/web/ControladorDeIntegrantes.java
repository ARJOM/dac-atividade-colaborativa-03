package br.edu.ifpb.core.web;

import br.edu.ifpb.core.domain.Integrante;
import br.edu.ifpb.core.infra.jpa.Integrantes;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ControladorDeIntegrantes {

    @Inject
    private Integrantes integrantes;

    private Integrante integrante = new Integrante();

    public String salvar(){
        integrantes.salvar(this.integrante);
        this.integrante = new Integrante();
        return null;
    }

    public List<Integrante> todosOsIntegrantes(){
        return this.integrantes.todos();
    }

    public Integrante getIntegrante() {
        return integrante;
    }

    public void setIntegrante(Integrante integrante) {
        this.integrante = integrante;
    }
}
