package Proto;

import java.util.Date;

public class ContratoDeFilme implements IContratoPrototype, Cloneable {

    // Atributos Fixos pros contratos legais
    private final String clausulasDireitosAutorais;
    private final String jurisdicaoPadrao;

    // Atributos Mutáveis
    private String titulo;
    private double valorDistribuicao;
    private Date dataExpiracao;

    public ContratoDeFilme(String clausulasDireitosAutorais, String jurisdicaoPadrao) {
        this.clausulasDireitosAutorais = clausulasDireitosAutorais;
        this.jurisdicaoPadrao = jurisdicaoPadrao;

        this.titulo = "PROTÓTIPO MESTRE";
        this.valorDistribuicao = 0.0;
        this.dataExpiracao = new Date(0);
    }

    @Override
    public IContratoPrototype clonar() {
        try {
            return (IContratoPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Falha ao clonar o contrato.", e);
        }
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setValorDistribuicao(double valorDistribuicao) {
        this.valorDistribuicao = valorDistribuicao;
    }

    public String getTitulo() { return titulo; }
    public String getClausulasDireitosAutorais() { return clausulasDireitosAutorais; }
    public double getValorDistribuicao() { return valorDistribuicao; }
}
