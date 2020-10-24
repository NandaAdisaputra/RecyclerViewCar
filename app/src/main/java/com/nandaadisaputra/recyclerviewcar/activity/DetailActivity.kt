package com.nandaadisaputra.recyclerviewcar.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.nandaadisaputra.recyclerviewcar.R
import com.nandaadisaputra.recyclerviewcar.model.CarModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    var carModel: CarModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        carModel= intent.getParcelableExtra("car")
        textDescCar.text= carModel?.name.toString()
        Glide.with(this).load(carModel?.image).into(imageDescCar)
    }
}