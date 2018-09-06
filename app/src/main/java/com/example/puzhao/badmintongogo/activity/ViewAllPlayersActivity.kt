package com.example.puzhao.badmintongogo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.puzhao.badmintongogo.R
import com.example.puzhao.badmintongogo.ui.fragment.ViewAllPlayersFragment
import com.example.puzhao.badmintongogo.ui.presenter.ViewAllPlayersPresenter

class ViewAllPlayersActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_all_players)
        init()
    }

    private fun init(){
        var fragment:ViewAllPlayersFragment? = supportFragmentManager.findFragmentByTag(ViewAllPlayersFragment::class.java.simpleName) as? ViewAllPlayersFragment
        if(fragment == null){
            fragment = ViewAllPlayersFragment()
            fragment.setPresenter(ViewAllPlayersPresenter(this))
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment, fragment::class.java.simpleName).commit()
        }
    }
}