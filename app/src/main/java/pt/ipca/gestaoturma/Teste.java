package pt.ipca.gestaoturma;

/**
 * Created by jcsil on 13/03/2017.
 */

public final class Teste {

    // Definição de um array de objectos do tipo Docentes
    // Tamanho máximo 20

    // Definição de uma constante
    private static final int tamanho = 20;
    private static Docente[] docentes = new Docente[tamanho];
    private static int quantidade = 0; // quantidade de docentes existentes

    public static boolean inserirDocente(int numero, String nome, String unidade)
    {
        if (quantidade < tamanho) {// Criar novo objecto do tipo Docente
            Docente novo = new Docente(numero, nome, unidade);
            docentes[quantidade] = novo;
            quantidade++;
            return true;
        }
        else return false;
    }

    public static String consultarDocente(int numero)
    {
        boolean encontrado=false;
        String resultado="";
        int i=0;
        while ((i<quantidade)&&(!encontrado))
        {
            if (docentes[i].getNumero()==numero)
            {
                resultado=docentes[i].getNome() + " " + docentes[i].getUnidade();
                encontrado=true;
            }
            i++;
        }
        return resultado;
    }





    public static String teste1()
    {
        // Novo objecto do tipo
        Docente d1 = new Docente(100,"Maria","AED");
        Docente d2 = new Docente(110,"Ana","MAT");
        Docente d3 = new Docente(120,"Paula","PROG");

        d1.setNumero(101);
        d1.setNome("Joana");
        d1.setUnidade("EST");

        return( d1.getNumero() + " " + d1.getNome() + " " + d1.getUnidade() +
                d2.getNumero() + " " + d2.getNome() + " " + d2.getUnidade() +
                d3.getNumero() + " " + d3.getNome() + " " + d3.getUnidade()
        );
    }

    // Determinar se os docentes passados por parâmetro 'obj1' e 'obj2'
    // têm os mesmos dados
    public static boolean igual(Docente obj1, Docente obj2)
    {
        return (
                (obj1.getNumero()== obj2.getNumero() ) &&
                        (obj1.getNome()== obj2.getNome() ) &&
                        (obj1.getUnidade()== obj2.getUnidade() )
        );
    }

    public static boolean testarIgual()
    {
        Docente d1 = new Docente(100,"Maria","AED");
        Docente d2 = new Docente(100,"Maria","AED");

        return (igual(d1,d2));
    }

}
