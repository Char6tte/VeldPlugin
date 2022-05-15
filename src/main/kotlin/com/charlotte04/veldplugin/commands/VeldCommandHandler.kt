package com.charlotte04.veldplugin.commands

import com.charlotte04.veldplugin.VeldPlugin
import com.charlotte04.veldplugin.util.LoadPanels
import org.bukkit.ChatColor.AQUA
import org.bukkit.ChatColor.RED
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object VeldCommandHandler : CommandExecutor , VeldPlugin() {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.isNotEmpty()) {
            when (args[0]) {
                "setting" -> {
                }
                "menu" -> {
                    LoadPanels()
                }
                else -> {

                }
            }
        }else{
            consoleMes("=======VeldPlugin=======",RED)
            consoleMes("/ve setting",AQUA)
            consoleMes("========================",RED)
        }
        return true
    }

}
