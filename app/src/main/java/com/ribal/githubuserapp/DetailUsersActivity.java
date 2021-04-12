package com.ribal.githubuserapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailUsersActivity extends AppCompatActivity {

    String name, username, company, repo, following, followers, location;
    int img;

    public static final String EXTRA_USER = "test_extra_user";

    TextView tvName, tvUserName, tvCompany, tvRepo, tvFollowing, tvFollowers, tvLocation;

    ImageView imgAva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_users);
        tvName = findViewById(R.id.tv_name_prof);
        tvUserName = findViewById(R.id.tv_username_prof);
        tvCompany = findViewById(R.id.tv_company_info);
        tvRepo = findViewById(R.id.tv_repo_info);
        tvFollowing = findViewById(R.id.tV_following);
        tvFollowers = findViewById(R.id.tV_followers);
        tvLocation = findViewById(R.id.tv_loc_Info);
        imgAva = findViewById(R.id.iv_picture);

        Users user = getIntent().getParcelableExtra(EXTRA_USER);
        if (user != null) {
            username = user.getUsername();
            name = user.getName();
            company = user.getCompany();
            repo = user.getRepository();
            following = user.getFollowing();
            followers = user.getFollowers();
            location = user.getLocation();
            img = user.getAvatar();
        }

        tvUserName.setText(username);
        tvName.setText(name);
        tvCompany.setText(company);
        tvRepo.setText(repo);
        tvFollowing.setText(following);
        tvFollowers.setText(followers);
        tvLocation.setText(location);
        imgAva.setImageResource(img);


    }
}