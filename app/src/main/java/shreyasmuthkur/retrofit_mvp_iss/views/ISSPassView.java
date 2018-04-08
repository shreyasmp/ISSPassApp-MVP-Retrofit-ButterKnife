package shreyasmuthkur.retrofit_mvp_iss.views;

import shreyasmuthkur.retrofit_mvp_iss.model.MainModel;

/**
 * Created by shreyasmp on 4/5/18.
 * <p>
 * View interface which is implemented by Activity allowing loose coupling of UI with Presenter
 */

public interface ISSPassView {

    void setLoader(boolean loader);

    void showErrorMessage();

    void hideErrorMessage();

    void showISSPassResults(MainModel model);
}
