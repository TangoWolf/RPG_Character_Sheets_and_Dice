package com.example.shaol.char_sheet;

import android.content.Context;
import android.graphics.Movie;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.shaol.char_sheet.Model.Store;
import com.example.shaol.char_sheet.Utils.NetworkUtils;
import com.example.shaol.char_sheet.Utils.JsonUtils;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.net.URL;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private Store[] mStores;
    private FusedLocationProviderClient mFusedLocationClient;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            double longitude = location.getLongitude();
                            double latitude = location.getLatitude();
                            LatLng here = new LatLng(latitude, longitude);
                            mMap.addMarker(new MarkerOptions().position(here).title(getResources().getString(R.string.current_location)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(here));
                            mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
                            new FetchStoresInfoTask().execute(latitude, longitude);
                        } else {
                            Toast.makeText(MapsActivity.this, R.string.no_location, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public class FetchStoresInfoTask extends AsyncTask<Double, Void, Store[]> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Store[] doInBackground(Double... coordinates) {
            double lat = coordinates[0];
            double lng = coordinates[1];

            URL storeRequestUrl = NetworkUtils.buildUrl(lat, lng);

            try {
                String JsonResponse = NetworkUtils.getResponseFromHttpUrl(storeRequestUrl);

                Store[] storeInfo = JsonUtils.getStoreInfoFromJson(JsonResponse);

                return storeInfo;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Store[] stores) {

            for (Store store : stores) {
                double longitude = store.getLng();
                double latitude = store.getLat();
                LatLng place = new LatLng(latitude, longitude);
                mMap.addMarker(new MarkerOptions().position(place).title(store.getName()));
            }
        }
    }
}
