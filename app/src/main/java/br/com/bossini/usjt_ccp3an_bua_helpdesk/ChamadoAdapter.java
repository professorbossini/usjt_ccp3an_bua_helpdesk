package br.com.bossini.usjt_ccp3an_bua_helpdesk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ChamadoAdapter extends ArrayAdapter <Chamado> {

    private List <Chamado> chamados;
    private Context context;
    public ChamadoAdapter (Context context, List<Chamado> chamados){
        super(context, -1, chamados);
        this.chamados = chamados;
        this.context = context;
    }

    @Override
    public int getCount() {
        return chamados.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Chamado chamadoDaVez = getItem(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        View raiz = inflater.inflate(
                R.layout.list_item,
                parent,
                false
        );
        ImageView  filaIconImageView =
                raiz.findViewById(R.id.filaIconImageView);
        TextView descricaoChamadoNaFilaTextView =
                raiz.findViewById(R.id.descricaoChamadoNaFilaTextView);
        TextView statusChamadoNaFilaTextView =
                raiz.findViewById(R.id.statusChamadoNaFilaTextView);
        TextView dataAberturaChamadoNaFilaTextView =
                raiz.findViewById(R.id.dataAberturaChamadoNaFilaTextView);
        TextView dataFechamentoChamadoNaFilaTextView =
                raiz.findViewById(R.id.dataFechamentoChamadoNaFilaTextView);

        filaIconImageView.setImageResource(
                chamadoDaVez.getFila().getIconId()
        );
        descricaoChamadoNaFilaTextView.setText(
                chamadoDaVez.getDescricao()
        );
        statusChamadoNaFilaTextView.setText(
                chamadoDaVez.getStatus()
        );

        dataAberturaChamadoNaFilaTextView.setText(
                DateHelper.format(
                        chamadoDaVez.getDataAbertura()
                )
        );
        if (chamadoDaVez.getDataFechamento() != null)
            dataFechamentoChamadoNaFilaTextView.setText(
                    DateHelper.format(chamadoDaVez.getDataFechamento())
            );

        return raiz;

    }
}
