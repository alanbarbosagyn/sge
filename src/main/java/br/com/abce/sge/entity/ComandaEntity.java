package br.com.abce.sge.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "comanda", schema = "public", catalog = "sge")
public class ComandaEntity {
    private int id;
    private int estabelecimentoId;
    private int garcomId;
    private int mesaId;
    private Date dataabertura;
    private Date dataencerramento;
    private Short cancelado;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "estabelecimento_id")
    public int getEstabelecimentoId() {
        return estabelecimentoId;
    }

    public void setEstabelecimentoId(int estabelecimentoId) {
        this.estabelecimentoId = estabelecimentoId;
    }

    @Basic
    @Column(name = "garcom_id")
    public int getGarcomId() {
        return garcomId;
    }

    public void setGarcomId(int garcomId) {
        this.garcomId = garcomId;
    }

    @Basic
    @Column(name = "mesa_id")
    public int getMesaId() {
        return mesaId;
    }

    public void setMesaId(int mesaId) {
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
