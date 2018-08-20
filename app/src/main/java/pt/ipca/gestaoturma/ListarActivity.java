package pt.ipca.gestaoturma;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ListarActivity extends AppCompatActivity {

    TextView txtnum, txtnom, txtclass, txtstatus;
    int index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);


        Intent intent = getIntent();
        String value1 = intent.getStringExtra("key1");
        String value2 = intent.getStringExtra("key2");

        if(Registos.getRegistos().size() == 0)
        {
            (new AlertDialog.Builder(ListarActivity.this))
                    .setTitle("Aviso")
                    .setMessage("Não existe nenhum registo inserido.")
                    .setNeutralButton("OK", null)
                    .show();
            return;
        }
        else {
            index=0;
            txtnum = (TextView) findViewById(R.id.txtnum);
            txtnom = (TextView) findViewById(R.id.txtnom);
            txtclass = (TextView) findViewById(R.id.txtclass);
            txtstatus = (TextView) findViewById(R.id.txtstatus);
            PreencheCampos(index);
            AtualizaStatus(index);
        }
    }

    private void PreencheCampos(int idx)
    {
        txtnum.setText(Registos.getRegistos().get(idx).getNumero());
        txtnom.setText(Registos.getRegistos().get(idx).getNome());
        txtclass.setText(Registos.getRegistos().get(idx).getClassificação());
    }
    private void AtualizaStatus(int idx)
    {
        int total = Registos.getRegistos().size();
        txtstatus.setText("Registos : " + (idx+1) + "/" + total);
    }

    public void anterior(View v)
    {if(index > 0)
    {
        index--;
        PreencheCampos(index);
        AtualizaStatus(index);
    }
    }

    public void proximo(View v)
    {    if(index < Registos.getRegistos().size() - 1)
    {
        index++;
        PreencheCampos(index);
        AtualizaStatus(index);
    }
    }

    public void fechar(View v)
    {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(ListarActivity.this);
        dialogo.setTitle("Aviso");
        dialogo.setMessage("Sair da listagem?");
        dialogo.setNegativeButton("Não", null);
        dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ListarActivity.this.finish();
            }
        });
        dialogo.show();
    }

}
