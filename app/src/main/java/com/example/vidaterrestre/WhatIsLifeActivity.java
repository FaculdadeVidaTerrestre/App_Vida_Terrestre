package com.example.vidaterrestre;

import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.geojson.GeoJsonLayer;
import com.google.maps.android.geojson.GeoJsonPolygonStyle;

import org.json.JSONException;

import java.io.IOException;

public class WhatIsLifeActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    MarkerOptions markerOptions;
    Marker mCurrLocationMarker;
    GoogleApiClient mGoogleApiClient;
    boolean mLocationPermissionGranted = true;
    public static final int MY_PERMISSION_REQUEST_LOCATION = 99;
    Location mLastKnowLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whatislife_activity);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        LatLng brazilCenter = new LatLng(-14.2350, -51.9253); // Coordinates for Brazil's center
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(brazilCenter, 4)); // Zoom level 4 to cover the whole country

        try {
            GeoJsonLayer layer = new GeoJsonLayer(mMap, R.raw.states, this);
            GeoJsonPolygonStyle polygonStyle = layer.getDefaultPolygonStyle();
            polygonStyle.setStrokeColor(Color.BLUE);
            polygonStyle.setStrokeWidth(10);
            layer.addLayerToMap();
        } catch (IOException | JSONException ignored) {
        }
        updateLocationUI();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
    }

    private void updateLocationUI() {
    }
}
