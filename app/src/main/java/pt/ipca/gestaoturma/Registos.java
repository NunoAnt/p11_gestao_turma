package pt.ipca.gestaoturma;

import java.util.ArrayList;

/**
 * Created by jcsil on 06/10/2016.
 */

public final class Registos {

    private static ArrayList<Registo> aRegisto = new ArrayList<Registo>();


    public static void teste()
    {
        Registo r = new Registo("1000","Maria","15");
        Registo r1 = new Registo("2000","Joao","15");
        aRegisto.add(r);
        aRegisto.add(r1);


    }


    public static ArrayList<Registo> getRegistos()
    {
        return aRegisto;
    }

    public static void setRegistos(ArrayList<Registo> al)
    {
        aRegisto=al;
    }

    public static void addRegisto(Registo r)
    { aRegisto.add(r); }
}
