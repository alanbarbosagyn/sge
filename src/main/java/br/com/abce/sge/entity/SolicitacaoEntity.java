package br.com.abce.sge.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "solicitacao", schema = "public", catalog = "sge")
public class SolicitacaoEntity {
    private Long id;
    private String tipoSolicitacao;
    private Short atendido;
    private UsuarioEntity usuarioByUsuarioId;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "solicitacaoSeq")
    @SequenceGenerator(sequenceName = "solicitacao_seq", name = "solicitacaoSeq", schema = "public", catalog = "sge", allocationSize = 1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tipo_solicitacao", nullable = true, length = 45)
    public String getTipoSolicitacao() {
        return tipoSolicitacao;
    }

    public void setTipoSolicitacao(String tipoSolicitacao) {
        this.tipoSolicitacao = tipoSolicitacao;
    }

    @Basic
    @Column(name = "atendido", nullable = true)
    public Short getAtendido() {
        return atendido;
    }

    public void setAtendido(Short atendido) {
        this.atendido = atendido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolicitacaoEntity that = (SolicitacaoEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(tipoSolicitacao, that.tipoSolicitacao) &&
                Objects.equals(atendido, that.atendido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoSolicitacao, atendido);
    }

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    public UsuarioEntity getUsuarioByUsuarioId() {
        return usuarioByUsuarioId;
    }

    public void setUsuarioByUsuarioId(UsuarioEntity usuarioByUsuarioId) {
        this.usuarioByUsuarioId = usuarioByUsuarioId;
    }
}
