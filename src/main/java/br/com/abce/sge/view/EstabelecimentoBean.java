package br.com.abce.sge.view;

import br.com.abce.sge.dto.EstabelecimentoDto;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.servico.EstabelecimentoService;
import br.com.abce.sge.util.FacesUtil;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class EstabelecimentoBean implements Serializable {

    private EstabelecimentoDto estabelecimento;

    private List<EstabelecimentoDto> listEstabelecimento;

    @EJB
    private EstabelecimentoService estabelecimentoService;

    public EstabelecimentoBean() {

        super();
        estabelecimento = new EstabelecimentoDto();
    }

    public EstabelecimentoDto getEstabelecimento() {
        System.out.println("Passou aqui getEstabelecimento()");
        return estabelecimento;
    }

    public void setEstabelecimento(EstabelecimentoDto estabelecimento) {
        this.estabelecimento = estabelecimento;
    }



    public void salvar(){

        try {

            estabelecimentoService.salvar(estabelecimento);

            FacesUtil.sendMsg("Cadastro Estabelecimento: ", "Estabelecimento salvo com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (ValidacaoException ex) {
            FacesUtil.sendMsg("Cadastro Estabelecimento: ", ex.getMessage(), FacesMessage.SEVERITY_WARN);
        }

    }

    public void buscar(){

        listEstabelecimento = estabelecimentoService.listar();

        FacesUtil.sendMsg("Cadastro Estabelecimento: ", "Estabelecimentos listado com sucesso!", FacesMessage.SEVERITY_INFO);

    }

    public void remover(){

        try {

            estabelecimentoService.remover(estabelecimento);

            listEstabelecimento.remove(estabelecimento);

            FacesUtil.sendMsg("Cadastro Estabelecimento: ", "Estabelecimentos removido com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (ValidacaoException ex) {
            FacesUtil.sendMsg("Cadastro Estabelecimento: ", ex.getMessage(), FacesMessage.SEVERITY_WARN);
        }
    }


    public void limpar(){

        estabelecimento = new EstabelecimentoDto();

    }

    public List<EstabelecimentoDto> getListEstabelecimento() {
        return listEstabelecimento;
    }

    public void setListEstabelecimento(List<EstabelecimentoDto> listEstabelecimento) {
        this.listEstabelecimento = listEstabelecimento;
    }
}

