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
        ChamadoViewHolder vh;
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(
                    R.layout.list_item,
                    parent,
                    false
            );
            vh = new ChamadoViewHolder();
            vh.filaIconImageView =
                    convertView.findViewById(R.id.filaIconImageView);
            vh.descricaoChamadoNaFilaTextView =
                    convertView.findViewById(R.id.descricaoChamadoNaFilaTextView);
            vh.statusChamadoNaFilaTextView =
                    convertView.findViewById(R.id.statusChamadoNaFilaTextView);
            vh.dataAberturaChamadoNaFilaTextView =
                    convertView.findViewById(R.id.dataAberturaChamadoNaFilaTextView);
            vh.dataFechamentoChamadoNaFilaTextView =
                    convertView.findViewById(R.id.dataFechamentoChamadoNaFilaTextView);

            convertView.setTag(vh);
        }
        vh = (ChamadoViewHolder) convertView.getTag();
        Chamado chamadoDaVez = getItem(position);



        vh.filaIconImageView.setImageResource(
                chamadoDaVez.getFila().getIconId()
        );
        vh.descricaoChamadoNaFilaTextView.setText(
                chamadoDaVez.getDescricao()
        );
        vh.statusChamadoNaFilaTextView.setText(
                chamadoDaVez.getStatus()
        );

        vh.dataAberturaChamadoNaFilaTextView.setText(
                DateHelper.format(
                        chamadoDaVez.getDataAbertura()
                )
        );
        if (chamadoDaVez.getDataFechamento() != null)
            vh.dataFechamentoChamadoNaFilaTextView.setText(
                    DateHelper.format(chamadoDaVez.getDataFechamento())
            );

        return convertView;

    }

    private class ChamadoViewHolder {
        public ImageView filaIconImageView;
        public TextView descricaoChamadoNaFilaTextView;
        public TextView statusChamadoNaFilaTextView;
        public TextView dataAberturaChamadoNaFilaTextView;
        public TextView dataFechamentoChamadoNaFilaTextView;
    }
}
