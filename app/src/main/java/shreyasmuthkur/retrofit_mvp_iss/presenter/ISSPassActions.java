package shreyasmuthkur.retrofit_mvp_iss.presenter;

/**
 * Created by shreyasmp on 4/5/18.
 *
 * Actions interface that will be implemented by Presenter class
 */

public interface ISSPassActions {

    void showError();

    void hideError();

    void setLoader();

    void getISSPassCoordinatesList(double lat, double lng);

    void showISSPassCoordinatesList();

}
