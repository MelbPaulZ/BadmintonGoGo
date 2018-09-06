package com.example.puzhao.badmintongogo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.puzhao.badmintongogo.R
import com.example.puzhao.badmintongogo.ui.fragment.CreditTopUpFragment
import com.example.puzhao.badmintongogo.ui.presenter.CreditTopUpPresenter

class CreditTopUpActivity:AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.credit_top_up_activity)

        init()
    }

    private fun init(){
        var fragment: CreditTopUpFragment? = supportFragmentManager.findFragmentByTag(CreditTopUpFragment::class.java.simpleName) as? CreditTopUpFragment
        if (fragment == null){
            fragment = CreditTopUpFragment()
            fragment.setPresenter(CreditTopUpPresenter(this))
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment, fragment::class.java.simpleName).commit()
        }
    }

}