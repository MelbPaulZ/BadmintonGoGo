package com.example.puzhao.badmintongogo.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.puzhao.badmintongogo.R
import com.example.puzhao.badmintongogo.adapter.ChoosePlayerAdapter
import com.example.puzhao.badmintongogo.bean.ChosenPlayer
import com.example.puzhao.badmintongogo.bean.Player
import com.example.puzhao.badmintongogo.ui.contract.PlayAGameContract
import com.example.puzhao.badmintongogo.util.PlayerUtil
import com.example.puzhao.badmintongogo.util.ValidationUtil
import com.gc.materialdesign.widgets.SnackBar
import com.orhanobut.dialogplus.DialogPlus
import kotlinx.android.synthetic.main.fragment_add_new_player.*
import kotlinx.android.synthetic.main.fragment_play_a_game.*
import kotlinx.android.synthetic.main.row_choose_player.view.*

class PlayAGameFragment:Fragment(),PlayAGameContract.View{
    override fun backToMainPage() {
        activity?.finish()
    }

    private var presenter:PlayAGameContract.Presenter? = null

    private var chosedPlayerList: MutableList<ChosenPlayer> = ArrayList()

    var count = 0


    override fun setPresenter(p: PlayAGameContract.Presenter) {
        presenter = p
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_play_a_game, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val playerList:List<Player> = presenter!!.getAllPlayers()
        chosedPlayerList = PlayerUtil.convertPlayerListToChosenPlayerList(playerList)

        var choosePlayerAdapter = ChoosePlayerAdapter(context!!,chosedPlayerList)

        btn_choose_player.setOnClickListener {
            var dialog: DialogPlus = DialogPlus.newDialog(context)
                    .setAdapter(choosePlayerAdapter)
                    .setOnDismissListener{
                        count = 0
                        for (p in chosedPlayerList){
                            if (p.isChosen){
                                count += 1
                            }
                        }
                        Toast.makeText(context, count.toString() + " players have been chosen", Toast.LENGTH_SHORT).show()
                    }
                    .setExpanded(true)
                    .create()
            dialog.show()
        }

        btn_done_play_a_game.setOnClickListener {
            // if the input is invalid
            if (!ValidationUtil.checkIsInputADouble(total_cost_edt.text.toString())){
                val snackBar = SnackBar(activity, getString(R.string.credit_input_invalid))
                snackBar.show()
                return@setOnClickListener
            }
            val cost:Double = total_cost_edt.text.toString().toDouble()
            presenter?.doneChoosePlayers(cost,count, chosedPlayerList)
        }


    }

    override fun onStart() {
        super.onStart()
        presenter?.subscribe(this)
    }

    override fun onStop() {
        super.onStop()
        presenter?.unsubscribe()
    }




}