package br.com.abce.sge.view;


import br.com.abce.sge.dto.EstabelecimentoDto;
import br.com.abce.sge.dto.GarcomDto;
import br.com.abce.sge.dto.UsuarioDto;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.servico.EstabelecimentoService;
import br.com.abce.sge.servico.GarcomService;
import br.com.abce.sge.servico.UsuarioService;
import br.com.abce.sge.util.FacesUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ConversationScoped
public class GarcomBean implements Serializable {

    private GarcomDto garcom;
    private List<GarcomDto> listaGarcom;
    private List<EstabelecimentoDto> listaEstabelecimento;
    private List<UsuarioDto> listaUsuario;

    @EJB
    private GarcomService garcomService;

    @EJB
    private EstabelecimentoService estabelecimentoService;

    @EJB
    private UsuarioService usuarioService;

    @PostConstruct
    public void init(){

        listaEstabelecimento = estabelecimentoService.listar();
        listaUsuario = usuarioService.listar();
        garcom = new GarcomDto();

    }

    public void salvar(){

        try {

            garcomService.salvar(garcom);

            FacesUtil.sendMsg("Cadastro Garcom: ", "Garcom salvo com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (ValidacaoException ex) {
            FacesUtil.sendMsg("Cadastro Garcom: ", ex.getMessage(), FacesMessage.SEVERITY_WARN);
        }

    }

    public void buscar(){

        try {

            listaGarcom = garcomService.listar(garcom.getIdEstabelecimento());

            FacesUtil.sendMsg("Cadastro Garcom: ", "Garcoms listado com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (ValidacaoException ex) {
            FacesUtil.sendMsg("Cadastro Garcom: ", ex.getMessage(), FacesMessage.SEVERITY_WARN);
        }

    }

    public void remover(){

        try {

            garcomService.remover(garcom);

            listaGarcom.remove(garcom);

            FacesUtil.sendMsg("Cadastro Garcom: ", "Garcom removido com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (ValidacaoException ex) {
            FacesUtil.sendMsg("Cadastro Garcom: ", ex.getMessage(), FacesMessage.SEVERITY_WARN);
        }
    }


    public GarcomDto getGarcom() {
        return garcom;
    }

    public void setGarcom(GarcomDto garcom) {
        this.garcom = garcom;
    }

    public List<GarcomDto> getListaGarcom() {
        return listaGarcom;
    }

    public void setListaGarcom(List<GarcomDto> listaGarcom) {
        this.listaGarcom = listaGarcom;
    }

    public List<EstabelecimentoDto> getListaEstabelecimento() {
        return listaEstabelecimento;
    }

    public void setListaEstabelecimento(List<EstabelecimentoDto> listaEstabelecimento) {
        this.listaEstabelecimento = listaEstabelecimento;
    }

    public EstabelecimentoService getEstabelecimentoService() {
        return estabelecimentoService;
    }

    public void setEstabelecimentoService(EstabelecimentoService estabelecimentoService) {
        this.estabelecimentoService = estabelecimentoService;
    }

    public List<UsuarioDto> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<UsuarioDto> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
}
