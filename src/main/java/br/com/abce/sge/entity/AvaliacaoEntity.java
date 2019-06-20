package br.com.abce.sge.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "avaliacao", schema = "public", catalog = "sge")
public class AvaliacaoEntity {
    private long id;
    private long comandaItemId;
    private Integer nota;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "comanda_item_id")
    public long getComandaItemId() {
        return comandaItemId;
    }

    public void setComandaItemId(long comandaItemId) {
        this.comandaItemId = comandaItemId;
    }

    @Basic
    @Column(name = "nota")
    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvaliacaoEntity that = (AvaliacaoEntity) o;
        return id == that.id &&
                comandaItemId == that.comandaItemId &&
                Objects.equals(nota, that.nota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comandaItemId, nota);
    }
}
