package br.com.abce.sge.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "mesa", schema = "public", catalog = "sge")
public class MesaEntity {
    private Long id;
    private Integer numero;
    private String qrcode;
    private Integer capacidade;
    private Collection<ComandaEntity> comandasById;
    private EstabelecimentoEntity estabelecimentoByEstabelecimentoId;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mesaSeq")
    @SequenceGenerator(sequenceName = "mesa_seq", name = "mesaSeq", schema = "public", catalog = "sge", allocationSize = 1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "numero", nullable = false)
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Basic
    @Column(name = "qrcode", nullable = true, length = 100)
    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    @Basic
    @Column(name = "capacidade", nullable = false)
    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MesaEntity that = (MesaEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(numero, that.numero) &&
                Objects.equals(qrcode, that.qrcode) &&
                Objects.equals(capacidade, that.capacidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, qrcode, capacidade);
    }

    @OneToMany(mappedBy = "mesaByMesaId")
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
}
