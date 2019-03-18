package com.example.underground

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*


class MainActivity : AppCompatActivity(), OnMapReadyCallback {
//    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

//        val toggle = ActionBarDrawerToggle(
//            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
////        )
////        drawer_layout.addDrawerListener(toggle)
////        toggle.syncState()
//
//                    nav_view.setNavigationItemSelectedListener(this)
//
//            val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
//        mapFragment?.getMapAsync(this)
    }

//    override fun onBackPressed() {
//        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
//            drawer_layout.closeDrawer(GravityCompat.START)
//        } else {
//            super.onBackPressed()
//        }
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
////        menuInflater.inflate(R.menu.main, menu)
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        when (item.itemId) {
//            R.id.action_settings -> return true
//            else -> return super.onOptionsItemSelected(item)
//        }
//    }

//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        // Handle navigation view item clicks here.
//        when (item.itemId) {
//
////            R.id.nav_gallery -> {
////
////            }
////            R.id.nav_slideshow -> {
////
////            }
////            R.id.nav_manage -> {
////
////            }
////            R.id.nav_share -> {
////
////            }
////            R.id.nav_send -> {
////
////            }
//        }
//
//        drawer_layout.closeDrawer(GravityCompat.START)
//        return true
//    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

//        // Add a marker in Sydney and move the camera
//        val sydney = LatLng(-34.0, 151.0)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        // Check to see if the user has enabled locaton permissions
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            mMap.isMyLocationEnabled = true
            mMap.uiSettings.isMyLocationButtonEnabled = true
        }
        else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION),
                1
            )
        }
    }

}
