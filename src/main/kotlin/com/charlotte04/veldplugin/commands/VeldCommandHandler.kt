package com.charlotte04.veldplugin.commands

import com.charlotte04.veldplugin.VeldPlugin
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object VeldCommandHandler : CommandExecutor{

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        sender.server.consoleSender.sendMessage("======== ========")
        sender.server.consoleSender.sendMessage("/veld")
        sender.server.consoleSender.sendMessage("======== ========")
        return true
    }

}
