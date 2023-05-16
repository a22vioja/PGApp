package com.example.pgapp;
import com.google.gson.annotations.SerializedName;
import android.content.Context;
import android.view.View;

@SuppressWarnings("WeakerAccess")
public class Bonsai {
    @SerializedName("Name")
    public String name;
    @SerializedName("ID")
    public String id;
    @SerializedName("size")
    public String height;
    @SerializedName("cost")
    public int price;

    public Bonsai(String name, String id, String height, int price) {
        this.name = name;
        this.id = id;
        this.height = height;
        this.price = price;
    }

    /*
        public Bonsai(String name, String ID, int size, int price, Context context) {
            super(context);
            this.name = name;
            this.id = id;
            this.height = height;
            this.price = price;
        }

        public Bonsai(String s, String i, Context context) {
            super(context);
            name = "No name";
            id = "No id";
            height = "No height";
            price = 0;
        }
    */
    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
