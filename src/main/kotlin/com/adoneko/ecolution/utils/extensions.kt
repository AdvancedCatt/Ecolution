package com.adoneko.ecolution.utils

import com.adoneko.ecolution.data.Ownership
import com.adoneko.ecolution.data.User
import com.adoneko.ecolution.wallet.Wallet
import com.adoneko.ecolution.wallet.impl.NormalWallet

fun Ownership.addManager(user: User) {
    if(!owners.contains(user)) {
        return
    }

    (owners as MutableList<User>).add(user)
}

fun Ownership.removeManager(user: User) {
    (owners as MutableList<User>).remove(user)
}

fun Ownership.isManager(user: User): Boolean {
    return owners.contains(user)
}

fun NormalWallet.withdraw(dest: Wallet, amount: Double): Boolean {
    return bank.withdraw(dest, this, amount)
}