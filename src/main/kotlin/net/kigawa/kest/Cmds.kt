package net.kigawa.kest

import net.kigawa.kest.cmd.ExecuteCmd
import net.kigawa.kest.cmd.Cmd

enum class Cmds(
    val command: String,
    val newTask: () -> Cmd,
) {
    BACKUP("exec", ::ExecuteCmd),
    ;

    suspend fun execute(argList: MutableList<String>) = newTask().execute(argList)
}