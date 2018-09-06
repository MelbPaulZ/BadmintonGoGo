package com.example.puzhao.badmintongogo.ui.presenter

import android.content.Context
import com.example.puzhao.badmintongogo.bean.Player
import com.example.puzhao.badmintongogo.manager.DBManager
import com.example.puzhao.badmintongogo.ui.contract.CreditTopUpContract

class CreditTopUpPresenter(context: Context):CreditTopUpContract.Presenter{

    override fun getSelectPlayer(): Player? {
        return this.selectPlayer
    }


    override fun selectPlayer(player: Player) {
        this.selectPlayer = player
    }

    override fun getAllPlayers(): MutableList<Player> {
        return DBManager.getInstance(mContext).getAllPlayers()
    }

    private val mContext = context
    private var selectPlayer:Player? = if (getAllPlayers().size>0) getAllPlayers()[0] else null

    override fun addCreditToPlayer(player: Player, credit: Double) {
        DBManager.getInstance(mContext).addCredit(player, credit)
        view?.finishAddCredit()

    }

    private var view:CreditTopUpContract.View? = null

    override fun subscribe(v: CreditTopUpContract.View) {
       this.view = v
    }

    override fun unsubscribe() {
        this.view = null
    }

}