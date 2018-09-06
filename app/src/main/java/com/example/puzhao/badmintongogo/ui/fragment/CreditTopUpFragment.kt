package com.example.puzhao.badmintongogo.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.puzhao.badmintongogo.R
import com.example.puzhao.badmintongogo.bean.Player
import com.example.puzhao.badmintongogo.ui.contract.CreditTopUpContract
import com.example.puzhao.badmintongogo.util.ValidationUtil
import com.gc.materialdesign.widgets.SnackBar
import com.jaredrummler.materialspinner.MaterialSpinner
import kotlinx.android.synthetic.main.fragment_credit_top_up.*

class CreditTopUpFragment: Fragment(),CreditTopUpContract.View{


    private var presenter:CreditTopUpContract.Presenter? = null
    private var snackBar:SnackBar? = null
    private var lastClickTime: Long = 0


    override fun finishAddCredit() {
        snackBar = SnackBar(activity, getString(R.string.top_up_successfully))
        with(snackBar){
            this?.setOnDismissListener{
                Handler().postDelayed({
                    gotoMainPage()
                },1000)
            }
            this?.show()
        }
    }

    private fun gotoMainPage(){
        activity?.finish()
    }


    override fun setPresenter(p: CreditTopUpContract.Presenter) {
        this.presenter = p
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_credit_top_up, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        spn_player.apply {
            setItems(presenter!!.getAllPlayers())
            val itemSelectListener = MaterialSpinner.OnItemSelectedListener<Player> { view, position, id, item ->
                presenter?.selectPlayer(item)
            }
            setOnItemSelectedListener(itemSelectListener)
        }


        btn_done_add_credit.setOnClickListener {
            // prevent multiple click
            if (SystemClock.elapsedRealtime() - lastClickTime < 1500){
                return@setOnClickListener;
            }
            lastClickTime = SystemClock.elapsedRealtime();


            if (!ValidationUtil.checkIsInputADouble(edt_add_credit.text.toString())){
                snackBar = SnackBar(activity, getString(R.string.credit_input_invalid))
                snackBar?.show()
                return@setOnClickListener
            }
            val credit:Double = edt_add_credit.text.toString().toDouble()
            presenter!!.addCreditToPlayer(presenter!!.getSelectPlayer()!!, credit)

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