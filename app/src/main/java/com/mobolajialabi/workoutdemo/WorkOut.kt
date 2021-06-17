package com.mobolajialabi.workoutdemo

data class WorkOut (
        val name : String,

        //1 = strength
        //2 = Cardio
        //3 = Flexibility
        val type : Int,

        //1 = low
        //2 = medium
        //3 = high
        val intensity : Int
)