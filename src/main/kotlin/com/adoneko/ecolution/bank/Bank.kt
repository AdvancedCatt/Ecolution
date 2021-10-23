package com.adoneko.ecolution.bank

import com.adoneko.ecolution.data.User
import com.adoneko.ecolution.wallet.Wallet

interface Bank {
    val maxAmount: Double?

    val wallets: List<Wallet>

    fun createWallet(vararg managers: User): Wallet

    fun isActive(): Boolean

    fun withdraw(dest: Wallet, source: Wallet, amount: Double): Boolean
    fun deposit(dest: Wallet, source: Wallet, amount: Double): Boolean
}