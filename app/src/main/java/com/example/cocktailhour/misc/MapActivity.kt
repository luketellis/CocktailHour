package com.example.cocktailhour.misc

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModelProvider
import com.example.cocktailhour.R
import com.example.cocktailhour.drink.DrinkViewModel
import com.example.cocktailhour.drink.details.DrinkDetailsActivity
import com.example.cocktailhour.entitiy.Drink
import com.example.cocktailhour.entitiy.DrinkLocationDTO
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions


class MapActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {
    private lateinit var mMap: GoogleMap
    private lateinit var drinkViewModel: DrinkViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        drinkViewModel = ViewModelProvider(this).get(DrinkViewModel::class.java)


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
        openDetailsActivity()
    }

    private fun openDetailsActivity() {
        /*val intent = Intent(this, DrinkDetailsActivity::class.java)
        var drink: LiveData<Drink> = drinkViewModel.getDrinkById(40)


        intent.putExtra("drink", drink)
        startActivity(intent)*/
    }

    private fun initData() : List<DrinkLocationDTO> {
        return listOf(
            DrinkLocationDTO(521,"Mexico", LatLng(19.4326, -99.1332), "Paloma"),
            DrinkLocationDTO(270,"Peru", LatLng(-12.0463, -77.0427), "Pisco Sour"),
            DrinkLocationDTO(40, "Canada", LatLng(45.4215, -75.6972), "Bloody Mary"),
            DrinkLocationDTO(120,"New York", LatLng(40.7306, -73.9452), "New York Sour"),
            DrinkLocationDTO(56, "Brazil", LatLng(-22.9068, -43.1729), "Caipirinha"),
            DrinkLocationDTO(248, "Spain", LatLng(40.73061, -3.7037), "Sangria"),
            DrinkLocationDTO(75, "France", LatLng(49.8566, 2.3522), "French 75"),
            DrinkLocationDTO(498, "England", LatLng(51.5074, 0.1278), "Vesper"),
            DrinkLocationDTO(37, "Russia", LatLng(55.7512, 37.6184), "Black Russian"),
            DrinkLocationDTO(346, "New Zealand", LatLng(-41.2769, 174.7731), "Kiwi Lemon"),
            DrinkLocationDTO(156, "Singapore", LatLng(1.3521, 103.8198), "Singapore Sling"),
            DrinkLocationDTO(105, "Japan", LatLng(35.6762, 139.6503), "Kamikaze"),
            DrinkLocationDTO(295, "Germany", LatLng(52.5200, 13.4050), "Kir Royale"),
            DrinkLocationDTO(388, "Cuba", LatLng(23.6762, -82.6503), "Mojito"),
            DrinkLocationDTO(307, "Jamaica", LatLng(18.1096, -77.2975), "Jamaica Kiss"),
            DrinkLocationDTO(103, "Egypt", LatLng(24.8206, 27.8025), "Jewel Of The Nile"),
            DrinkLocationDTO(3, "Zimbabwe", LatLng(-19.0154, 29.1549), "Negroni")
        )
    }
}