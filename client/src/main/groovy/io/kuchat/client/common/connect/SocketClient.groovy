package io.kuchat.client.common.connect

import groovy.json.JsonSlurper
import net.sf.json.JSONObject

class SocketClient {

    def client(String json, int port){

        Socket socket = new Socket("localhost", port)
        String result
        socket.withStreams {input, output ->
            output << json
            def reader = input.newReader()
            result = reader.readLine()
            println result
        }
        result
    }

}
