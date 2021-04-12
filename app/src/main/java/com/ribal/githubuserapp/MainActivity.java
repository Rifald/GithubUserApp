package com.ribal.githubuserapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private UsersAdapter adapter;
    private String[] userUsername, userName, userLocation, userRepository, userCompany, userFollowing, userFollowers;
    private TypedArray userAvatar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new UsersAdapter(this);
        ListView listView = findViewById(R.id.lv_users);
        listView.setAdapter(adapter);

        dataDummy();

        ArrayList<Users> users = new ArrayList<>();

        for (int i = 0; i < userName.length; i++) {
            Users user = new Users();
            user.setAvatar(userAvatar.getResourceId(i, -1));
            user.setName(userName[i]);
            user.setLocation(userLocation[i]);
            user.setRepository(userRepository[i]);
            user.setUsername(userUsername[i]);
            user.setFollowing(userFollowing[i]);
            user.setCompany(userCompany[i]);
            user.setFollowers(userFollowers[i]);
            users.add(user);
        }
        adapter.setUsers(users);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailUsersActivity.class);

                ArrayList<Users> users = new ArrayList<Users>();

                Users user = new Users();
                user.setAvatar(userAvatar.getResourceId(i, -1));
                user.setName(userName[i]);
                user.setLocation(userLocation[i]);
                user.setRepository(userRepository[i]);
                user.setUsername(userUsername[i]);
                user.setFollowing(userFollowing[i]);
                user.setCompany(userCompany[i]);
                user.setFollowers(userFollowers[i]);
                users.add(user);

                intent.putParcelableArrayListExtra(DetailUsersActivity.EXTRA_USER, users);
                intent.putExtra(DetailUsersActivity.EXTRA_USER, user);
                startActivity(intent);
            }
        });

    }

    private void dataDummy() {
        userUsername = getResources().getStringArray(R.array.username);
        userName = getResources().getStringArray(R.array.name);
        userLocation = getResources().getStringArray(R.array.location);
        userRepository = getResources().getStringArray(R.array.repository);
        userCompany = getResources().getStringArray(R.array.company);
        userFollowers = getResources().getStringArray(R.array.followers);
        userFollowing = getResources().getStringArray(R.array.following);
        userAvatar = getResources().obtainTypedArray(R.array.avatar);

    }
}