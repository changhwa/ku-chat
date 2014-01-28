package io.kuchat.client

import io.kuchat.client.view.LoginFrame

class ClientApp {

    public static void main(String[] args) {
//        def json = "{" +
//                "   \"json\":{" +
//                "      \"header\":\"auth\"," +
//                "      \"actionType\":\"login\"," +
//                "      \"data\":{" +
//                "         \"id\":\"1\"," +
//                "         \"pw\":\"1234\"," +
//                "         \"email\":\"test1@narratage.com\"" +
//                "      }" +
//                "   }" +
//                "}\n"
//        Socket socket = new Socket("localhost", 9000)
//        socket.withStreams {input, output ->
//            output << json
//            def reader = input.newReader()
//            String result = reader.readLine()
//            println result
//        }

        LoginFrame.loginViewFrame()
    }
}
