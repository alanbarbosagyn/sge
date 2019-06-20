package br.com.abce.sge.dto;

public class MesaDto {

    private Long id;
    private int numero;
    private String identificadorQrCode;
    private String estabelecimento;

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
}
