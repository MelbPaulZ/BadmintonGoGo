package com.example.puzhao.badmintongogo.util

class ValidationUtil{
    companion object {
        fun checkIsInputADouble(input: String): Boolean {
            val d = input.toDoubleOrNull()
            return d != null
        }
    }
}