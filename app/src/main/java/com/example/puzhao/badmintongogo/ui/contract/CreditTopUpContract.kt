package com.example.puzhao.badmintongogo.ui.contract

import com.example.puzhao.badmintongogo.base.BasePresenter
import com.example.puzhao.badmintongogo.base.BaseView
import com.example.puzhao.badmintongogo.bean.Player

interface CreditTopUpContract{
    interface View:BaseView<Presenter>{
        fun finishAddCredit()
    }

    interface Presenter:BasePresenter<View>{
        fun addCreditToPlayer(player: Player, credit:Double)
        fun getAllPlayers():MutableList<Player>
        fun selectPlayer(player: Player)
        fun getSelectPlayer(): Player?
    }
}