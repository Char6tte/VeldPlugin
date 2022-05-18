@file:Suppress("SameParameterValue")

package com.charlotte04.veldplugin

import com.charlotte04.veldplugin.commands.*
import org.bukkit.ChatColor
import org.bukkit.ChatColor.*
import org.bukkit.command.CommandExecutor
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File


@Suppress("unused")
open class VeldPlugin : JavaPlugin(){

    open lateinit var instance : VeldPlugin
    private lateinit var commandsConf : YamlConfiguration

    open fun getPath(): File {
        return instance.dataFolder
    }


    override fun onEnable() {
        instance = this

        fileLoad()

        regCommand("veld", VeldCommandHandler)

        consoleMes("Enabled", GREEN)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    private fun fileLoad(){
        val commandsPath = File(getPath(), "commands.yml")

        if (File(getPath(), "commands.yml").exists()) {
            if (config.getBoolean("Plugin.Debug")
            ) consoleMes("Load commands.yml ...", GREEN)
            commandsConf = YamlConfiguration.loadConfiguration(commandsPath)
        } else {
            consoleMes(" §4commands.yml are not found", BLUE)
            return
        }

        try{
            commandsConf.contains("commands")
        } catch (var3 : Exception){
            return
        }

        commandsConf.getConfigurationSection("commands")?.getKeys(false)?.forEach{key ->
            run {
                val cmdName = key
                val classname = commandsConf.getString("commands.$key.classname")
            }
        }

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