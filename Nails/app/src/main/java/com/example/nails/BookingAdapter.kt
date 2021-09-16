package com.example.nails


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView

class BookingAdapter:RecyclerView.Adapter<BookingAdapter.BookingViewHolder>() {

    private var stdList : ArrayList<BookingModel> = ArrayList()

    fun addItems(items:ArrayList<BookingModel>) {

        this.stdList=items
    }

    class BookingViewHolder(var view: View):RecyclerView.ViewHolder(view){

        private var txtname2= view.findViewById<TextView>(R.id.txtname2)
        private var txtdate= view.findViewById<TextView>(R.id.txtdate)
        private var txttime= view.findViewById<TextView>(R.id.txttime)




        fun bindView(){
            txtname2.text=std.name
            txtdate.text=std.date
            txttime.text=std.time
        }


        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= BookingViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.bookings_layout,parent,false))


    override fun onBindViewHolder(holder: BookingViewHolder, position: Int) {
        val std = stdList[position]
        holder.bindView(std)
    }

    override fun getItemCount(): Int {
        return stdList.size
    }
}
