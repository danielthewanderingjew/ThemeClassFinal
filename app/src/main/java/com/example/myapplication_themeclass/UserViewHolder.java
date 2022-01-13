package com.example.myapplication_themeclass;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    public CardView card;
    public ImageView avatar;
    public TextView name;
    public TextView email;

    public UserViewHolder (@NonNull View itemView) {
        super(itemView);

        card = itemView.findViewById(R.id.card);
        avatar = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.name);
        email = itemView.findViewById(R.id.email);
    }
}
