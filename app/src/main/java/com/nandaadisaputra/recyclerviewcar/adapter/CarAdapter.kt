package com.nandaadisaputra.recyclerviewcar.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nandaadisaputra.recyclerviewcar.R
import com.nandaadisaputra.recyclerviewcar.activity.DetailActivity
import com.nandaadisaputra.recyclerviewcar.model.CarModel
import kotlinx.android.synthetic.main.item_layout.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class CarAdapter (private val context: Context, private val item: List<CarModel>):
        RecyclerView.Adapter<CarAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(carModel: CarModel) {
            itemView.nameCar.text = carModel.name
            Glide.with(itemView.context).load(carModel.image).into(itemView.imageCar)
            itemView.onClick {
                itemView.context.startActivity<DetailActivity>("car" to carModel)
            }
             Log.d("Test",carModel.toString())

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder (LayoutInflater.from(context).inflate(
        R.layout.item_layout,parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.bindItem(item[position])
    }

    override fun getItemCount(): Int = item.size

}