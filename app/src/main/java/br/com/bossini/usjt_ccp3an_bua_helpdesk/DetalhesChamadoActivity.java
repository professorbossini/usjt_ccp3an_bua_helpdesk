package br.com.bossini.usjt_ccp3an_bua_helpdesk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalhesChamadoActivity extends AppCompatActivity {

    private TextView descricaoChamadoTextView;
    private TextView nomeFilaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_chamado);
        descricaoChamadoTextView =
                findViewById(R.id.descricaoChamadoTextView);
        nomeFilaTextView =
                findViewById(R.id.nomeFilaTextView);
        Intent origemIntent = getIntent();
        String chamadoSelecionado =
                origemIntent.getStringExtra("chamado_selecionado");
        String [] partes = chamadoSelecionado.split(":");
        String nomeFila = partes[0];
        String descricaoChamado = partes[1];
        nomeFilaTextView.setText(nomeFila);
        descricaoChamadoTextView.setText(descricaoChamado);
    }
}
