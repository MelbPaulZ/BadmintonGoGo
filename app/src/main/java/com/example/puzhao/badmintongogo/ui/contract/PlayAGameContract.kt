package com.example.puzhao.badmintongogo.ui.contract

import com.example.puzhao.badmintongogo.base.BasePresenter
import com.example.puzhao.badmintongogo.base.BaseView
import com.example.puzhao.badmintongogo.bean.ChosenPlayer
import com.example.puzhao.badmintongogo.bean.Player

interface PlayAGameContract{
    interface View:BaseView<Presenter>{
        fun backToMainPage()
    }

    interface Presenter:BasePresenter<View>{
        fun getAllPlayers(): List<Player>

        fun doneChoosePlayers(cost: Double, numberOfPlayers:Int,  chosenPlayerList: MutableList<ChosenPlayer>)
    }
}