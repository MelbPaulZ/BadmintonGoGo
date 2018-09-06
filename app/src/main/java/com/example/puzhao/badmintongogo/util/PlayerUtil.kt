package com.example.puzhao.badmintongogo.util

import com.example.puzhao.badmintongogo.bean.ChosenPlayer
import com.example.puzhao.badmintongogo.bean.Player

class PlayerUtil{
    companion object {
        fun create(name:String, credit:Double, gender:String):Player{
            return Player(name, credit, gender)
        }

        fun convertPlayerListToChosenPlayerList(playerList: List<Player>): MutableList<ChosenPlayer>{
            var chosenPlayerList: MutableList<ChosenPlayer> = mutableListOf()
            for (player in playerList){
                val chosenPlayer = ChosenPlayer(player, false).let {
                    chosenPlayerList.add(it)
                }
            }
            return chosenPlayerList
        }
    }
}