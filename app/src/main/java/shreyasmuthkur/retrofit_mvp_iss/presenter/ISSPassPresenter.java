package shreyasmuthkur.retrofit_mvp_iss.presenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import shreyasmuthkur.retrofit_mvp_iss.idling.EspressoIdling;
import shreyasmuthkur.retrofit_mvp_iss.model.MainModel;
import shreyasmuthkur.retrofit_mvp_iss.service.ISSResponseServiceCall;
import shreyasmuthkur.retrofit_mvp_iss.views.ISSPassView;

/**
 * Created by shreyasmp on 4/5/18.
 * <p>
 * Presenter class for all the business logic and the service calls for the ISS Pass
 */

public class ISSPassPresenter implements ISSPassActions {

    private static final String TAG = ISSPassPresenter.class.getSimpleName();
    private final ISSPassView issPassView;
    private final ISSResponseServiceCall serviceCall;

    private MainModel model;

    public ISSPassPresenter(ISSPassView issPassView) {
        this.issPassView = issPassView;
        this.serviceCall = new ISSResponseServiceCall();
    }

    /**
     * Method that does the service call when presenter is passed with the lat and lng coordinates of given location
     * from View
     *
     * @param lat
     * @param lng
     */

    @Override
    public void getISSPassCoordinatesList(double lat, double lng) {
        issPassView.setLoader(true);
        issPassView.hideErrorMessage();

        // Informing espresso that network call is triggered
        EspressoIdling.incrementCounter();

        // Service API from Retrofit
        serviceCall.getClient()
                .getISSCoordinatesForCurrentLoc(lat, lng)
                .enqueue(new Callback<MainModel>() {
                    @Override
                    public void onResponse(Call<MainModel> call, Response<MainModel> response) {

                        // decrementing counter for idle resource time
                        EspressoIdling.decrementCounter();

                        model = response.body();
                        if (null == model.getResponseModels()) {
                            issPassView.setLoader(false);
                            issPassView.showErrorMessage();
                        } else {
                            issPassView.setLoader(false);
                            issPassView.showISSPassResults(model);
                        }
                    }

                    @Override
                    public void onFailure(Call<MainModel> call, Throwable t) {
                        issPassView.setLoader(false);
                        issPassView.showErrorMessage();
                    }
                });
    }

    @Override
    public void showISSPassCoordinatesList() {
        issPassView.showISSPassResults(model);
    }

    @Override
    public void showError() {
        issPassView.showErrorMessage();
    }

    @Override
    public void hideError() {
        issPassView.hideErrorMessage();
    }

    @Override
    public void setLoader() {
        issPassView.setLoader(true);
        issPassView.setLoader(false);
    }
}
