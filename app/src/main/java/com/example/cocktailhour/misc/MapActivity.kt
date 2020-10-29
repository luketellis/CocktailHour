package com.example.cocktailhour.misc

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cocktailhour.R
import com.example.cocktailhour.entitiy.DrinkLocation
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions


class MapActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        //Add a marker at the provided and move the camera
        initData().forEach{
            mMap.addMarker(
                MarkerOptions()
                    .position(it.coordinates)
                    .title(it.drink)
                    .snippet(it.country)
            )

            mMap.moveCamera(CameraUpdateFactory.newLatLng(it.coordinates))
            mMap.setOnInfoWindowClickListener(this)
        }

    }

    override fun onInfoWindowClick(marker: Marker?) {
        Toast.makeText(this, marker?.title, Toast.LENGTH_SHORT).show()
    }

    private fun initData() : List<DrinkLocation> {
        return listOf(
            DrinkLocation("Mexico", LatLng(19.4326, -99.1332), "Paloma"),
            DrinkLocation("Peru", LatLng(-12.0463, -77.0427), "Pisco Sour"),
            DrinkLocation("Canada", LatLng(45.4215, -75.6972), "Bloody Mary"),
            DrinkLocation("New York", LatLng(40.7306, -73.9452), "New York Sour"),
            DrinkLocation("Brazil", LatLng(-22.9068, -43.1729), "Caipirinha"),
            DrinkLocation("Spain", LatLng(40.73061, -3.7037), "Sangria"),
            DrinkLocation("France", LatLng(49.8566, 2.3522), "French 75"),
            DrinkLocation("England", LatLng(51.5074, 0.1278), "Vesper"),
            DrinkLocation("Russia", LatLng(55.7512, 37.6184), "Black Russian"),
            DrinkLocation("New Zealand", LatLng(-41.2769, 174.7731), "Kiwi Lemon"),
            DrinkLocation("Singapore", LatLng(1.3521, 103.8198), "Singapore Sling"),
            DrinkLocation("Japan", LatLng(35.6762, 139.6503), "Kamikaze"),
            DrinkLocation("Germany", LatLng(52.5200, 13.4050), "Kir Royale"),
            DrinkLocation("Cuba", LatLng(23.6762, -82.6503), "Mojito"),
            DrinkLocation("Jamaica", LatLng(18.1096, -77.2975), "Jamaica Kiss"),
            DrinkLocation("Egypt", LatLng(24.8206, 27.8025), "Jewel Of The Nile"),
            DrinkLocation("Zimbabwe", LatLng(-19.0154, 29.1549), "Negroni")
        )
    }
}