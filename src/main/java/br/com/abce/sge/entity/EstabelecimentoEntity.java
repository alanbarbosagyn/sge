package br.com.abce.sge.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "estabelecimento", schema = "public", catalog = "sge")
public class EstabelecimentoEntity {
    private Long id;
    private String nome;
    private String cnpj;
    private Collection<ComandaEntity> comandasById;
    private EnderecoEntity enderecoByEnderecoId;
    private Collection<GarcomEntity> garcomsById;
    private Collection<MesaEntity> mesasById;
    private Collection<ProdutoEntity> produtosById;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estabelecimentoSeq")
    @SequenceGenerator(sequenceName = "estabelecimento_seq", name = "estabelecimentoSeq", schema = "public", catalog = "sge", allocationSize = 1)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nome", nullable = true, length = 100)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "cnpj", nullable = true, length = 14)
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstabelecimentoEntity entity = (EstabelecimentoEntity) o;
        return Objects.equals(id, entity.id) &&
                Objects.equals(nome, entity.nome) &&
                Objects.equals(cnpj, entity.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cnpj);
    }

    @OneToMany(mappedBy = "estabelecimentoByEstabelecimentoId")
    public Collection<ComandaEntity> getComandasById() {
        return comandasById;
    }

    public void setComandasById(Collection<ComandaEntity> comandasById) {
        this.comandasById = comandasById;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id", nullable = false)
    public EnderecoEntity getEnderecoByEnderecoId() {
        return enderecoByEnderecoId;
    }

    public void setEnderecoByEnderecoId(EnderecoEntity enderecoByEnderecoId) {
        this.enderecoByEnderecoId = enderecoByEnderecoId;
    }

    @OneToMany(mappedBy = "estabelecimentoByEstabelecimentoId")
    public Collection<GarcomEntity> getGarcomsById() {
        return garcomsById;
    }

    public void setGarcomsById(Collection<GarcomEntity> garcomsById) {
        this.garcomsById = garcomsById;
    }

    @OneToMany(mappedBy = "estabelecimentoByEstabelecimentoId")
    public Collection<MesaEntity> getMesasById() {
        return mesasById;
    }

    public void setMesasById(Collection<MesaEntity> mesasById) {
        this.mesasById = mesasById;
    }

    @OneToMany(mappedBy = "estabelecimentoByEstabelecimentoId")
    public Collection<ProdutoEntity> getProdutosById() {
        return produtosById;
    }

    public void setProdutosById(Collection<ProdutoEntity> produtosById) {
        this.produtosById = produtosById;
    }
}
