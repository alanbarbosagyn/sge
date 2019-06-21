package br.com.abce.sge.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "produto", schema = "public", catalog = "sge")
public class ProdutoEntity {
    private Long id;
    private String nome;
    private String descricao;
    private Double valor;
    private String observacao;
    private Integer situacao;
    private Collection<ComandaItemEntity> comandaItemsById;
    private EstabelecimentoEntity estabelecimentoByEstabelecimentoId;
    private Collection<ProdutoFotoEntity> produtoFotosById;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtoSeq")
    @SequenceGenerator(sequenceName = "produto_seq", name = "produtoSeq", schema = "public", catalog = "sge", allocationSize = 1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nome", nullable = false, length = 45)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "descricao", nullable = false, length = 100)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Basic
    @Column(name = "valor", nullable = false, precision = 2)
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Basic
    @Column(name = "observacao", nullable = true, length = 300)
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Basic
    @Column(name = "situacao", nullable = false)
    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoEntity entity = (ProdutoEntity) o;
        return Objects.equals(id, entity.id) &&
                Objects.equals(nome, entity.nome) &&
                Objects.equals(descricao, entity.descricao) &&
                Objects.equals(valor, entity.valor) &&
                Objects.equals(observacao, entity.observacao) &&
                Objects.equals(situacao, entity.situacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, valor, observacao, situacao);
    }

    @OneToMany(mappedBy = "produtoByProdutoId")
    public Collection<ComandaItemEntity> getComandaItemsById() {
        return comandaItemsById;
    }

    public void setComandaItemsById(Collection<ComandaItemEntity> comandaItemsById) {
        this.comandaItemsById = comandaItemsById;
    }

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id", referencedColumnName = "id", nullable = false)
    public EstabelecimentoEntity getEstabelecimentoByEstabelecimentoId() {
        return estabelecimentoByEstabelecimentoId;
    }

    public void setEstabelecimentoByEstabelecimentoId(EstabelecimentoEntity estabelecimentoByEstabelecimentoId) {
        this.estabelecimentoByEstabelecimentoId = estabelecimentoByEstabelecimentoId;
    }

    @OneToMany(mappedBy = "produtoByProduto")
    public Collection<ProdutoFotoEntity> getProdutoFotosById() {
        return produtoFotosById;
    }

    public void setProdutoFotosById(Collection<ProdutoFotoEntity> produtoFotosById) {
        this.produtoFotosById = produtoFotosById;
    }
}
