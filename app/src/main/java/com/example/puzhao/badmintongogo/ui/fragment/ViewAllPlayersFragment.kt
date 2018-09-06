package com.example.puzhao.badmintongogo.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.example.puzhao.badmintongogo.R
import com.example.puzhao.badmintongogo.adapter.PlayerAdapter
import com.example.puzhao.badmintongogo.bean.Player
import com.example.puzhao.badmintongogo.ui.contract.ViewAllPlayersContract
import kotlinx.android.synthetic.main.fragment_view_all_players.*

class ViewAllPlayersFragment:Fragment(),ViewAllPlayersContract.View{

    override fun onClickPlayer(player: Player) {
        MaterialDialog(context!!).apply {
            title(R.string.credit_top_up)
            positiveButton { R.string.done }
            negativeButton { R.string.cancel }
        }.show()
    }

    private var presenter:ViewAllPlayersContract.Presenter? = null

    override fun setPresenter(p: ViewAllPlayersContract.Presenter) {
        presenter = p
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_view_all_players, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val playerList = presenter?.getAllPlayers()!!

//        val playerAdapterOnClickListener = object:PlayerAdapter.OnClickPlayerListener{
//            override fun onClickPlayer(player: Player) {
//                onClickPlayer(player)
//            }
//        }
        val playerAdapter = PlayerAdapter(playerList)
//        playerAdapter.setOnClickPlayerListener(playerAdapterOnClickListener)

        recycylerview_view_all_players.adapter = playerAdapter

    }



}