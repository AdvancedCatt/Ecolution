package com.adoneko.ecolution.wallet.impl

import com.adoneko.ecolution.bank.Bank
import com.adoneko.ecolution.data.Ownership
import com.adoneko.ecolution.data.User
import com.adoneko.ecolution.wallet.Wallet

open class NormalWallet(
    private var currentMoney: Double = 0.0,
    val bank: Bank,
    val maxAmount: Double?,
    override val owners: MutableList<User> = mutableListOf()
) : Wallet, Ownership {
    override fun addMoney(amount: Double, isSimulate: Boolean): Boolean {
        val isSuccess = maxAmount?.let { currentMoney + amount < it } ?: true

        if(!isSuccess) {
            return false
        }

        if(!isSimulate) {
            currentMoney += amount
        }

        return true
    }

    override fun removeMoney(amount: Double, isSimulate: Boolean): Boolean {
        if(currentMoney - amount < 0) {
            return false
        }

        if(!isSimulate) {
            currentMoney -= amount
        }

        return true
    }

    override fun getBalance(): Double {
        return currentMoney
    }
}