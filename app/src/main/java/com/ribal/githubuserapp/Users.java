package com.ribal.githubuserapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Users implements Parcelable {
    private String username;
    private String name;
    private String location;
    private String repository;
    private String company;
    private String followers;
    private String following;
    private int avatar;

    public Users() {
    }

    public Users(String username, String name, String location, String repository, String company, String followers, String following, int avatar) {
        this.username = username;
        this.name = name;
        this.location = location;
        this.repository = repository;
        this.company = company;
        this.followers = followers;
        this.following = following;
        this.avatar = avatar;
    }

    protected Users(Parcel in) {
        username = in.readString();
        name = in.readString();
        location = in.readString();
        repository = in.readString();
        company = in.readString();
        followers = in.readString();
        following = in.readString();
        avatar = in.readInt();
    }

    public static final Creator<Users> CREATOR = new Creator<Users>() {
        @Override
        public Users createFromParcel(Parcel in) {
            return new Users(in);
        }

        @Override
        public Users[] newArray(int size) {
            return new Users[size];
        }
    };

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeString(this.name);
        parcel.writeString(this.location);
        parcel.writeString(this.repository);

        parcel.writeString(this.company);

        parcel.writeString(this.followers);
        parcel.writeString(this.following);

        parcel.writeInt(this.avatar);
    }
}
