package com.example.puzhao.badmintongogo.ui.contract

import com.example.puzhao.badmintongogo.base.BasePresenter
import com.example.puzhao.badmintongogo.base.BaseView
import com.example.puzhao.badmintongogo.bean.Player

interface AddNewPlayerContract{
    interface View:BaseView<Presenter>{
        fun popupSnackBar()
    }

    interface Presenter:BasePresenter<View>{
        fun done(player:Player)
    }
}