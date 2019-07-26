package com.example.rxretrofitrecyclererest.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.rxretrofitrecyclererest.R;

public class PostViewHolder extends RecyclerView.ViewHolder {
    TextView txt_titlt,txt_author,txt_content;
    public PostViewHolder(@NonNull View itemView) {
        super(itemView);

        txt_titlt = itemView.findViewById(R.id.txt_title);
        txt_author = itemView.findViewById(R.id.txt_author);
        txt_content = itemView.findViewById(R.id.txt_content);
    }
}
