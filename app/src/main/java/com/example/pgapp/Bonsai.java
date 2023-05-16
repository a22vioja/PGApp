package com.example.pgapp;
import com.google.gson.annotations.SerializedName;
import android.content.Context;
import android.view.View;

@SuppressWarnings("WeakerAccess")
public class Bonsai extends View {
    @SerializedName("Name")
    private String name;
    @SerializedName("ID")
    private int id;
    @SerializedName("size")
    private String height;
    @SerializedName("cost")
    private int price;

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
        id = Integer.parseInt("No id");
        height = "No height";
        price = 0;
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

}
