package com.example.cocktailhour

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cocktailhour.entitiy.DrinkLocation
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapActivity : AppCompatActivity(), OnMapReadyCallback {
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

        // Add a marker in Sydney and move the camera
        //val sydney = LatLng(-34.0, 151.0)
        initData().forEach{
            mMap.addMarker(MarkerOptions().position(it.coordinates).title(it.country))
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(it.coordinates))
        }
    }

    private fun initData() : List<DrinkLocation> {
        return listOf(
            DrinkLocation("Mexico", LatLng(19.4326, 99.1332), "Paloma"),
            DrinkLocation("Canada", LatLng(45.4215, 75.6972), "Bloody Mary"),
            DrinkLocation("Brazil", LatLng(22.9068, 43.1729), "Caipirinha"),
            DrinkLocation("Spain", LatLng(19.4326, 99.1332), "Sangria"),
            DrinkLocation("France", LatLng(48.8566, 2.3522), "French 75"),
            DrinkLocation("England", LatLng(51.5074, 0.1278), "Vesper"),
            DrinkLocation("New Zealand", LatLng(41.2769, 174.7731), "Kiwi Lemon"),
            DrinkLocation("Singapore", LatLng(1.3521, 103.8198), "Singapore Sling"),
            DrinkLocation("Japan", LatLng(35.6762, 139.6503), "Kamikaze"),
            DrinkLocation("Germany", LatLng(.5200, 13.4050), "Kir Royale"),
            DrinkLocation("Cuba", LatLng(35.6762, 139.6503), "Mojito"),
            DrinkLocation("Jamaica", LatLng(18.1096, 77.2975), "Jamaica Kiss"),
            DrinkLocation("Egypt", LatLng(26.8206, 30.8025), "Jewel Of The Nile"),
            DrinkLocation("Zimbabwe", LatLng(19.0154, 29.1549), "Negroni"))
    }
}