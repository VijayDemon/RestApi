package com.practice.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class BindAdapter (val countrydetails :List<CountryDetails>):
                    RecyclerView.Adapter<BindAdapter.ViewHolder>(){


    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView){

        val c_name :TextView= itemView.findViewById(R.id.c_name)
        val c_region :TextView= itemView.findViewById(R.id.c_region)
        val c_cap :TextView= itemView.findViewById(R.id.c_cap)
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

     return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_items,parent,false))

    }

    override fun getItemCount(): Int {
            return countrydetails.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.c_name.text=countrydetails[position].name
        holder.c_region.text=countrydetails[position].region

        holder.c_cap.text=countrydetails[position].capital
        if(countrydetails[position].capital.isEmpty())
            holder.c_cap.text="Not Available"
        }
     }


