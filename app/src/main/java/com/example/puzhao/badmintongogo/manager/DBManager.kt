package com.example.puzhao.badmintongogo.manager

import android.content.Context
import com.example.puzhao.badmintongogo.bean.MyObjectBox
import com.example.puzhao.badmintongogo.bean.Player
import io.objectbox.Box

class DBManager private constructor(){

    var box:Box<Player>? = null

    companion object{
        private var instance:DBManager? = null

        fun getInstance(context: Context):DBManager =
            instance ?: synchronized(this){
                instance ?: initDB(context).also { it -> instance = it }

            }

        private fun initDB(context: Context):DBManager{
            instance = DBManager()
            instance?.initPlayerBox(context)
            return instance as DBManager
        }

    }

    fun initPlayerBox(context: Context){
        val store = MyObjectBox.builder().androidContext(context).build()
        box = store.boxFor(Player::class.java)
    }

    fun putPlayer(player: Player){
        box!!.put(player)
    }

    fun getAllPlayers():MutableList<Player>{
        return box!!.all
    }

    fun addCredit(player: Player,credit: Double){
        player.credit += credit
        box!!.put(player)
    }



}