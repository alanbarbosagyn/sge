package br.com.abce.sge.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "avaliacao_motivo", schema = "public", catalog = "sge")
public class AvaliacaoMotivoEntity {
    private Long id;
    private String motivo;
    private String tipo;
    private Collection<AvaliacaoItemEntity> avaliacaoItemsById;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "avaliacaoMotivoSeq")
    @SequenceGenerator(sequenceName = "avaliacao_motivo_seq", name = "avaliacaoMotivoSeq", schema = "public", catalog = "sge", allocationSize = 1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "motivo", nullable = true, length = 100)
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Basic
    @Column(name = "tipo", nullable = true, length = 10)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvaliacaoMotivoEntity that = (AvaliacaoMotivoEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(motivo, that.motivo) &&
                Objects.equals(tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, motivo, tipo);
    }

    @OneToMany(mappedBy = "avaliacaoMotivoByAvaliacaoMotivoId")
    public Collection<AvaliacaoItemEntity> getAvaliacaoItemsById() {
        return avaliacaoItemsById;
    }

    public void setAvaliacaoItemsById(Collection<AvaliacaoItemEntity> avaliacaoItemsById) {
        this.avaliacaoItemsById = avaliacaoItemsById;
    }
}
