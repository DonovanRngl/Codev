package com.example.proyectov2.cosasrecycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectov2.R;
import com.example.proyectov2.models.modelo;

import java.util.List;

public class adaptator extends  RecyclerView.Adapter<adaptator.ViewHolder>{
    private List<modelo> ListModel;
    private LayoutInflater inflater;
    private Context context;
    final adaptator.OnItemClickListener listener;

    public adaptator(List<modelo> listModel, Context context, adaptator.OnItemClickListener listener) {
        this.ListModel = listModel;
        this.inflater=LayoutInflater.from(context);
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public adaptator.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item, null);
        return new adaptator.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adaptator.ViewHolder holder, int position) {
        holder.binData(ListModel.get(position));
    }

    @Override
    public int getItemCount() {
        return ListModel.size();
    }

    public interface OnItemClickListener {
        void OnItemClick(adaptator item);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView Nombre;
        Intent I;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Nombre=itemView.findViewById(R.id.sensor);
            itemView.setOnClickListener(this);
        }

        public void binData(modelo modelo) {
            Nombre.setText(modelo.getNombre());
            I=modelo.getAccion();
        }
        @Override
        public void onClick(View v) {
            v.getContext().startActivity(I);
        }


    }
}
