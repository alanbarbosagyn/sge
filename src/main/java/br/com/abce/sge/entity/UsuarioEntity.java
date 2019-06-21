package br.com.abce.sge.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "usuario", schema = "public", catalog = "sge")
public class UsuarioEntity {
    private Long id;
    private String usuario;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private Collection<ComandaItemEntity> comandaItemsById;
    private Collection<ComandaUsuarioEntity> comandaUsuariosById;
    private Collection<GarcomEntity> garcomsById;
    private Collection<SolicitacaoEntity> solicitacaosById;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioSeq")
    @SequenceGenerator(sequenceName = "usuario_seq", name = "usuarioSeq", schema = "public", catalog = "sge", allocationSize = 1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "usuario", nullable = false, length = 20)
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "nome", nullable = false, length = 50)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 20)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "senha", nullable = false, length = 35)
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Basic
    @Column(name = "telefone", nullable = true, length = 11)
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(usuario, that.usuario) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(email, that.email) &&
                Objects.equals(senha, that.senha) &&
                Objects.equals(telefone, that.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, nome, email, senha, telefone);
    }

    @OneToMany(mappedBy = "usuarioByUsuarioId")
    public Collection<ComandaItemEntity> getComandaItemsById() {
        return comandaItemsById;
    }

    public void setComandaItemsById(Collection<ComandaItemEntity> comandaItemsById) {
        this.comandaItemsById = comandaItemsById;
    }

    @OneToMany(mappedBy = "usuarioByUsuarioId")
    public Collection<ComandaUsuarioEntity> getComandaUsuariosById() {
        return comandaUsuariosById;
    }

    public void setComandaUsuariosById(Collection<ComandaUsuarioEntity> comandaUsuariosById) {
        this.comandaUsuariosById = comandaUsuariosById;
    }

    @OneToMany(mappedBy = "usuarioByUsuarioId")
    public Collection<GarcomEntity> getGarcomsById() {
        return garcomsById;
    }

    public void setGarcomsById(Collection<GarcomEntity> garcomsById) {
        this.garcomsById = garcomsById;
    }

    @OneToMany(mappedBy = "usuarioByUsuarioId")
    public Collection<SolicitacaoEntity> getSolicitacaosById() {
        return solicitacaosById;
    }

    public void setSolicitacaosById(Collection<SolicitacaoEntity> solicitacaosById) {
        this.solicitacaosById = solicitacaosById;
    }
}
