package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    ListView listViewOpcoes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


        this.CriarComponentes();

        this.CriarEventos();


        this.CarregaOpcoesLista();

    }


    protected void CriarEventos() {

        listViewOpcoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String opcaoMenu = ((TextView) view).getText().toString();

                RedirecionaTela(opcaoMenu);


            }
        });
    }

    //REDIRECIONA PARA A TELA SELECIONADA NO MENU
    protected void RedirecionaTela(String opcaoMenu) {

        Intent intentRedirecionar;

        if (opcaoMenu.equals("Cadastrar")) {

            intentRedirecionar = new Intent(this, ConsultarActivity.class);
            startActivity(intentRedirecionar);
            finish();
        } else if (opcaoMenu.equals("Consultar")) {

            intentRedirecionar = new Intent(this, ConsultarActivity.class);
            startActivity(intentRedirecionar);
            finish();
        } else
            Toast.makeText(getApplicationContext(), "Opção inválida!", Toast.LENGTH_SHORT).show();

    }


    //VINCULA O COMPONENTE DA NOSSA TELA AO OBJETO DA NOSSA ATIVIDADE
    protected void CriarComponentes() {

        //VINCULANDO A LISTA DA TELA AO LISTVIEW QUE DECLARAMOS
        listViewOpcoes = (ListView) this.findViewById(R.id.lVOpcoes);
    }

    //CRIA A OPÇÕES DA NOSSA LISTA E ADICIONA AO LISTVIEW DA NOSSA TELA.
    protected void CarregaOpcoesLista() {

        String[] itens = new String[2];

        itens[0] = "Cadastrar";
        itens[1] = "Empresas";

        ArrayAdapter<String> arrayItens = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itens);


        listViewOpcoes.setAdapter(arrayItens);

    }

}