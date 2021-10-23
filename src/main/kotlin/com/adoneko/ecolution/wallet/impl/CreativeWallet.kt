package com.adoneko.ecolution.wallet.impl

import com.adoneko.ecolution.wallet.Wallet

class CreativeWallet : Wallet {
    override fun addMoney(amount: Double, isSimulate: Boolean): Boolean {
        return true
    }

    override fun removeMoney(amount: Double, isSimulate: Boolean): Boolean {
        return false
    }

    override fun getBalance(): Double {
        return Double.MAX_VALUE
    }
}