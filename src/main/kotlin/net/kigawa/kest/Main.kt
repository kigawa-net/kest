package net.kigawa.kest

import ch.qos.logback.classic.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import net.kigawa.kest.config.EnvironmentConfig
import org.slf4j.LoggerFactory

object Main {
    val config by lazy { EnvironmentConfig() }
    private val logger = logger()

    init {
        val root = LoggerFactory.getLogger("root") as Logger
        root.level = config.logLevel
        logger.info("log level: ${config.logLevel}")
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val argList = args.toMutableList()
        while (argList.isNotEmpty()) {
            val first = argList.removeFirst()
            Cmds.entries.forEach { cmd ->
                if (first == cmd.command) {
                    val job = CoroutineScope(Dispatchers.Default).launch {
                        cmd.execute(argList)
                    }
                    runBlocking { job.join() }
                    logger.info("job completed ${cmd.command}")
                    return
                }
            }
        }
        logger.error("subcommand not found")
    }
}