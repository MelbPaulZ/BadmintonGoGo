package com.example.puzhao.badmintongogo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.puzhao.badmintongogo.R
import com.example.puzhao.badmintongogo.ui.fragment.AddNewPlayerFragment
import com.example.puzhao.badmintongogo.ui.presenter.AddNewPlayerPresenter

class NewPlayerActivity:AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_player)

        init()
    }

    private fun init(){
        var fragment: AddNewPlayerFragment? = supportFragmentManager.findFragmentByTag(AddNewPlayerFragment::class.java.simpleName) as? AddNewPlayerFragment
        if (fragment == null){
            fragment = AddNewPlayerFragment()
            fragment.setPresenter(AddNewPlayerPresenter(this))
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment, fragment::class.java.simpleName).commit()


        }

    }
}