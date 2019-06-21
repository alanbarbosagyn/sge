package br.com.abce.sge.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "produto_foto", schema = "public", catalog = "sge")
public class ProdutoFotoEntity {
    private Long id;
    private byte[] foto;
    private Integer situacao;
    private ProdutoEntity produtoByProduto;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtoFotoSeq")
    @SequenceGenerator(sequenceName = "produto_foto_seq", name = "produtoFotoSeq", schema = "public", catalog = "sge", allocationSize = 1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "foto", nullable = true)
    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
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
        ProdutoFotoEntity that = (ProdutoFotoEntity) o;
        return Objects.equals(id, that.id) &&
                Arrays.equals(foto, that.foto) &&
                Objects.equals(situacao, that.situacao);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, situacao);
        result = 31 * result + Arrays.hashCode(foto);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "produto", referencedColumnName = "id", nullable = false)
    public ProdutoEntity getProdutoByProduto() {
        return produtoByProduto;
    }

    public void setProdutoByProduto(ProdutoEntity produtoByProduto) {
        this.produtoByProduto = produtoByProduto;
    }
}
