package com.charlotte04.veldplugin

import com.charlotte04.veldplugin.commands.VeldCommandHandler
import org.bukkit.ChatColor
import org.bukkit.ChatColor.AQUA
import org.bukkit.ChatColor.GREEN
import org.bukkit.command.CommandExecutor
import org.bukkit.plugin.java.JavaPlugin

open class VeldPlugin : JavaPlugin(){

    override fun onEnable() {
        // Plugin startup logical
        consoleMes("Enabled", GREEN)

        //commands startup
        regCommand("veld", VeldCommandHandler)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    fun fileLoad(){

    }



    private fun regCommand(name: String, executor: CommandExecutor) {
        getCommand(name)?.run {
            setExecutor(executor)
            consoleMes("/$name を登録しました", AQUA)
        } ?: logger.severe("/$name を登録できませんでした")
    }
}

fun VeldPlugin.consoleMes(string: String, color: ChatColor){
    this.server.consoleSender.sendMessage("[VeldPlugin]$color$string")

}