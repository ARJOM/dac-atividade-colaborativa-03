package br.edu.ifpb.core.web;

import br.edu.ifpb.core.domain.Banda;
import br.edu.ifpb.core.infra.jpa.Bandas;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ControladorDeBandas {

    @Inject
    private Bandas bandas;

    public List<Banda> todasAsBandas(){
        return this.bandas.todos();
    }

}
