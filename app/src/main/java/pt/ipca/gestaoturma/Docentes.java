package pt.ipca.gestaoturma;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.textservice.TextServicesManager;
import android.widget.Button;
import android.widget.EditText;

public class Docentes extends AppCompatActivity {

    Button inserirDocente, cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docentes);

        /*Intent intent = getIntent();
        String value1 = intent.getStringExtra("key1");
        String value2 = intent.getStringExtra("key2");

        EditText et = (EditText) findViewById(R.id.nomeId);
        et.setText(value1 + " " + value2);
        */

        inserirDocente = (Button) findViewById(R.id.inserirID);
        inserirDocente.setOnClickListener( new View.OnClickListener()
                                           {
                                               @Override
                                               public void onClick(View v)
                                               {
                                                   EditText editText1 = (EditText) findViewById(R.id.numeroId);
                                                   String text1 = editText1.getText().toString();
                                                   int numero = Integer.parseInt(text1);

                                                   EditText editText2 = (EditText) findViewById(R.id.nomeId);
                                                   String nome = editText2.getText().toString();

                                                   EditText editText3 = (EditText) findViewById(R.id.unidadeId);
                                                   String unidade = editText3.getText().toString();

                                                   boolean resultado = Teste.inserirDocente(numero,nome, unidade);

                                                   AlertDialog.Builder d = new AlertDialog.Builder(Docentes.this);
                                                   d.setTitle("Informação");
                                                   if (resultado) {
                                                       d.setMessage("Docente inserido!");
                                                       editText1.getText().clear();
                                                       editText2.getText().clear();
                                                       editText3.getText().clear();
                                                       editText1.requestFocus();
                                                   }
                                                   else d.setMessage("Docente não inserido!");
                                                   d.setNeutralButton("OK", null);
                                                   d.show();






                                               }
                                           }
        );

        cancelar = (Button) findViewById(R.id.cancelarID);
        cancelar.setOnClickListener( new View.OnClickListener()
                                     {
                                         @Override
                                         public void onClick(View v)
                                         {
                                             Docentes.this.finish();
                                         }
                                     }
        );

    }
}
