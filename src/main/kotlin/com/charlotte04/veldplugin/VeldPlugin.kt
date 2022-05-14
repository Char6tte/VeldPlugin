package com.charlotte04.veldplugin

import com.charlotte04.veldplugin.commands.VeldCommandHandler
import org.bukkit.command.CommandExecutor
import org.bukkit.plugin.java.JavaPlugin

class VeldPlugin : JavaPlugin(){


    override fun onEnable() {
        // Plugin startup logical
        server.consoleSender.sendMessage("[Veld]Enabled")

        //commands startup
        regCommand("veld", VeldCommandHandler)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    fun fileLoad(){

    }

    private fun regCommand(name :String, executor:CommandExecutor){
        getCommand(name)?.setExecutor(executor)
    }
}