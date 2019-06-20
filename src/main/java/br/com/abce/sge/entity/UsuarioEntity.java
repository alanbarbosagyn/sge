package br.com.abce.sge.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usuario", schema = "public", catalog = "sge")
public class UsuarioEntity {
    private long id;
    private String usuario;
    private String nome;
    private String email;
    private String senha;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "usuario")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "senha")
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return id == that.id &&
                Objects.equals(usuario, that.usuario) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(email, that.email) &&
                Objects.equals(senha, that.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, nome, email, senha);
    }
}
