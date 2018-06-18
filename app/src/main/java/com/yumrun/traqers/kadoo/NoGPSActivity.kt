package com.yumrun.traqers.kadoo

import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import android.view.View

class NoGPSActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_gps)
        checkGPSServiceStatus()
    }

    fun turnOnGPSService(v: View?){
        startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
    }

    override fun onResume() {
        super.onResume()
        checkGPSServiceStatus()
    }

    private fun checkGPSServiceStatus() {
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            startActivity(Intent(this, MapActivity::class.java))
            finish()
            return
        }
    }
}
