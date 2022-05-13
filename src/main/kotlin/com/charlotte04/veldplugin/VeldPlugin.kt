package com.charlotte04.veldplugin

import com.charlotte04.veldplugin.commands.VeldCommandHandler
import org.bukkit.command.CommandExecutor
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.plugin.java.annotation.command.Command
import org.bukkit.plugin.java.annotation.command.Commands
import org.bukkit.plugin.java.annotation.plugin.ApiVersion
import org.bukkit.plugin.java.annotation.plugin.Plugin
import org.bukkit.plugin.java.annotation.plugin.author.Author


@Plugin(name = "VeldPlugin", version = "0.1")
@ApiVersion(ApiVersion.Target.v1_18)
@Author("Char6tte")
@Commands(
    Command(name = "veld")
)

class VeldPlugin : JavaPlugin(){


    override fun onEnable() {
        // Plugin startup logical
        server.consoleSender.sendMessage("[Veld]Enabled")
        regCommand("veld", VeldCommandHandler)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    fun fileLoad(){

    }

    private fun regCommand(command:String, executor:CommandExecutor){
        getCommand(command)?.setExecutor(executor)
    }
}