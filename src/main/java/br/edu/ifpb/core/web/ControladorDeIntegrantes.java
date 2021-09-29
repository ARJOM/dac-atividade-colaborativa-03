package br.edu.ifpb.core.web;

import br.edu.ifpb.core.domain.Integrante;
import br.edu.ifpb.core.infra.jpa.Integrantes;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ControladorDeIntegrantes implements Serializable{

    @Inject
    private Integrantes integrantes;
    private Integrante integrante = new Integrante();
    private String cpfDeBusca = "";

    public String salvar() {
        integrantes.salvar(this.integrante);
        this.integrante = new Integrante();
        return null;
    }

    public List<Integrante> todosOsIntegrantes() {
        return this.integrantes.todos();
    }

    public String buscarPorCpf() {
        this.integrante = integrantes.buscarPorCPF(cpfDeBusca);
        return null;
    }

    public List<Integrante> listagemPorNascimento() {
        return integrantes.integrantesPorIntervaloEspecifico();
    }

    public List<Integrante> resultadoDeBusca() {
        List<Integrante> lista = new ArrayList<>();
        lista.add(this.integrante);
        return lista;
    }

    public String getCpfDeBusca() {
        return cpfDeBusca;
    }

    public void setCpfDeBusca(String cpfDeBusca) {
        this.cpfDeBusca = cpfDeBusca;
    }

    public Integrante getIntegrante() {
        return integrante;
    }

    public void setIntegrante(Integrante integrante) {
        this.integrante = integrante;
    }

    public String adicionar() {
        this.integrantes.salvar(this.integrante);
        return "integrante/list?faces-redirect=true";

    }

    public String update(Integrante integrante) {
        this.integrante = integrante;
        return "/integrante/edit?faces-redirect=true";
    }

    public String delete(Integrante integrante) {
        this.integrantes.deleteIntegrante(integrante);
        return "/integrante/list";
    }

}
