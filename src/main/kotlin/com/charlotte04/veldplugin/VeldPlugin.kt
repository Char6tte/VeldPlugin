package com.charlotte04.veldplugin

import com.charlotte04.veldplugin.commands.VeldCommandHandler
import org.bukkit.ChatColor
import org.bukkit.ChatColor.*
import org.bukkit.command.CommandExecutor
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import java.io.File


open class VeldPlugin : JavaPlugin(){

    companion object : JavaPlugin(){
        lateinit var plugin: Plugin
    }

    open fun getPath(): File {
        return plugin.dataFolder
    }


    override fun onEnable() {

        plugin = this

        //commands startup
        regCommand("veld", VeldCommandHandler)

        consoleMes("Enabled", GREEN)
        consoleMes(getPath().path.toString(), WHITE)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    fun fileLoad(){

    }

    open fun consoleMes(string: String, color: ChatColor){
        plugin.server.consoleSender.sendMessage("[VeldPlugin]$color$string")
    }

    private fun regCommand(name: String, executor: CommandExecutor) {
        getCommand(name)?.run {
            setExecutor(executor)
            consoleMes("/$name を登録しました", AQUA)
        } ?: logger.severe("/$name を登録できませんでした")
    }
}