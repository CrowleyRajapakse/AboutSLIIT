package com.fsociety2.aboutsliit;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Location extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap mGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (googleServicesAvailable()) {
            setContentView(R.layout.activity_location);
            initMap();
        } else {

        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Location");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
    }

    public void initMap() {
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);
    }

    public boolean googleServicesAvailable() {
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvaialable = api.isGooglePlayServicesAvailable(this);
        if (isAvaialable == ConnectionResult.SUCCESS) {
            return true;
        } else if (api.isUserResolvableError(isAvaialable)) {
            Dialog dialog = api.getErrorDialog(this, isAvaialable, 0);
            dialog.show();
        } else {
            Toast.makeText(this, "Can't connect to play services", Toast.LENGTH_LONG).show();
        }
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        goToLocationZoom(6.914767, 79.972513, 17);
        LatLng sliit = new LatLng(6.914767, 79.972513);
        mGoogleMap.addMarker(new MarkerOptions().position(sliit).title("Marker in SLIIT"));
    }

    public void goToLocation(double lat, double lng) {
        LatLng l1 = new LatLng(lat, lng);
        CameraUpdate update = CameraUpdateFactory.newLatLng(l1);
        mGoogleMap.moveCamera(update);
    }

    public void goToLocationZoom(double lat, double lng, float zoom) {
        LatLng l1 = new LatLng(lat, lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(l1, zoom);
        mGoogleMap.moveCamera(update);
    }
}
