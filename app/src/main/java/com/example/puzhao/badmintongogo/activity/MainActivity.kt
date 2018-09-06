package com.example.puzhao.badmintongogo.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.puzhao.badmintongogo.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_add_player.setOnClickListener{
            startActivity(Intent(this, NewPlayerActivity::class.java))
        }

        btn_credit_top_up.setOnClickListener {
            startActivity(Intent(this,CreditTopUpActivity::class.java))
        }

        btn_view_all_players.setOnClickListener {
            startActivity(Intent(this, ViewAllPlayersActivity::class.java))
        }

        btn_play_a_game.setOnClickListener{
            startActivity(Intent(this, PlayAGameActivity::class.java))
        }

    }
}
