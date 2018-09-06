package com.example.puzhao.badmintongogo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.puzhao.badmintongogo.R
import com.example.puzhao.badmintongogo.bean.ChosenPlayer
import com.example.puzhao.badmintongogo.bean.Player
import kotlinx.android.synthetic.main.row_choose_player.view.*
import org.jetbrains.anko.sdk25.coroutines.onCheckedChange

class ChoosePlayerAdapter(context: Context, playList: MutableList<ChosenPlayer>): BaseAdapter(){

    private val mContext = context
    var playerList:List<ChosenPlayer> = playList


    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view:View = LayoutInflater.from(mContext).inflate(R.layout.row_choose_player, p2, false)
        val viewHolder: ViewHolder = ViewHolder(view)
        viewHolder.checkbox.isChecked = playerList[p0].isChosen

        viewHolder.checkbox.onCheckedChange { buttonView, isChecked ->
            playerList[p0].isChosen = !playerList[p0].isChosen
        }
        viewHolder.name.text = playerList[p0].player.name
        return view

    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return playerList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var checkbox = itemView.player_checkbox
        var name = itemView.player_name_tv
    }
}