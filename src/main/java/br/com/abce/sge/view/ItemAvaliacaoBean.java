package br.com.abce.sge.view;

import br.com.abce.sge.dto.MotivoAvaliacaoDto;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.servico.MotivoAvaliacaoService;
import br.com.abce.sge.util.FacesUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by alan-bs on jul, 2019
 */
@Named
@ViewScoped
public class ItemAvaliacaoBean implements Serializable {

    private MotivoAvaliacaoDto itemAvaliacao;

    private List<MotivoAvaliacaoDto> listaItemAvaliacao;

    @EJB
    private MotivoAvaliacaoService motivoAvaliacaoService;

    @PostConstruct
    public void init(){

        listaItemAvaliacao = motivoAvaliacaoService.listar();
        itemAvaliacao = new MotivoAvaliacaoDto();
    }


    public void salvar(){

        try {

            motivoAvaliacaoService.salvar(itemAvaliacao);

            FacesUtil.sendMsg("Cadastro Item Avaliacao: ", "ItemAvaliacao salvo com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (ValidacaoException ex) {
            FacesUtil.sendMsg("Cadastro Item Avaliacao: ", ex.getMessage(), FacesMessage.SEVERITY_WARN);
        }

    }

    public void buscar(){

        listaItemAvaliacao = motivoAvaliacaoService.listar();

        FacesUtil.sendMsg("Cadastro Item Avaliacao: ", "ItemAvaliacaos listado com sucesso!", FacesMessage.SEVERITY_INFO);

    }


    public void limpar(){

        itemAvaliacao = new MotivoAvaliacaoDto();

    }


    public MotivoAvaliacaoDto getItemAvaliacao() {
        return itemAvaliacao;
    }

    public void setItemAvaliacao(MotivoAvaliacaoDto itemAvaliacao) {
        this.itemAvaliacao = itemAvaliacao;
    }

    public List<MotivoAvaliacaoDto> getListaItemAvaliacao() {
        return listaItemAvaliacao;
    }

    public void setListaItemAvaliacao(List<MotivoAvaliacaoDto> listaItemAvaliacao) {
        this.listaItemAvaliacao = listaItemAvaliacao;
    }
}
