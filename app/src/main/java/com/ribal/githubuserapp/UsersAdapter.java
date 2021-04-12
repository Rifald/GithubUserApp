package com.ribal.githubuserapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class UsersAdapter  extends BaseAdapter {
    private Context context;
    private ArrayList<Users> users;

    public void setUsers(ArrayList<Users> users) {
        this.users = users;
    }

    public UsersAdapter(Context context) {
        this.context = context;
        users = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Users user = (Users) getItem(i);
        viewHolder.bind(user);
        return view;

    }

    private class ViewHolder {
        private TextView tvName, tvLocation;
        private ImageView imgAva;

        ViewHolder(View view) {
            tvName = view.findViewById(R.id.tv_name);
            tvLocation = view.findViewById(R.id.tv_loc);
            imgAva = view.findViewById(R.id.iv_picture);

        }

        void bind(Users user) {
            tvName.setText(user.getName());
            tvLocation.setText(user.getLocation());
            imgAva.setImageResource(user.getAvatar());

        }
    }
}
