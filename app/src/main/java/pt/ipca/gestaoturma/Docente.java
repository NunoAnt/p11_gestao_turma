package pt.ipca.gestaoturma;

/**
 * Created by jcsil on 13/03/2017.
 */

public class Docente {

    // Variáveis de instânica
    private int numero;
    private String nome;
    private String unidade;

    // Construtor
    public Docente(int numero, String nome, String unidade) {
        this.numero = numero;
        this.nome = nome;
        this.unidade = unidade;
    }

    // Métodos de instância

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
}
