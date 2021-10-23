package com.adoneko.ecolution

import net.milkbowl.vault.economy.Economy
import org.bukkit.plugin.ServicePriority
import org.bukkit.plugin.java.JavaPlugin

class Ecolution : JavaPlugin() {
    private val vaultWrapper = VaultWrapper()

    companion object {
        lateinit var INSTANCE: Ecolution
    }

    override fun onEnable() {
        INSTANCE = this

        server.servicesManager.register(Economy::class.java, vaultWrapper, this, ServicePriority.Normal)
    }
}