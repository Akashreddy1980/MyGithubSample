package com.aimsmart.app.mygithubsample;

import android.content.Context;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.aimsmart.app.mygithubsample.databinding.Customrecycle1Binding;

import java.util.ArrayList;
import java.util.List;

public class Recycle1Adapter extends RecyclerView.Adapter<Recycle1Adapter.RecyclerViewHolder1> {
    Context context;
    List<Repos> repos = new ArrayList<>();
    public Recycle1Adapter(Context context, List<Repos> list){
        this.repos = list;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        Customrecycle1Binding binding = DataBindingUtil.inflate(layoutInflater,R.layout.customrecycle1,parent,false);
        return new RecyclerViewHolder1(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder1 holder, int position) {
         holder.binding.setModel(repos.get(position));
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }
    public class RecyclerViewHolder1 extends RecyclerView.ViewHolder{
Customrecycle1Binding binding;
        public RecyclerViewHolder1(Customrecycle1Binding binding) {
            super(binding.getRoot());
            this.binding =binding;
            binding.setClickhandler(Recycle1Adapter.this);
        }
    }
    public void Onclick(){
        Toast.makeText(context, "Repo deleting", Toast.LENGTH_SHORT).show();
    }
}
