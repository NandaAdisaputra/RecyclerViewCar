package com.nandaadisaputra.recyclerviewcar.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.nandaadisaputra.recyclerviewcar.R
import com.nandaadisaputra.recyclerviewcar.adapter.CarAdapter
import com.nandaadisaputra.recyclerviewcar.model.CarModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val item: MutableList<CarModel> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        rvCar.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)
        rvCar.adapter = CarAdapter(this, item)
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.name_car)
        val image = resources.obtainTypedArray(R.array.image_car)
        for (i in name.indices) {
            item.add(
                CarModel(
                    name[i],
                    image.getResourceId(i, 0)
                )
            )
        }
        image.recycle()
    }
}