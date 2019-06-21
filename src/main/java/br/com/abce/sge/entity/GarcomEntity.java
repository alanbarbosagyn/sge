package br.com.abce.sge.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "garcom", schema = "public", catalog = "sge")
public class GarcomEntity {
    private Long id;
    private Collection<ComandaEntity> comandasById;
    private EstabelecimentoEntity estabelecimentoByEstabelecimentoId;
    private UsuarioEntity usuarioByUsuarioId;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "garcomSeq")
    @SequenceGenerator(sequenceName = "garcom_seq", name = "garcomSeq", schema = "public", catalog = "sge", allocationSize = 1)
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
        GarcomEntity that = (GarcomEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @OneToMany(mappedBy = "garcomByGarcomId")
    public Collection<ComandaEntity> getComandasById() {
        return comandasById;
    }

    public void setComandasById(Collection<ComandaEntity> comandasById) {
        this.comandasById = comandasById;
    }

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id", referencedColumnName = "id", nullable = false)
    public EstabelecimentoEntity getEstabelecimentoByEstabelecimentoId() {
        return estabelecimentoByEstabelecimentoId;
    }

    public void setEstabelecimentoByEstabelecimentoId(EstabelecimentoEntity estabelecimentoByEstabelecimentoId) {
        this.estabelecimentoByEstabelecimentoId = estabelecimentoByEstabelecimentoId;
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
