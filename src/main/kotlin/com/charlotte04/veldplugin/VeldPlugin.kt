package com.charlotte04.veldplugin

import com.charlotte04.veldplugin.commands.VeldCommandHandler
import org.bukkit.ChatColor
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

    fun consoleMes(string: String, color: ChatColor){
        this.server.consoleSender.sendMessage("[VariousCore]$color$string")
    }

    private fun regCommand(name: String, executor: CommandExecutor) {
        getCommand(name)?.run {
            setExecutor(executor)
            consoleMes("/$name を登録しました", ChatColor.AQUA)
        } ?: logger.severe("/$name を登録できませんでした")
    }
}