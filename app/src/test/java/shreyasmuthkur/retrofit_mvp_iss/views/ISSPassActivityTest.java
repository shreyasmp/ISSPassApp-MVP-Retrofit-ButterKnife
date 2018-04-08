package shreyasmuthkur.retrofit_mvp_iss.views;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import shreyasmuthkur.retrofit_mvp_iss.model.MainModel;
import shreyasmuthkur.retrofit_mvp_iss.presenter.ISSPassPresenter;

import static org.mockito.Mockito.verify;

/**
 * Created by shreyasmp on 4/5/18.
 */

@RunWith(MockitoJUnitRunner.class)
public class ISSPassActivityTest {

    private ISSPassPresenter issPassPresenter;

    @Mock
    private ISSPassView issPassView;

    @Before
    public void setup() throws IOException {
        issPassPresenter = new ISSPassPresenter(issPassView);
    }

    @Test
    public void showError() throws IOException {
        issPassPresenter.showError();

        verify(issPassView).showErrorMessage();
    }

    @Test
    public void hideError() throws IOException {
        issPassPresenter.hideError();

        verify(issPassView).hideErrorMessage();
    }

    @Test
    public void setLoaderTrue() throws IOException {
        issPassPresenter.setLoader();

        verify(issPassView).setLoader(true);
    }

    @Test
    public void setLoaderFalse() throws IOException {
        issPassPresenter.setLoader();

        verify(issPassView).setLoader(false);
    }

    @Test
    public void showISSPassList() throws IOException {
        issPassPresenter.showISSPassCoordinatesList();

        MainModel model = null;
        verify(issPassView).showISSPassResults(model);
    }
}
