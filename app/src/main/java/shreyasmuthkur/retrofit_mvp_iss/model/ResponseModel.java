package shreyasmuthkur.retrofit_mvp_iss.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by shreyasmp on 4/4/18.
 * <p>
 * Model for Response received
 */

public class ResponseModel implements Serializable {

    @SerializedName("duration")
    private int duration;

    @SerializedName("risetime")
    private long risetime;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public long getRisetime() {
        return risetime;
    }

    public void setRisetime(long risetime) {
        this.risetime = risetime;
    }
}
