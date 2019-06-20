package br.com.abce.sge.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "estabelecimento", schema = "public", catalog = "sge")
public class EstabelecimentoEntity {
    private int id;
    private String nome;
    private String endereco;
    private String cidade;
    private String uf;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "endereco")
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Basic
    @Column(name = "cidade")
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Basic
    @Column(name = "uf")
    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstabelecimentoEntity that = (EstabelecimentoEntity) o;
        return id == that.id &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(endereco, that.endereco) &&
                Objects.equals(cidade, that.cidade) &&
                Objects.equals(uf, that.uf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, endereco, cidade, uf);
    }
}
