package com.dev0.deliveryfood.core.repository


import androidx.room.Room
import com.dev0.deliveryfood.core.data.DBHelper
import com.dev0.deliveryfood.core.data.DeliveryDatabase

class AppDb {
    companion object{
        lateinit var db: DBHelper
        lateinit var dbRoom: DeliveryDatabase
    }
}