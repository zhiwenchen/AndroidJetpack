package com.yixin.studykotlin

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

/**
 *  线程间通信Channel学习
 */
class ChannelTest {

    fun channelTest1() {
        var channel = Channel<String>()
        GlobalScope.launch {
            var count = 0
            while (true) {
                Thread.sleep(1000)
                count++
                var sendStr = "fish $count"
                channel.send(sendStr)
            }
        }

        GlobalScope.launch {
            while (true) {
                Thread.sleep(1000)
                println("receive:${channel.receive()}")
            }
        }

    }


}