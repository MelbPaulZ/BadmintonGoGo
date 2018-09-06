package com.example.puzhao.badmintongogo.ui.presenter

import android.content.Context
import android.util.Log
import com.example.puzhao.badmintongogo.bean.Player
import com.example.puzhao.badmintongogo.manager.DBManager
import com.example.puzhao.badmintongogo.ui.contract.AddNewPlayerContract

class AddNewPlayerPresenter(context: Context):AddNewPlayerContract.Presenter{

    private var view:AddNewPlayerContract.View? = null
    private var dbManager:DBManager? = null
    private var mContext:Context = context


    init {
        // init box
        dbManager = DBManager.getInstance(mContext)
    }
    override fun done(player: Player) {
        savePlayerInDB(player)
        view?.popupSnackBar()
    }

    private fun savePlayerInDB(player:Player){
        dbManager!!.putPlayer(player)
        Log.d("test", "Inserted new note, ID: " + player.id);
    }

    override fun subscribe(v: AddNewPlayerContract.View) {
        view = v
    }

    override fun unsubscribe() {
        view = null
    }

}