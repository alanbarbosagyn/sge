package br.com.abce.sge.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "comanda", schema = "public", catalog = "sge")
public class ComandaEntity {
    private Long id;
    private Date dataabertura;
    private Date dataencerramento;
    private Integer situacao;
    private EstabelecimentoEntity estabelecimentoByEstabelecimentoId;
    private GarcomEntity garcomByGarcomId;
    private MesaEntity mesaByMesaId;
    private Collection<ComandaItemEntity> comandaItemsById;
    private Collection<ComandaUsuarioEntity> comandaUsuariosById;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comandaSeq")
    @SequenceGenerator(sequenceName = "comanda_seq", name = "comandaSeq", schema = "public", catalog = "sge", allocationSize = 1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "dataabertura", nullable = false)
    public Date getDataabertura() {
        return dataabertura;
    }

    public void setDataabertura(Date dataabertura) {
        this.dataabertura = dataabertura;
    }

    @Basic
    @Column(name = "dataencerramento", nullable = true)
    public Date getDataencerramento() {
        return dataencerramento;
    }

    public void setDataencerramento(Date dataencerramento) {
        this.dataencerramento = dataencerramento;
    }

    @Basic
    @Column(name = "situacao", nullable = false)
    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComandaEntity that = (ComandaEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dataabertura, that.dataabertura) &&
                Objects.equals(dataencerramento, that.dataencerramento) &&
                Objects.equals(situacao, that.situacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataabertura, dataencerramento, situacao);
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
    @JoinColumn(name = "garcom_id", referencedColumnName = "id", nullable = false)
    public GarcomEntity getGarcomByGarcomId() {
        return garcomByGarcomId;
    }

    public void setGarcomByGarcomId(GarcomEntity garcomByGarcomId) {
        this.garcomByGarcomId = garcomByGarcomId;
    }

    @ManyToOne
    @JoinColumn(name = "mesa_id", referencedColumnName = "id", nullable = false)
    public MesaEntity getMesaByMesaId() {
        return mesaByMesaId;
    }

    public void setMesaByMesaId(MesaEntity mesaByMesaId) {
        this.mesaByMesaId = mesaByMesaId;
    }

    @OneToMany(mappedBy = "comandaByComandaId")
    public Collection<ComandaItemEntity> getComandaItemsById() {
        return comandaItemsById;
    }

    public void setComandaItemsById(Collection<ComandaItemEntity> comandaItemsById) {
        this.comandaItemsById = comandaItemsById;
    }

    @OneToMany(mappedBy = "comandaByComandaId")
    public Collection<ComandaUsuarioEntity> getComandaUsuariosById() {
        return comandaUsuariosById;
    }

    public void setComandaUsuariosById(Collection<ComandaUsuarioEntity> comandaUsuariosById) {
        this.comandaUsuariosById = comandaUsuariosById;
    }
}
