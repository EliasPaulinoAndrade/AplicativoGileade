package com.example.eliaspaulino.gileade.adaptadores;

import android.content.Context;
import android.provider.UserDictionary;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eliaspaulino.gileade.R;
import com.example.eliaspaulino.gileade.models.Lider;
import com.example.eliaspaulino.gileade.utilitarios.Buscador;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Elias on 31/10/2017.
 */

public class LideresAdaptador extends RecyclerView.Adapter<PgAdaptador.Segurador> {
    private static final String SERVER_END_POINT = "lideres";

    private ArrayList<Lider> dados;
    private Context ctx;

    public LideresAdaptador(ArrayList<Lider> dados, Context ctx) {
        this.dados = dados;
        this.ctx = ctx;
    }

    @Override
    public PgAdaptador.Segurador onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_item_lideres, parent, false);
        return new PgAdaptador.Segurador(view);
    }

    @Override
    public void onBindViewHolder(PgAdaptador.Segurador holder, final int position) {
        View view = holder.view;
        Buscador<Lider> buscador = new Buscador<>(ctx, SERVER_END_POINT);
        TextView nome = (TextView) view.findViewById(R.id.nome);
        TextView num = (TextView) view.findViewById(R.id.numero);
        CircleImageView imageView = (CircleImageView) view.findViewById(R.id.imagem);
        nome.setText(dados.get(position).getNome().toUpperCase());
        num.setText(dados.get(position).getTelefone().toUpperCase());

        buscador.findImage(dados.get(position).getUrlimagem(), imageView);
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }
    static class Segurador extends RecyclerView.ViewHolder{
        View view;
        public Segurador(View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }
}
