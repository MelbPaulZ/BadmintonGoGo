package com.example.puzhao.badmintongogo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.puzhao.badmintongogo.R
import com.example.puzhao.badmintongogo.R.id.row_name

import com.example.puzhao.badmintongogo.bean.Player
import kotlinx.android.synthetic.main.row_player.view.*

class PlayerAdapter(private var playerList: List<Player>):RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>(){

    private var onClickPlayerListener:OnClickPlayerListener? = null

    class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.row_name
        val credit = itemView.row_credit
        val view = itemView
    }

    interface OnClickPlayerListener{
        fun onClickPlayer(player: Player)
    }

    fun setOnClickPlayerListener(onClickPlayerListener: OnClickPlayerListener){
        this.onClickPlayerListener = onClickPlayerListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.row_player, parent,false)
        return PlayerViewHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.name.text = playerList[position].name
        holder.credit.text = playerList[position].credit.toString()
        holder.view.setOnClickListener {
            onClickPlayerListener?.onClickPlayer(playerList[position])
        }

    }

}