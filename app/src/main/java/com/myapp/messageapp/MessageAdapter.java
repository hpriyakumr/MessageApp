package com.myapp.messageapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private ArrayList<MessageList> list;

    public MessageAdapter(ArrayList<MessageList> list) {
       this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_text_single_view,parent,false);
        return new MessageAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MessageList ml = list.get(position);
        holder.textView_Display_text.setText(ml.getMessages());

    }

    public void setData(ArrayList<MessageList> data){
        this.list = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(list != null){
            return list.size();
        } else{
            return 0;
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView_Display_text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           this.textView_Display_text = (TextView) itemView.findViewById(R.id.tv_display_text);
        }
    }
}
