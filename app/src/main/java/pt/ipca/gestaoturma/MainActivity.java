package pt.ipca.gestaoturma;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Variaveis de Instancia
    Button inserir, listar, inserirDocente, consultarDocente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inserirDocente = (Button) findViewById(R.id.docenteID);
        inserirDocente.setOnClickListener( new View.OnClickListener()
                                           {
                                               @Override
                                               public void onClick(View v)
                                               {
                                                   Intent intent = new Intent(v.getContext(), Docentes.class);
                                                   intent.putExtra("key1", "value1");
                                                   intent.putExtra("key2", "value2");
                                                   startActivity(intent);
                                               }
                                           }
        );

        consultarDocente = (Button) findViewById(R.id.bt_ConsultarDocente);
        consultarDocente.setOnClickListener( new View.OnClickListener()
                                             {
                                                 @Override
                                                 public void onClick(View v)
                                                 {
                                                     Intent intent = new Intent(v.getContext(), ConsultarDocente.class);
                                                     intent.putExtra("key1", "value1");
                                                     intent.putExtra("key2", "value2");
                                                     startActivity(intent);
                                                 }
                                             }
        );

        inserir = (Button) findViewById(R.id.bt_inserir_alunos);
        inserir.setOnClickListener( new View.OnClickListener()
                                    {   @Override
                                    public void onClick(View v)
                                    {
                                        Intent intent = new Intent(v.getContext(), InserirActivity.class);
                                        startActivity(intent);
                                    }
                                    }
        );


        // Obtenção do endereço de memória do objecto do tipo TextView presente
        // na actividade com id 'textView'
        TextView tv = (TextView) findViewById(R.id.textView);
        String resultado = Teste.teste1();
        tv.setText( String.valueOf(Teste.testarIgual()));

    }
    /*
        public void startInserirActivity(View view) {
            Intent intent = new Intent(this, InserirActivity.class);
            intent.putExtra("key1", "value1");
            intent.putExtra("key2", "value2");
            startActivity(intent);
        }
    */
    public void startListarActivity(View view) {
        Intent intent = new Intent(this, ListarActivity.class);
        intent.putExtra("key1", "value1");
        intent.putExtra("key2", "value2");
        startActivity(intent);
    }

    public void carregar(View v)
    {
        ArrayList<Registo> dados = Serializacao.read(this.getApplicationContext(),"dados");
        if (dados!=null) Registos.setRegistos(dados);
        else {
            AlertDialog.Builder d = new AlertDialog.Builder(MainActivity.this);
            d.setTitle("Aviso");
            d.setMessage("Erro ao ler o fichero!");
            d.setNeutralButton("OK", null);
            d.show();
        }
    }

    public void guardar(View v)
    {
        Serializacao.save(this.getApplicationContext(),Registos.getRegistos(),"dados");
    }

    public void encerrar(View v)
    {
        this.finish();
    }
}
