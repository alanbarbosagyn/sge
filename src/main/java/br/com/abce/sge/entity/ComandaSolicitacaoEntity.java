package br.com.abce.sge.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comanda_solicitacao", schema = "public", catalog = "sge")
public class ComandaSolicitacaoEntity {
    private long id;
    private long comandaId;
    private String tipoSolicitacao;
    private Short atendido;

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
    @Column(name = "tipo_solicitacao")
    public String getTipoSolicitacao() {
        return tipoSolicitacao;
    }

    public void setTipoSolicitacao(String tipoSolicitacao) {
        this.tipoSolicitacao = tipoSolicitacao;
    }

    @Basic
    @Column(name = "atendido")
    public Short getAtendido() {
        return atendido;
    }

    public void setAtendido(Short atendido) {
        this.atendido = atendido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComandaSolicitacaoEntity that = (ComandaSolicitacaoEntity) o;
        return id == that.id &&
                comandaId == that.comandaId &&
                Objects.equals(tipoSolicitacao, that.tipoSolicitacao) &&
                Objects.equals(atendido, that.atendido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comandaId, tipoSolicitacao, atendido);
    }
}
