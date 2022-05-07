package com.charlotte04.veldplugin.commands

import com.charlotte04.veldplugin.util.LoadPanels
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object VeldCommandHandler : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        when(args[0]){
            "setting"-> {
            }
            "menu" -> {
                LoadPanels()
            }
            else ->{

            }
        }

        return true
    }

}
