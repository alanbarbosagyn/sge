package br.com.abce.sge.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "avaliacao_item", schema = "public", catalog = "sge")
@IdClass(AvaliacaoItemEntityPK.class)
public class AvaliacaoItemEntity {
    private long avaliacaoId;
    private long avaliacaoMotivoId;

    @Id
    @Column(name = "avaliacao_id")
    public long getAvaliacaoId() {
        return avaliacaoId;
    }

    public void setAvaliacaoId(long avaliacaoId) {
        this.avaliacaoId = avaliacaoId;
    }

    @Id
    @Column(name = "avaliacao_motivo_id")
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
        AvaliacaoItemEntity that = (AvaliacaoItemEntity) o;
        return avaliacaoId == that.avaliacaoId &&
                avaliacaoMotivoId == that.avaliacaoMotivoId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(avaliacaoId, avaliacaoMotivoId);
    }
}
