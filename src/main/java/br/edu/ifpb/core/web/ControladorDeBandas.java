package br.edu.ifpb.core.web;

import br.edu.ifpb.core.domain.Banda;
import br.edu.ifpb.core.infra.jpa.Bandas;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@SessionScoped
public class ControladorDeBandas {

    @Inject
    private Bandas bandas;
    private Banda banda = new Banda();
    private String localDeOrigem = "";
    private List<Banda> bandaList;

    public List<Banda> todasAsBandas() {
        return this.bandas.todos();
    }

    public String buscarPorLocalDeOrigem() {
        this.bandaList = bandas.buscaPorLocalDeOrigem(localDeOrigem);
        return null;
    }

    public List<Banda> resultadoDeBusca() {
        return this.bandaList;
    }

    public String getLocalDeOrigem() {
        return localDeOrigem;
    }

    public void setLocalDeOrigem(String localDeOrigem) {
        this.localDeOrigem = localDeOrigem;
    }

    public String adicionar() {
        this.bandas.salvar(this.banda);
        return "/banda/list?faces-redirect=true";
    }

    public String update(Banda banda) {
        this.banda = banda;
        return "/banda/edit?faces-redirect=true";
    }

    public String remover(Banda banda) {
        this.bandas.delete(banda);
        return "/banda/edit?faces-redirect=true";
    }
}
