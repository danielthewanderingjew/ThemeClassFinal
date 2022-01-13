package com.example.myapplication_themeclass;


import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private List<User> Users;
    public UserAdapter(List<User> users)
    {
        this.Users = users;
    }

    public void AddContact(User user)
    {
        Users.add(user);
        notifyDataSetChanged();
        DataPersistencyHelper.StoreData(Users);
    }

    public void DeleteContact(int position)
    {
        Users.remove(position);
        notifyDataSetChanged();
        DataPersistencyHelper.StoreData(Users);
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.contact,parent,false);
        UserViewHolder vh = new UserViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = Users.get(position);

        holder.avatar.setImageResource(user.getImage());
        holder.name.setText(user.getName());
        holder.email.setText(user.getEmail());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),MainActivity2.class);
                i.putExtra("user",user);
                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) v.getContext(),
                                holder.avatar,
                                "avatarTransition"
                        );
                v.getContext().startActivity(i,options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return Users.size();
    }
}
