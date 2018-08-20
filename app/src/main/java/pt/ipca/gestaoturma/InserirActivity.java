package pt.ipca.gestaoturma;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InserirActivity extends AppCompatActivity {

    EditText ednum,ednom, edclass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir);

        Intent intent = getIntent();
        final String value1 = intent.getStringExtra("key1");
        final String value2 = intent.getStringExtra("key2");


        ednum = (EditText) findViewById(R.id.ednum);
        ednom = (EditText) findViewById(R.id.ednom);
        edclass = (EditText) findViewById(R.id.edclass);

    }

    public void inserirAluno(View v) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(InserirActivity.this);
        dialogo.setTitle("Aviso");
        dialogo.setMessage("Inserir aluno?");
        dialogo.setNegativeButton("Não", null);
        dialogo.setPositiveButton("Sim", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String num = ednum.getText().toString();
                        String nom = ednom.getText().toString();
                        String clas = edclass.getText().toString();
                        Registos.addRegisto(new Registo(num, nom, clas));
                        AlertDialog.Builder d = new AlertDialog.Builder(InserirActivity.this);
                        d.setTitle("Aviso");
                        d.setMessage("Registo inserido!");
                        d.setNeutralButton("OK", null);
                        d.show();
                        ednum.getText().clear();
                        ednom.getText().clear();
                        edclass.getText().clear();
                    }
                });
        dialogo.show();
    }

    public void cancelar(View v)
    { InserirActivity.this.finish(); }
}
