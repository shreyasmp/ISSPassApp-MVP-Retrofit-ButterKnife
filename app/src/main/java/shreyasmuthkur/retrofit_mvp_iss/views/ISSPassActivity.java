package shreyasmuthkur.retrofit_mvp_iss.views;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import shreyasmuthkur.retrofit_mvp_iss.R;
import shreyasmuthkur.retrofit_mvp_iss.adapter.ISSPassListAdapter;
import shreyasmuthkur.retrofit_mvp_iss.databinding.ActivityIssPassCoordinateListBinding;
import shreyasmuthkur.retrofit_mvp_iss.idling.EspressoIdling;
import shreyasmuthkur.retrofit_mvp_iss.model.MainModel;
import shreyasmuthkur.retrofit_mvp_iss.presenter.ISSPassActions;
import shreyasmuthkur.retrofit_mvp_iss.presenter.ISSPassPresenter;
import shreyasmuthkur.retrofit_mvp_iss.utils.AppConstants;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 *  Created by shreyasmp on 4/5/18.
 *
 *  Main Activity and only Activity of the app which has the views and presenter call.
 *  The View also has the logic to get the current Lat/Lng coordinates and send the coordinates to Presenter.
 *  The ISS Pass coordinates received as a List is then displayed using the recycler View Adapter
 */

public class ISSPassActivity extends AppCompatActivity implements ISSPassView, AppConstants, LocationListener {

    private static final String TAG = ISSPassActivity.class.getSimpleName();

    private ActivityIssPassCoordinateListBinding binding;
    private ISSPassListAdapter issPassListAdapter;
    private ISSPassActions issPassActions;
    private LocationManager locationManager;
    private String mProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        issPassActions = new ISSPassPresenter(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_iss_pass_coordinate_list);

        initViews();
    }

    private void initViews() {
        binding.issPassList.setVisibility(View.VISIBLE);
        binding.getCurrentGpsButton.setVisibility(View.VISIBLE);
        binding.yourLatitudeLabel.setVisibility(View.VISIBLE);
        binding.yourLongitudeLabel.setVisibility(View.VISIBLE);
        binding.yourLatitude.setVisibility(View.VISIBLE);
        binding.yourLongitude.setVisibility(View.VISIBLE);

        binding.progressBar.setVisibility(View.GONE);
        binding.serviceErrorMessage.setVisibility(View.GONE);

        binding.getCurrentGpsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLocationChange();
            }
        });
    }

    private void onLocationChange() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();

        mProvider = locationManager.getBestProvider(criteria, false);
        if (null != mProvider && !mProvider.equals("")) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            Location location = locationManager.getLastKnownLocation(mProvider);
            locationManager.requestLocationUpdates(mProvider, LOCATION_MIN_UPDATE_TIME, LOCATION_MiN_UPDATE_DISTANCE, this);

            if (location != null) {
                issPassActions.getISSPassCoordinatesList(location.getLatitude(), location.getLongitude());
                onLocationChanged(location);
            } else {
                issPassActions.showError();
            }
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        binding.yourLatitude.setText(String.valueOf(location.getLatitude()));
        binding.yourLongitude.setText(String.valueOf(location.getLongitude()));
    }

    @Override
    public void setLoader(boolean loader) {
        if (loader) {
            binding.progressBar.setVisibility(View.VISIBLE);
        } else {
            binding.progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showErrorMessage() {
        binding.serviceErrorMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorMessage() {
        binding.serviceErrorMessage.setVisibility(View.GONE);
    }

    @Override
    public void showISSPassResults(MainModel model) {

        RecyclerView.LayoutManager lmmanager = new LinearLayoutManager(getApplicationContext());
        binding.issPassList.setLayoutManager(lmmanager);
        DividerItemDecoration itemDecor = new DividerItemDecoration(binding.issPassList.getContext(), VERTICAL);
        binding.issPassList.addItemDecoration(itemDecor);

        binding.issPassList.setHasFixedSize(true);
        issPassListAdapter = new ISSPassListAdapter(this, model.getResponseModels());
        binding.issPassList.setAdapter(issPassListAdapter);
        issPassListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @VisibleForTesting
    public IdlingResource getIdlingResource() {
        return EspressoIdling.getIdlingResource();
    }
}
