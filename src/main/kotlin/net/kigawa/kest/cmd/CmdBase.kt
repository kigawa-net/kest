package net.kigawa.kest.cmd

import net.kigawa.kest.Main

abstract class CmdBase : Cmd {
    val config
        get() = Main.config
}