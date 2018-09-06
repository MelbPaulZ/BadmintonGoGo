package com.example.puzhao.badmintongogo.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.puzhao.badmintongogo.R
import com.example.puzhao.badmintongogo.ui.contract.AddNewPlayerContract
import com.example.puzhao.badmintongogo.util.PlayerUtil
import com.example.puzhao.badmintongogo.util.ValidationUtil
import com.gc.materialdesign.widgets.SnackBar
import kotlinx.android.synthetic.main.fragment_add_new_player.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class AddNewPlayerFragment:Fragment(), AddNewPlayerContract.View{

    private var snackBar:SnackBar? = null

    private var lastClickTime: Long = 0

    private fun gotoMainPage() {
        activity?.finish()
    }

    private var presenter:AddNewPlayerContract.Presenter? = null


    override fun setPresenter(p: AddNewPlayerContract.Presenter) {
        presenter = p
    }

    override fun popupSnackBar() {

        snackBar = SnackBar(activity, getString(R.string.new_player_added))
        with(snackBar){
            this?.setOnDismissListener{
                Handler().postDelayed({
                    gotoMainPage()
                },1000)
            }
            this?.show()
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add_new_player, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_done.setOnClickListener { _ ->

            // prevent multiple click
            if (SystemClock.elapsedRealtime() - lastClickTime < 1500){
                return@setOnClickListener;
            }
            lastClickTime = SystemClock.elapsedRealtime();

            val name = edt_name.text

            // if the input is invalid
            if (!ValidationUtil.checkIsInputADouble(edt_credit.text.toString())){
                snackBar = SnackBar(activity, getString(R.string.credit_input_invalid))
                snackBar?.show()
                return@setOnClickListener
            }
            val credit:Double = edt_credit.text.toString().toDouble()
            var gender = ""
            when{
                rdbtn_male.isChecked -> gender = getString(R.string.male)
                rdbtn_female.isChecked -> gender = getString(R.string.female)

            }
            presenter?.done(PlayerUtil.create(name.toString(),credit,gender))
        }
    }



}