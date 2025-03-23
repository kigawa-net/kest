package net.kigawa.kest.cmd

import net.kigawa.kest.logger
import kotlin.io.path.Path
import kotlin.io.path.notExists

class ExecuteCmd : CmdBase() {
    private val logger = logger()
    override suspend fun execute(argList: MutableList<String>) {
        val arg = argList.firstOrNull()
        if (arg == null) {
            logger.error("need a file path")
            return
        }
        val file = Path(arg)
        if (file.notExists()) {
            logger.error("file does not exists")
            return
        }

    }
}