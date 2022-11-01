package com.example.gd8_proximity_d_10362

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService

lateinit var sensorStatusTV: TextView

lateinit var proximitySensor: Sensor

lateinit var sensorManager: SensorManager

var proximitySensorEventListener: SensorEventListener? = object : SensorEventListener {
    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent) {

    }
}

    override fun onCreate(savedInstancesState: Bundle?) {
        super.onCreate(savedInstancesState)
        setContentView(R.layout.activity_main)

        sensorStatusTV = findViewById(R.id.idTVSensorStatus)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

        if (proximitySensor == null) {
            Toast.makeText(this, "No proximity sensor found in device..", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            sensorManager.registerListener(
                proximitySensorEventListener,
                proximitySensor,
                SensorManager.SENSOR_DELAY_NORMAL
            )
        }
    }

if(event.sensor.type==Sensor.TYPE_PROXIMITY){
    if(event.values[0]==0f){
        sensorStatusTV.text="<<<Near>>>"
    } else {
        sensorStatusTV.text="<<<<Away>>>>"
    }
}