package com.adoneko.ecolution.bank

import kotlinx.coroutines.channels.Channel

object TransactionProcessor {
    private val channel = Channel<() -> Boolean>()


}