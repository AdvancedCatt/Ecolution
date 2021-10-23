package com.adoneko.ecolution.bank.impl

import com.adoneko.ecolution.bank.Bank
import com.adoneko.ecolution.data.User
import com.adoneko.ecolution.wallet.Wallet
import com.adoneko.ecolution.wallet.impl.NormalWallet

class SystemBank : Bank {
    override val maxAmount: Double? = null
    override val wallets: MutableList<Wallet> = mutableListOf()

    override fun createWallet(vararg managers: User): Wallet {
        val wallet = NormalWallet(
            bank = this,
            maxAmount = maxAmount,
            owners = managers.toMutableList()
        )

        wallets.add(wallet)

        return wallet
    }

    override fun isActive(): Boolean {
        return true
    }

    override fun withdraw(dest: Wallet, source: Wallet, amount: Double): Boolean {
        if(!dest.addMoney(amount, true)) {
            return false
        }

        source.removeMoney(amount, false)

        return dest.addMoney(amount, true)
    }

    override fun deposit(dest: Wallet, source: Wallet, amount: Double): Boolean {
        if(!dest.removeMoney(amount, true)) {
            return false
        }

        source.addMoney(amount, false)

        return dest.removeMoney(amount, false)
    }
}