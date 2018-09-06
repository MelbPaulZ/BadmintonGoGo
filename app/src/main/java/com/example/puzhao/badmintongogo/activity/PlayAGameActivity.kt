package com.example.puzhao.badmintongogo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.puzhao.badmintongogo.R
import com.example.puzhao.badmintongogo.ui.fragment.PlayAGameFragment
import com.example.puzhao.badmintongogo.ui.presenter.PlayAGamePresenter

class PlayAGameActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_a_game)
        init()
    }

    private fun init(){
        var fragment:PlayAGameFragment? = supportFragmentManager.findFragmentByTag(PlayAGameFragment::class.java.simpleName) as? PlayAGameFragment
        if (fragment == null){
            fragment = PlayAGameFragment()
            fragment.setPresenter(PlayAGamePresenter(this))
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment, fragment::class.java.simpleName).commit()
        }
    }



}