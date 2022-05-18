@file:Suppress("SameParameterValue")

package com.charlotte04.veldplugin

import com.charlotte04.veldplugin.commands.VeldCommandHandler
import org.bukkit.ChatColor
import org.bukkit.ChatColor.AQUA
import org.bukkit.ChatColor.GREEN
import org.bukkit.command.CommandExecutor
import org.bukkit.plugin.java.JavaPlugin


@Suppress("unused")
open class VeldPlugin : JavaPlugin(){

    var instance: VeldPlugin? = null

    override fun onEnable() {
        instance = this

        //consoleMes( "Path:" +  getPath().path.toString(), GOLD)

        regCommand("veld", VeldCommandHandler)

        fileLoad()

        consoleMes("Enabled", GREEN)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    private fun fileLoad(){

    }

    open fun consoleMes(string: String, color: ChatColor){
        this.server.consoleSender.sendMessage("[VeldPlugin]$color$string")
    }

    private fun regCommand(name: String, executor: CommandExecutor) {
        getCommand(name)?.run {
            setExecutor(executor)
            consoleMes("/$name を登録しました", AQUA)
        } ?: logger.severe("/$name を登録できませんでした")
    }
}