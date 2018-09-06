package com.example.puzhao.badmintongogo.ui.presenter

import android.content.Context
import com.example.puzhao.badmintongogo.bean.Player
import com.example.puzhao.badmintongogo.manager.DBManager
import com.example.puzhao.badmintongogo.ui.contract.ViewAllPlayersContract

class ViewAllPlayersPresenter(context: Context):ViewAllPlayersContract.Presenter{

    private val mContext:Context = context
    override fun getAllPlayers(): List<Player> {
        return DBManager.getInstance(mContext).getAllPlayers()
    }

    private var view:ViewAllPlayersContract.View? =null

    override fun subscribe(v: ViewAllPlayersContract.View) {
        view = v
    }

    override fun unsubscribe() {
        view = null
    }



}