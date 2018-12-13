package com.example.jenique.proximity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;


public class ExpandableListAdapter extends RecyclerView.Adapter<ExpandableListAdapter.ViewHolder>{

    public List<Event> eventList;

    public ExpandableListAdapter(List<Event> eventList){
        this.eventList = eventList;
    };

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nameText.setText(eventList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        View mView;

        public TextView nameText;

        public ViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

//            nameText = (TextView) mView.findViewById(R.id.eventList);
        }
    }
}
