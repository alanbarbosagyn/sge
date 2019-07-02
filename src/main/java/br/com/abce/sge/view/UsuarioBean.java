package br.com.abce.sge.view;

import br.com.abce.sge.dto.UsuarioDto;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.servico.UsuarioService;
import br.com.abce.sge.util.FacesUtil;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

    private UsuarioDto usuario;

    private List<UsuarioDto> listUsuario;

    @EJB
    private UsuarioService usuarioService;

    public UsuarioBean() {

        super();
        usuario = new UsuarioDto();
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }



    public void salvar(){

        try {

            usuarioService.salvar(usuario);

            FacesUtil.sendMsg("Cadastro Usuario: ", "Usuario salvo com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (ValidacaoException ex) {
            FacesUtil.sendMsg("Cadastro Usuario: ", ex.getMessage(), FacesMessage.SEVERITY_WARN);
        }

    }

    public void buscar(){

        listUsuario = usuarioService.listar();

        FacesUtil.sendMsg("Cadastro Usuario: ", "Usuarios listado com sucesso!", FacesMessage.SEVERITY_INFO);

    }

    public void remover(){

        try {

            usuarioService.remover(usuario);

            listUsuario.remove(usuario);

            FacesUtil.sendMsg("Cadastro Usuario: ", "Usuario removido com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (ValidacaoException ex) {
            FacesUtil.sendMsg("Cadastro Usuario: ", ex.getMessage(), FacesMessage.SEVERITY_WARN);
        }
    }


    public void limpar(){

        usuario = new UsuarioDto();

    }

    public List<UsuarioDto> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<UsuarioDto> listUsuario) {
        this.listUsuario = listUsuario;
    }
}

