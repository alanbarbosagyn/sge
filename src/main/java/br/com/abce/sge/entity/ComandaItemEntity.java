package br.com.abce.sge.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "comanda_item", schema = "public", catalog = "sge")
public class ComandaItemEntity {
    private Long id;
    private BigDecimal valor;
    private Integer situacao;
    private Date dataHoraSolicitacao;
    private Date dataHoraEntregra;
    private Collection<AvaliacaoItemEntity> avaliacaoItemsById;
    private ComandaEntity comandaByComandaId;
    private ProdutoEntity produtoByProdutoId;
    private UsuarioEntity usuarioByUsuarioId;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comandaItemSeq")
    @SequenceGenerator(sequenceName = "comanda_item_seq", name = "comandaItemSeq", schema = "public", catalog = "sge", allocationSize = 1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "valor", nullable = true, precision = 2)
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Basic
    @Column(name = "situacao", nullable = false)
    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }

    @Basic
    @Column(name = "data_hora_solicitacao", nullable = false)
    public Date getDataHoraSolicitacao() {
        return dataHoraSolicitacao;
    }

    public void setDataHoraSolicitacao(Date dataHoraSolicitacao) {
        this.dataHoraSolicitacao = dataHoraSolicitacao;
    }

    @Basic
    @Column(name = "data_hora_entregra", nullable = true)
    public Date getDataHoraEntregra() {
        return dataHoraEntregra;
    }

    public void setDataHoraEntregra(Date dataHoraEntregra) {
        this.dataHoraEntregra = dataHoraEntregra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComandaItemEntity that = (ComandaItemEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(valor, that.valor) &&
                Objects.equals(situacao, that.situacao) &&
                Objects.equals(dataHoraSolicitacao, that.dataHoraSolicitacao) &&
                Objects.equals(dataHoraEntregra, that.dataHoraEntregra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor, situacao, dataHoraSolicitacao, dataHoraEntregra);
    }

    @OneToMany(mappedBy = "comandaItemByComandaItemId")
    public Collection<AvaliacaoItemEntity> getAvaliacaoItemsById() {
        return avaliacaoItemsById;
    }

    public void setAvaliacaoItemsById(Collection<AvaliacaoItemEntity> avaliacaoItemsById) {
        this.avaliacaoItemsById = avaliacaoItemsById;
    }

    @ManyToOne
    @JoinColumn(name = "comanda_id", referencedColumnName = "id", nullable = false)
    public ComandaEntity getComandaByComandaId() {
        return comandaByComandaId;
    }

    public void setComandaByComandaId(ComandaEntity comandaByComandaId) {
        this.comandaByComandaId = comandaByComandaId;
    }

    @ManyToOne
    @JoinColumn(name = "produto_id", referencedColumnName = "id", nullable = false)
    public ProdutoEntity getProdutoByProdutoId() {
        return produtoByProdutoId;
    }

    public void setProdutoByProdutoId(ProdutoEntity produtoByProdutoId) {
        this.produtoByProdutoId = produtoByProdutoId;
    }

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    public UsuarioEntity getUsuarioByUsuarioId() {
        return usuarioByUsuarioId;
    }

    public void setUsuarioByUsuarioId(UsuarioEntity usuarioByUsuarioId) {
        this.usuarioByUsuarioId = usuarioByUsuarioId;
    }
}
