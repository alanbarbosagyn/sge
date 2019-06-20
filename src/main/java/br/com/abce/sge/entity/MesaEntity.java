package br.com.abce.sge.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mesa", schema = "public", catalog = "sge")
public class MesaEntity {
    private long id;
    private long estabelecimentoId;
    private Integer numero;
    private String qrcode;

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
    @Column(name = "numero")
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Basic
    @Column(name = "qrcode")
    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MesaEntity that = (MesaEntity) o;
        return id == that.id &&
                estabelecimentoId == that.estabelecimentoId &&
                Objects.equals(numero, that.numero) &&
                Objects.equals(qrcode, that.qrcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, estabelecimentoId, numero, qrcode);
    }
}
