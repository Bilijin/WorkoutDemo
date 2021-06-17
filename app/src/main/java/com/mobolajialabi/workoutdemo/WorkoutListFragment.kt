package com.mobolajialabi.workoutdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WorkoutListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_workout_list, container, false)
        val workouts = arguments?.let {
            when (it.getString("day")) {
                "today" -> loadToday()
                "week" -> loadWeek()
                "month" -> loadMonth()
                else -> loadToday()
            }
        }!!

        val rec : RecyclerView = v.findViewById(R.id.workout_recycler)
        rec.adapter = RecyclerAdapter(workouts, requireContext())
        val t : TextView = v.findViewById(R.id.count)
        t.text = workouts.size.toString() + " exercises"
        return v
    }

    private fun loadToday() : ArrayList<WorkOut>{
        val works = ArrayList<WorkOut>()

        works.add(WorkOut("Front Squat", 1, 2))
        works.add(WorkOut("Hip Abduction", 1, 1))
        works.add(WorkOut("Front Squat", 1, 3))
        works.add(WorkOut("Elliptical Crosstrainer", 2, 3))
        works.add(WorkOut("Goblet Squats", 3, 2))
        works.add(WorkOut("Splits", 3, 2))
        works.add(WorkOut("Yoga", 3, 2))

        return works
    }

    private fun loadWeek() : ArrayList<WorkOut>{
        val works = ArrayList<WorkOut>()
        works.add(WorkOut("Push Ups", 1, 2))
        works.add(WorkOut("Front Squat", 1, 2))
        works.add(WorkOut("Splits", 3, 3))
        works.add(WorkOut("Elliptical Crosstrainer", 2, 3))
        works.add(WorkOut("Front Squat", 3, 2))
        works.add(WorkOut("Sit Ups", 2, 1))
        return works
    }

    private fun loadMonth() : ArrayList<WorkOut>{
        val works = ArrayList<WorkOut>()

        works.add(WorkOut("Jumping Jacks", 2, 1))
        works.add(WorkOut("Hip Abduction", 1, 1))
        works.add(WorkOut("Front Squat", 1, 3))
        works.add(WorkOut("Spot Jogging", 1, 1))
        works.add(WorkOut("Front Squat", 3, 2))
        works.add(WorkOut("Elliptical Crosstrainer", 2, 3))

        return works
    }

    companion object {

        @JvmStatic
        fun newInstance(day : String) =
            WorkoutListFragment().apply {
                arguments = Bundle().apply {
                    putString("day", day)
                }
            }
    }
}