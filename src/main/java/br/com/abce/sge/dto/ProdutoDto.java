package br.com.abce.sge.dto;

import br.com.abce.sge.entity.Produto;
import io.swagger.annotations.ApiModel;

import javax.ws.rs.FormParam;
import java.io.Serializable;

@ApiModel(value = "Dados do Produto.")
public class ProdutoDto implements Serializable {

    @FormParam("id")
    private Long id;
    @FormParam("descricao")
    private String descricao;
    @FormParam("nome")
    private String nome;

    public ProdutoDto() {
        super();
    }

    public ProdutoDto(Produto produto) {
         setDescricao(produto.getDescricao());
         setId(produto.getId());
         setNome(produto.getNome());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
