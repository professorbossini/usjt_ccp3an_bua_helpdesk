package br.com.bossini.usjt_ccp3an_bua_helpdesk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListaChamadosActivity extends AppCompatActivity {

    private ListView chamadosListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_chamados);
        chamadosListView = findViewById(R.id.chamadosListView);
        Intent origemIntent = getIntent();
        String nomeFila = origemIntent.getStringExtra("nome_fila");
        List <String> chamados = busca (nomeFila);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                chamados
        );
        chamadosListView.setAdapter(adapter);
        /*chamadosListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

            }
        });*/
        chamadosListView.setOnItemClickListener((adapterView, view, position, id) -> {
            String chamadoSelecionado = chamados.get(position);
            Intent intent =
                    new Intent (this, DetalhesChamadoActivity.class);
            intent.putExtra("chamado_selecionado", chamadoSelecionado);
            startActivity(intent);
        });
    }

    public List <String> busca (String nomeFila){
        List <String> baseInteira = geraListaChamados();
        if (nomeFila == null || nomeFila.isEmpty()){
            return baseInteira;
        }
        List <String> resultado = new LinkedList<>();
        for (String chamado : baseInteira){
            if (chamado.toLowerCase().contains(nomeFila.toLowerCase()))
                resultado.add(chamado);
        }
        return resultado;
    }
    public List<String> geraListaChamados(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Desktops: Computador da secretária quebrado.");
        lista.add("Telefonia: Telefone não funciona.");
        lista.add("Redes: Manutenção no proxy.");
        lista.add("Servidores: Lentidão generalizada.");
        lista.add("Novos Projetos: CRM");
        lista.add("Manutenção Sistema ERP: atualizar versão.");
        lista.add("Novos Projetos: Rede MPLS");
        lista.add("Manutenção Sistema de Vendas: incluir pipeline.");
        lista.add("Manutenção Sistema ERP: erro contábil");
        lista.add("Novos Projetos: Gestão de Orçamento");
        lista.add("Novos Projetos: Big Data");
        lista.add("Redes: Internet com lentidão");
        lista.add("Novos Projetos: Chatbot");
        lista.add("Desktops: troca de senha");
        lista.add("Desktops: falha no Windows");
        lista.add("Novos Projetos: ITIL V3");
        lista.add("Telefonia: liberar celular");
        lista.add("Telefonia: mover ramal");
        lista.add("Redes: ponto com defeito");
        lista.add("Novos Projetos: ferramenta EMM");
        return lista;
    }
}
