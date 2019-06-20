package br.com.abce.sge.dto;

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
    @FormParam("valor")
    private Double valor;

    public ProdutoDto() {
        super();
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
