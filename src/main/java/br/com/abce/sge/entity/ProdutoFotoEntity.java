package br.com.abce.sge.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "produto_foto", schema = "public", catalog = "sge")
public class ProdutoFotoEntity {
    private long id;
    private int produto;
    private byte[] foto;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "produto")
    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    @Basic
    @Column(name = "foto")
    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoFotoEntity that = (ProdutoFotoEntity) o;
        return id == that.id &&
                produto == that.produto &&
                Arrays.equals(foto, that.foto);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, produto);
        result = 31 * result + Arrays.hashCode(foto);
        return result;
    }
}
