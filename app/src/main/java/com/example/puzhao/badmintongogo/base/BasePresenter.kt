package com.example.puzhao.badmintongogo.base

interface BasePresenter<V>{
    fun subscribe(v:V)

    fun unsubscribe()
}