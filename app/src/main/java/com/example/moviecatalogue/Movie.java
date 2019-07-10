package com.example.moviecatalogue;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int photo;
    private String title, ratings, description, directed, produced, screenplay, basedOn, starring, music, cinematography, edited, productionCompanies, distributed, runningTime, releaseDate;

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirected() {
        return directed;
    }

    public void setDirected(String directed) {
        this.directed = directed;
    }

    public String getProduced() {
        return produced;
    }

    public void setProduced(String produced) {
        this.produced = produced;
    }

    public String getScreenplay() {
        return screenplay;
    }

    public void setScreenplay(String screenplay) {
        this.screenplay = screenplay;
    }

    public String getBasedOn() {
        return basedOn;
    }

    public void setBasedOn(String basedOn) {
        this.basedOn = basedOn;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getCinematography() {
        return cinematography;
    }

    public void setCinematography(String cinematography) {
        this.cinematography = cinematography;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(String productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public String getDistributed() {
        return distributed;
    }

    public void setDistributed(String distributed) {
        this.distributed = distributed;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Movie() {
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photo);
        dest.writeString(this.title);
        dest.writeString(this.ratings);
        dest.writeString(this.description);
        dest.writeString(this.directed);
        dest.writeString(this.produced);
        dest.writeString(this.screenplay);
        dest.writeString(this.basedOn);
        dest.writeString(this.starring);
        dest.writeString(this.music);
        dest.writeString(this.cinematography);
        dest.writeString(this.edited);
        dest.writeString(this.productionCompanies);
        dest.writeString(this.distributed);
        dest.writeString(this.runningTime);
        dest.writeString(this.releaseDate);
    }

    protected Movie(Parcel in) {
        this.photo = in.readInt();
        this.title = in.readString();
        this.ratings = in.readString();
        this.description = in.readString();
        this.directed = in.readString();
        this.produced = in.readString();
        this.screenplay = in.readString();
        this.basedOn = in.readString();
        this.starring = in.readString();
        this.music = in.readString();
        this.cinematography = in.readString();
        this.edited = in.readString();
        this.productionCompanies = in.readString();
        this.distributed = in.readString();
        this.runningTime = in.readString();
        this.releaseDate = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
