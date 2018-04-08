package shreyasmuthkur.retrofit_mvp_iss.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by shreyasmp on 4/3/18.
 *
 * Main Model class for response received from the URL
 */

public class MainModel implements Serializable {

    @SerializedName("message")
    private String message;

    @SerializedName("request")
    private RequestModel requestModel;

    @SerializedName("response")
    private ArrayList<ResponseModel> responseModels;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RequestModel getRequestModel() {
        return requestModel;
    }

    public void setRequestModel(RequestModel requestModel) {
        this.requestModel = requestModel;
    }

    public ArrayList<ResponseModel> getResponseModels() {
        return responseModels;
    }

    public void setResponseModels(ArrayList<ResponseModel> responseModels) {
        this.responseModels = responseModels;
    }
}
