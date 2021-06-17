package com.mobolajialabi.workoutdemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val workouts : ArrayList<WorkOut>, private val context: Context) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.workout, parent, false)

        return MyViewHolder(v, context)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val workout = workouts[position]

        holder.num.text = (position + 1).toString()
        holder.name.text = workout.name

        when (workout.intensity) {
            1 -> {
                holder.intensity.text = context.getString(R.string.low)
                holder.v2.setBackgroundResource(R.drawable.bg_low)
            }
            2 -> {
                holder.intensity.text = context.getString(R.string.medium)
                holder.v2.setBackgroundResource(R.drawable.bg_med)
            }
            3 -> {
                holder.intensity.text = context.getString(R.string.high)
                holder.v2.setBackgroundResource(R.drawable.bg_high)
            }
        }

        when (workout.type) {
            1 -> {
                holder.v1.setBackgroundResource(R.drawable.bg_med)
                holder.type.text = context.getString(R.string.strength)
            }
            2 -> {
                holder.v1.setBackgroundResource(R.drawable.bg_low)
                holder.type.text = context.getString(R.string.cardio)

            }
            3 -> {
                holder.v1.setBackgroundResource(R.drawable.bg_high)
                holder.type.text = context.getString(R.string.flex)

            }
        }
    }

    override fun getItemCount(): Int = workouts.size

    class MyViewHolder(itemView : View, private val context: Context) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val v1 : View = itemView.findViewById(R.id.view1)
        val v2 : View = itemView.findViewById(R.id.view2)
        val num : TextView = itemView.findViewById(R.id.num)
        val name : TextView = itemView.findViewById(R.id.name)
        val type : TextView = itemView.findViewById(R.id.type)
        val intensity : TextView = itemView.findViewById(R.id.intensity)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

            val intent = Intent(context, WorkoutActivity::class.java)
            intent.putExtra("name", name.text.toString())
            context.startActivity(intent)
        }

    }
}