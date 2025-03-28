package net.kigawa.kest

import org.slf4j.Logger
import org.slf4j.LoggerFactory

fun <T: Any>T.logger(): Logger = LoggerFactory.getLogger(this.javaClass)

