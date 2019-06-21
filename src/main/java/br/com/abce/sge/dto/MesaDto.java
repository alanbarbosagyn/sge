package br.com.abce.sge.dto;

public class MesaDto {

    private Long id;
    private int numero;
    private String identificadorQrCode;
    private Long idEstabelecimento;
    private String estabelecimento;
    private int capacidade;

    public MesaDto() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getIdentificadorQrCode() {
        return identificadorQrCode;
    }

    public void setIdentificadorQrCode(String identificadorQrCode) {
        this.identificadorQrCode = identificadorQrCode;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(String estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Long getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(Long idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}
