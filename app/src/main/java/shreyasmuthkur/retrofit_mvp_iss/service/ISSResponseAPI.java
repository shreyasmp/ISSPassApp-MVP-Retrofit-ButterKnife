package shreyasmuthkur.retrofit_mvp_iss.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import shreyasmuthkur.retrofit_mvp_iss.model.MainModel;

/**
 * Created by shreyasmp on 4/4/18.
 * <p>
 * Service API interface which has the retrofit callback method that will be implemented in Service Call API class
 */

public interface ISSResponseAPI {

    @GET("iss-pass.json")
    Call<MainModel> getISSCoordinatesForCurrentLoc(@Query("lat") double latitude, @Query("lon") double Longitude);
}
