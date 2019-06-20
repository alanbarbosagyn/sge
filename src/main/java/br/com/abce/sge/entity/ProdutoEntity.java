package br.com.abce.sge.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "produto", schema = "public", catalog = "sge")
public class ProdutoEntity {
    private int id;
    private int estabelecimentoId;
    private String nome;
    private String detalhe;
    private BigDecimal valor;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "estabelecimento_id")
    public int getEstabelecimentoId() {
        return estabelecimentoId;
    }

    public void setEstabelecimentoId(int estabelecimentoId) {
        this.estabelecimentoId = estabelecimentoId;
    }

    @Basic
    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "detalhe")
    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    @Basic
    @Column(name = "valor")
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoEntity that = (ProdutoEntity) o;
        return id == that.id &&
                estabelecimentoId == that.estabelecimentoId &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(detalhe, that.detalhe) &&
                Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, estabelecimentoId, nome, detalhe, valor);
    }
}
