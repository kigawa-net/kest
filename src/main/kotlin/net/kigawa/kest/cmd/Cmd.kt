package net.kigawa.kest.cmd

interface Cmd {
    suspend fun execute(argList: MutableList<String>)
}
