package com.example.movielistt;

import android.os.Parcel;
import android.os.Parcelable;

public class MusicModel implements Parcelable {
    private int postermc;
    private String titlemc;
    private String artis;

    protected MusicModel(Parcel in) {
        postermc = in.readInt();
        titlemc = in.readString();
        artis = in.readString();
    }

    public static final Creator<MusicModel> CREATOR = new Creator<MusicModel>() {
        @Override
        public MusicModel createFromParcel(Parcel in) {
            return new MusicModel(in);
        }

        @Override
        public MusicModel[] newArray(int size) {
            return new MusicModel[size];
        }
    };

    public MusicModel() {

    }

    public int getPoster() {
        return postermc;
    }

    public void setPoster(int poster) {
        this.postermc = poster;
    }

    public String getTitle() {
        return titlemc;
    }

    public void setTitle(String title) {
        this.titlemc = title;
    }

    public String getArtis() {
        return artis;
    }

    public void setArtis(String artis) {
        this.artis = artis;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(postermc);
        dest.writeString(titlemc);
        dest.writeString(artis);
    }
}

