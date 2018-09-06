package com.example.puzhao.badmintongogo.ui.contract

import com.example.puzhao.badmintongogo.base.BasePresenter
import com.example.puzhao.badmintongogo.base.BaseView
import com.example.puzhao.badmintongogo.bean.Player

interface ViewAllPlayersContract{
    interface View:BaseView<Presenter>{
        fun onClickPlayer(player: Player)
    }

    interface Presenter:BasePresenter<View>{
        fun getAllPlayers():List<Player>
    }
}