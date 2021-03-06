package br.com.abce.sge.view;


import br.com.abce.sge.dto.EstabelecimentoDto;
import br.com.abce.sge.dto.ProdutoDto;
import br.com.abce.sge.exceptions.ValidacaoException;
import br.com.abce.sge.servico.EstabelecimentoService;
import br.com.abce.sge.servico.ProdutoService;
import br.com.abce.sge.util.FacesUtil;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ProdutoBean implements Serializable {

    private ProdutoDto produto;

    private List<ProdutoDto> listaProduto;

    private List<EstabelecimentoDto> listaEstabelecimentos;

    private UploadedFile foto;

//    private List<byte[]> listaFotos;

    @EJB
    private ProdutoService produtoService;

    @EJB
    private EstabelecimentoService estabelecimentoService;

    public ProdutoBean() {
        super();
    }

    @PostConstruct
    public void init(){

        listaEstabelecimentos = estabelecimentoService.listar();
        produto = new ProdutoDto();
//        listaFotos = new ArrayList<>();
    }

    public void salvar(){

        try {

            produtoService.salvar(produto);

            FacesUtil.sendMsg("Cadastro Produto: ", "Produto salvo com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (ValidacaoException ex) {
            FacesUtil.sendMsg("Cadastro Produto: ", ex.getMessage(), FacesMessage.SEVERITY_WARN);
        }

    }

    public void buscar(){

        try {

            listaProduto = produtoService.listar(produto.getIdEstabelecimento());

            FacesUtil.sendMsg("Cadastro Produto: ", "Produtos listado com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (ValidacaoException ex) {
            FacesUtil.sendMsg("Cadastro Produto: ", ex.getMessage(), FacesMessage.SEVERITY_WARN);
        }

    }

    public void remover(){

        try {

            produtoService.remover(produto);

            listaProduto.remove(produto);

            FacesUtil.sendMsg("Cadastro Produto: ", "Produto removido com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (ValidacaoException ex) {
            FacesUtil.sendMsg("Cadastro Produto: ", ex.getMessage(), FacesMessage.SEVERITY_WARN);
        }
    }


    public void limpar(){

        produto = new ProdutoDto();
//        listaFotos = new ArrayList<>();

    }

    public void fileUploadAdvanced(FileUploadEvent event){

        UploadedFile uploadedFile = event.getFile();

        produto.getListaFotos().add(uploadedFile.getContents());
    }


    public List<ProdutoDto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(List<ProdutoDto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public ProdutoDto getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDto Produto) {
        this.produto = Produto;
    }

    public List<EstabelecimentoDto> getListaEstabelecimentos() {
        return listaEstabelecimentos;
    }

    public void setListaEstabelecimentos(List<EstabelecimentoDto> listaEstabelecimentos) {
        this.listaEstabelecimentos = listaEstabelecimentos;
    }

//    public List<byte[]> getListaFotos() {
//        return listaFotos;
//    }
//
//    public void setListaFotos(List<byte[]> listaFotos) {
//        this.listaFotos = listaFotos;
//    }

    public UploadedFile getFoto() {
        return foto;
    }

    public void setFoto(UploadedFile foto) {
        this.foto = foto;
    }
}
