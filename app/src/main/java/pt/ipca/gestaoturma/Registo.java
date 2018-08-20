package pt.ipca.gestaoturma;
import java.io.Serializable;

/**
 * Created by jcsil on 05/10/2016.
 */

public class Registo implements Serializable{
    private String num;
    private String nom;
    private String clas;

    public Registo(String num, String nom, String clas)
    {
        this.num = num;
        this.nom = nom;
        this.clas = clas;
    }
    public String getNumero() { return num; }
    public String getNome() { return nom; }
    public String getClassificação() { return clas; }
}