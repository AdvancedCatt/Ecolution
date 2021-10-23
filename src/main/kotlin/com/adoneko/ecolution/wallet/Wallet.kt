package com.adoneko.ecolution.wallet

interface Wallet {
    fun addMoney(amount: Double, isSimulate: Boolean): Boolean
    fun removeMoney(amount: Double, isSimulate: Boolean): Boolean

    fun getBalance(): Double
}