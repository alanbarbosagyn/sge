package br.com.abce.sge.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "avaliacao_item", schema = "public", catalog = "sge")
@IdClass(AvaliacaoItemEntityPK.class)
public class AvaliacaoItemEntity {
    private int avaliacaoId;
    private int avaliacaoMotivoId;

    @Id
    @Column(name = "avaliacao_id")
    public int getAvaliacaoId() {
        return avaliacaoId;
    }

    public void setAvaliacaoId(int avaliacaoId) {
        this.avaliacaoId = avaliacaoId;
    }

    @Id
    @Column(name = "avaliacao_motivo_id")
    public int getAvaliacaoMotivoId() {
        return avaliacaoMotivoId;
    }

    public void setAvaliacaoMotivoId(int avaliacaoMotivoId) {
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
