package com.example.codigoplataforma.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codigoplataforma.Dashboard.Landing_Page;
import com.example.codigoplataforma.R;

import java.util.ArrayList;

public class RecyclerView_adapter extends RecyclerView.Adapter<RecyclerView_adapter.Viewholder> {
    ArrayList<Domain_RecyclerView_Datamodel> domain_names;
    String[] domainNames;

    public RecyclerView_adapter(String[] domain_names, Landing_Page landingPage) {
        this.domainNames = domain_names;
    }

    // it fetches data which i provided in the datamodel which itself got data from landing page.java

    public void Recyclerview_adapter(ArrayList<Domain_RecyclerView_Datamodel> domain_names, Landing_Page landingPage) {
        this.domain_names = domain_names;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cardview_for_domain_section, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.name.setText(domainNames[position]);
    }

    @Override
    public int getItemCount() {
        return domainNames.length;
    }

    public static class Viewholder extends RecyclerView.ViewHolder{
        TextView name;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.domain_name);
        }
    }
}
