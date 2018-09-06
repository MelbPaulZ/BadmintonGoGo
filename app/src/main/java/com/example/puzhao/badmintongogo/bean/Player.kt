package com.example.puzhao.badmintongogo.bean

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class Player(var name:String, var credit:Double, var gender:String){
    @Id var id:Long = 0

    constructor() : this("", 0.0, "Male")

}