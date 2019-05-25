package br.com.abce.sge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "\"SGE_PRODUTO\"", schema = "public")
public class Produto implements Serializable {

    private Long id;

    private String descricao;

    private String nome;

    public Produto() {
        super();
    }

    @Id
    @Column(name = "\"ID\"")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "\"DESCRICAO\"")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(name = "\"NOME\"")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
