package pt.ipca.gestaoturma;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConsultarDocente extends AppCompatActivity {

    Button cancelar, consultarDocente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_docente);

        consultarDocente = (Button) findViewById(R.id.bConsultar);
        consultarDocente.setOnClickListener( new View.OnClickListener()
                                             {
                                                 @Override
                                                 public void onClick(View v)
                                                 {
                                                     EditText editText1 = (EditText) findViewById(R.id.IdDocente);
                                                     String text1 = editText1.getText().toString();
                                                     int numero = Integer.parseInt(text1);

                                                     String resultado = Teste.consultarDocente(numero);
                                                     AlertDialog.Builder d = new AlertDialog.Builder(ConsultarDocente.this);
                                                     d.setTitle("Informação");
                                                     if (resultado!="") {
                                                         d.setMessage(resultado);
                                                         editText1.getText().clear();
                                                         editText1.requestFocus();
                                                     }
                                                     else d.setMessage("Docente não existente!");
                                                     d.setNeutralButton("OK", null);
                                                     d.show();
                                                 }
                                             }
        );



        cancelar = (Button) findViewById(R.id.bCancelar);
        cancelar.setOnClickListener( new View.OnClickListener()
                                     {
                                         @Override
                                         public void onClick(View v)
                                         {
                                             ConsultarDocente.this.finish();
                                         }
                                     }
        );
    }
}
