package shreyasmuthkur.retrofit_mvp_iss.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by shreyasmp on 4/3/18.
 *
 * Model for request response
 */

public class RequestModel implements Serializable {

    @SerializedName("altitude")
    private int altitude;

    @SerializedName("datetime")
    private long datetime;

    @SerializedName("latitude")
    private double latitude;

    @SerializedName("longitude")
    private double longitude;

    @SerializedName("passes")
    private int passes;

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getPasses() {
        return passes;
    }

    public void setPasses(int passes) {
        this.passes = passes;
    }
}
