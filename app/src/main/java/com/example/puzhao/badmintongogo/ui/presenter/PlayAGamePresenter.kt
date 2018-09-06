package com.example.puzhao.badmintongogo.ui.presenter

import android.content.Context
import com.example.puzhao.badmintongogo.bean.ChosenPlayer
import com.example.puzhao.badmintongogo.bean.Player
import com.example.puzhao.badmintongogo.manager.DBManager
import com.example.puzhao.badmintongogo.ui.contract.PlayAGameContract

class PlayAGamePresenter(context: Context): PlayAGameContract.Presenter{
    override fun doneChoosePlayers(cost:Double, numberOfPlayers: Int,chosenPlayerList: MutableList<ChosenPlayer>) {
        val eachCost:Double = cost/numberOfPlayers
        for (p in chosenPlayerList){
            if (p.isChosen){
                p.player.credit -= eachCost
                DBManager.getInstance(mContext).putPlayer(p.player)
            }
        }
        view?.backToMainPage()
    }

    private val mContext = context
    private var view: PlayAGameContract.View? = null

    override fun unsubscribe() {
        view = null
    }

    override fun subscribe(v: PlayAGameContract.View) {
        view = v
    }

     override fun getAllPlayers(): List<Player> {
            return DBManager.getInstance(mContext).getAllPlayers()
     }


}