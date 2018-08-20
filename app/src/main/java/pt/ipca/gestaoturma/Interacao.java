package pt.ipca.gestaoturma;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by jcsil on 06/10/2016.
 */

public class Interacao {

    public static void ExibirMensagem(String msg, AppCompatActivity v) {
        AlertDialog.Builder d = new AlertDialog.Builder(v);
        d.setTitle("Aviso");
        d.setMessage(msg);
        d.setNeutralButton("OK", null);
        d.show();
    }
}
