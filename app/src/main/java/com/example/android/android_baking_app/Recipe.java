package com.example.android.android_baking_app;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Recipe implements Parcelable {
    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("ingredients")
    private List<Ingredient> mIngredients = null;

    @SerializedName("steps")
    private List<Step> mSteps = null;

    @SerializedName("servings")
    private int mServings;

    @SerializedName("image")
    private String mImage;

    private Recipe(Parcel in){
        mId = in.readInt();
        mName = in.readString();
        if (in.readByte() == 0x01) {
            mIngredients = new ArrayList<>();
            in.readList(mIngredients, Ingredient.class.getClassLoader());
        } else {
            mIngredients = null;
        }
        if (in.readByte() == 0x01) {
            mSteps = new ArrayList<>();
            in.readList(mSteps, Step.class.getClassLoader());
        } else {
            mSteps = null;
        }
        mServings = in.readInt();
        mImage = in.readString();
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public List<Ingredient> getmIngredients() {
        return mIngredients;
    }

    public void setmIngredients(List<Ingredient> mIngredients) {
        this.mIngredients = mIngredients;
    }

    public List<Step> getmSteps() {
        return mSteps;
    }

    public void setmSteps(List<Step> mSteps) {
        this.mSteps = mSteps;
    }

    public int getmServings() {
        return mServings;
    }

    public void setmServings(int mServings) {
        this.mServings = mServings;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mId);
        parcel.writeString(mName);
        if (mIngredients == null) {
            parcel.writeByte((byte) (0x00));
        } else {
            parcel.writeByte((byte) (0x01));
            parcel.writeList(mIngredients);
        }
        if (mSteps == null) {
            parcel.writeByte((byte) (0x00));
        } else {
            parcel.writeByte((byte) (0x01));
            parcel.writeList(mSteps);
        }
        parcel.writeInt(mServings);
        parcel.writeString(mImage);
    }
}
