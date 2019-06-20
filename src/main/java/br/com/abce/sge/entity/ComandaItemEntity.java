package br.com.abce.sge.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "comanda_item", schema = "public", catalog = "sge")
public class ComandaItemEntity {
    private long id;
    private long comandaId;
    private long produtoId;
    private long usuarioId;
    private BigDecimal valor;
    private Short cancelado;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "comanda_id")
    public long getComandaId() {
        return comandaId;
    }

    public void setComandaId(long comandaId) {
        this.comandaId = comandaId;
    }

    @Basic
    @Column(name = "produto_id")
    public long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(long produtoId) {
        this.produtoId = produtoId;
    }

    @Basic
    @Column(name = "usuario_id")
    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Basic
    @Column(name = "valor")
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Basic
    @Column(name = "cancelado")
    public Short getCancelado() {
        return cancelado;
    }

    public void setCancelado(Short cancelado) {
        this.cancelado = cancelado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComandaItemEntity that = (ComandaItemEntity) o;
        return id == that.id &&
                comandaId == that.comandaId &&
                produtoId == that.produtoId &&
                usuarioId == that.usuarioId &&
                Objects.equals(valor, that.valor) &&
                Objects.equals(cancelado, that.cancelado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comandaId, produtoId, usuarioId, valor, cancelado);
    }
}
