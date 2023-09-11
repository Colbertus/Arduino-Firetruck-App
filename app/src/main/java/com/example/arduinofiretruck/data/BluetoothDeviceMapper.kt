package com.example.arduinofiretruck.data

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import com.example.arduinofiretruck.domain.BluetoothDeviceDomain

@SuppressLint("MissingPermission")
fun BluetoothDevice.toBluetoothDeviceDomain(): BluetoothDeviceDomain {
    return BluetoothDeviceDomain(
        name = name,
        address = address
    )
}