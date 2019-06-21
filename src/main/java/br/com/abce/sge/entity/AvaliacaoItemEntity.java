package br.com.abce.sge.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "avaliacao_item", schema = "public", catalog = "sge")
public class AvaliacaoItemEntity {
    private Long id;
    private AvaliacaoMotivoEntity avaliacaoMotivoByAvaliacaoMotivoId;
    private ComandaItemEntity comandaItemByComandaItemId;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "avaliacaoItemSeq")
    @SequenceGenerator(sequenceName = "avaliacao_item_seq", name = "avaliacaoItemSeq", schema = "public", catalog = "sge", allocationSize = 1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvaliacaoItemEntity that = (AvaliacaoItemEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "avaliacao_motivo_id", referencedColumnName = "id", nullable = false)
    public AvaliacaoMotivoEntity getAvaliacaoMotivoByAvaliacaoMotivoId() {
        return avaliacaoMotivoByAvaliacaoMotivoId;
    }

    public void setAvaliacaoMotivoByAvaliacaoMotivoId(AvaliacaoMotivoEntity avaliacaoMotivoByAvaliacaoMotivoId) {
        this.avaliacaoMotivoByAvaliacaoMotivoId = avaliacaoMotivoByAvaliacaoMotivoId;
    }

    @ManyToOne
    @JoinColumn(name = "comanda_item_id", referencedColumnName = "id", nullable = false)
    public ComandaItemEntity getComandaItemByComandaItemId() {
        return comandaItemByComandaItemId;
    }

    public void setComandaItemByComandaItemId(ComandaItemEntity comandaItemByComandaItemId) {
        this.comandaItemByComandaItemId = comandaItemByComandaItemId;
    }
}
