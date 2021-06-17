package com.mobolajialabi.workoutdemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class VPAdapter(fm : FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> WorkoutListFragment.newInstance("today")
        1 -> WorkoutListFragment.newInstance("week")
        2 -> WorkoutListFragment.newInstance("month")
        else -> WorkoutListFragment.newInstance("today")
    }
}