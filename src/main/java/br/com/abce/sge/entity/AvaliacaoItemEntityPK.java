package br.com.abce.sge.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AvaliacaoItemEntityPK implements Serializable {
    private long avaliacaoId;
    private long avaliacaoMotivoId;

    @Column(name = "avaliacao_id")
    @Id
    public long getAvaliacaoId() {
        return avaliacaoId;
    }

    public void setAvaliacaoId(long avaliacaoId) {
        this.avaliacaoId = avaliacaoId;
    }

    @Column(name = "avaliacao_motivo_id")
    @Id
    public long getAvaliacaoMotivoId() {
        return avaliacaoMotivoId;
    }

    public void setAvaliacaoMotivoId(long avaliacaoMotivoId) {
        this.avaliacaoMotivoId = avaliacaoMotivoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvaliacaoItemEntityPK that = (AvaliacaoItemEntityPK) o;
        return avaliacaoId == that.avaliacaoId &&
                avaliacaoMotivoId == that.avaliacaoMotivoId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(avaliacaoId, avaliacaoMotivoId);
    }
}
