package br.com.abce.sge.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "comanda", schema = "public", catalog = "sge")
public class ComandaEntity {
    private long id;
    private long estabelecimentoId;
    private long garcomId;
    private long mesaId;
    private Date dataabertura;
    private Date dataencerramento;
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
    @Column(name = "estabelecimento_id")
    public long getEstabelecimentoId() {
        return estabelecimentoId;
    }

    public void setEstabelecimentoId(long estabelecimentoId) {
        this.estabelecimentoId = estabelecimentoId;
    }

    @Basic
    @Column(name = "garcom_id")
    public long getGarcomId() {
        return garcomId;
    }

    public void setGarcomId(long garcomId) {
        this.garcomId = garcomId;
    }

    @Basic
    @Column(name = "mesa_id")
    public long getMesaId() {
        return mesaId;
    }

    public void setMesaId(long mesaId) {
        this.mesaId = mesaId;
    }

    @Basic
    @Column(name = "dataabertura")
    public Date getDataabertura() {
        return dataabertura;
    }

    public void setDataabertura(Date dataabertura) {
        this.dataabertura = dataabertura;
    }

    @Basic
    @Column(name = "dataencerramento")
    public Date getDataencerramento() {
        return dataencerramento;
    }

    public void setDataencerramento(Date dataencerramento) {
        this.dataencerramento = dataencerramento;
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
        ComandaEntity that = (ComandaEntity) o;
        return id == that.id &&
                estabelecimentoId == that.estabelecimentoId &&
                garcomId == that.garcomId &&
                mesaId == that.mesaId &&
                Objects.equals(dataabertura, that.dataabertura) &&
                Objects.equals(dataencerramento, that.dataencerramento) &&
                Objects.equals(cancelado, that.cancelado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, estabelecimentoId, garcomId, mesaId, dataabertura, dataencerramento, cancelado);
    }
}
