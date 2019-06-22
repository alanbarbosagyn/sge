package br.com.abce.sge.view;

import br.com.abce.sge.dto.EstabelecimentoDto;
import br.com.abce.sge.dto.MesaDto;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.servico.EstabelecimentoService;
import br.com.abce.sge.servico.MesaService;
import br.com.abce.sge.util.FacesUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class MesaBean implements Serializable {

    private MesaDto mesa;

    private List<MesaDto> listaMesa;

    private List<EstabelecimentoDto> listaEstabelecimentos;

    @EJB
    private MesaService mesaService;

    @EJB
    private EstabelecimentoService estabelecimentoService;

    public MesaBean() {
        super();
    }

    @PostConstruct
    public void init(){

        listaEstabelecimentos = estabelecimentoService.listar();
        mesa = new MesaDto();
    }

    public void salvar(){

        try {

            mesaService.salvar(mesa);

            FacesUtil.sendMsg("Cadastro Mesa: ", "Mesa salvo com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (ValidacaoException ex) {
            FacesUtil.sendMsg("Cadastro Mesa: ", ex.getMessage(), FacesMessage.SEVERITY_WARN);
        }

    }

    public void buscar(){

        try {

            listaMesa = mesaService.listar(mesa.getIdEstabelecimento());

            FacesUtil.sendMsg("Cadastro Mesa: ", "Mesas listado com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (ValidacaoException ex) {
            FacesUtil.sendMsg("Cadastro Mesa: ", ex.getMessage(), FacesMessage.SEVERITY_WARN);
        }

    }

    public void remover(){

        try {

            mesaService.remover(mesa);

            listaMesa.remove(mesa);

            FacesUtil.sendMsg("Cadastro Mesa: ", "Mesa removido com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (ValidacaoException ex) {
            FacesUtil.sendMsg("Cadastro Mesa: ", ex.getMessage(), FacesMessage.SEVERITY_WARN);
        }
    }


    public void limpar(){

        mesa = new MesaDto();

    }


    public List<MesaDto> getListaMesa() {
        return listaMesa;
    }

    public void setListaMesa(List<MesaDto> listaMesa) {
        this.listaMesa = listaMesa;
    }

    public MesaDto getMesa() {
        return mesa;
    }

    public void setMesa(MesaDto mesa) {
        this.mesa = mesa;
    }

    public List<EstabelecimentoDto> getListaEstabelecimentos() {
        return listaEstabelecimentos;
    }

    public void setListaEstabelecimentos(List<EstabelecimentoDto> listaEstabelecimentos) {
        this.listaEstabelecimentos = listaEstabelecimentos;
    }
}
