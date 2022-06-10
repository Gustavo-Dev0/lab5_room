package com.dev0.deliveryfood.feacture_cart.domain.repository

import android.content.ContentValues
import com.dev0.deliveryfood.core.repository.AppDb
import com.dev0.deliveryfood.feacture_cart.domain.model.Order
import com.dev0.deliveryfood.feature_restaurant.domain.model.Restaurant

class OrderRepository {
    val dbR = AppDb.db.readableDatabase
    val dbW = AppDb.db.writableDatabase

    fun add(actualOrder: Order) {
        val valuesO3 = ContentValues().apply {
            put("date", "Hoy")
            put("user", "Luis")
            put("total", actualOrder.total)
            put("status", 0)
        }
        val newRowIdO3 = dbW?.insert("orders", null, valuesO3)
    }

    fun getAll(): ArrayList<Order> {


        val projection = arrayOf("id", "date", "user", "status", "total")

        val cursor = dbR.query(
            "orders",
            projection,
            null,
            null,
            null,
            null,
            null
        )

        val list = ArrayList<Order>()
        with(cursor) {
            while (moveToNext()) {
                val id = getLong(getColumnIndexOrThrow("id"))
                val date = getString(getColumnIndexOrThrow("date"))
                val user = getString(getColumnIndexOrThrow("user"))
                val total = getDouble(getColumnIndexOrThrow("total"))
                val status = getLong(getColumnIndexOrThrow("status"))

                var order = Order(
                    id = id.toInt(),
                    date = date,
                    userName = user,
                    total = total,
                    status = status.toInt()
                )


                list.add(order)
            }
        }
        cursor.close()
        return list


        return ArrayList()
    }
}