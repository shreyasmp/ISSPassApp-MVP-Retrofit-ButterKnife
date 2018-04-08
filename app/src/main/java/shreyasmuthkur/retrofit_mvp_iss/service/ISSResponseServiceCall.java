package shreyasmuthkur.retrofit_mvp_iss.service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import shreyasmuthkur.retrofit_mvp_iss.utils.AppConstants;

/**
 * Created by shreyasmp on 4/4/18.
 * <p>
 * API for Service call using Retrofit and OKHttp Client for http Logging and caching.
 */

public class ISSResponseServiceCall implements AppConstants {

    private static final String TAG = ISSResponseServiceCall.class.getSimpleName();

    private String BASE_URL = ISS_URL;
    private Retrofit retrofit = null;
    private OkHttpClient okHttpClient = null;
    private HttpLoggingInterceptor httpLoggingInterceptor = null;

    public ISSResponseAPI getClient() {
        httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit.create(ISSResponseAPI.class);
    }
}
