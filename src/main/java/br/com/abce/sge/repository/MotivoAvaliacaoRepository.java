package br.com.abce.sge.repository;

import br.com.abce.sge.entity.AvaliacaoMotivoEntity;
import br.com.abce.sge.entity.MesaEntity;

import java.util.List;

/**
 * Created by alan-bs on jul, 2019
 */
public interface MotivoAvaliacaoRepository {

    List<AvaliacaoMotivoEntity> listar();

    AvaliacaoMotivoEntity buscar(Long idMotivoAvaliacao);

    void salvar(AvaliacaoMotivoEntity entity);
}
