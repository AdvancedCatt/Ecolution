package com.adoneko.ecolution.websocket

import com.adoneko.ecolution.exception.BadTokenException
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.websocket.*

class WebSocketServer {
    init {
        embeddedServer(Netty, module = Application::ws, port = 7073)
    }
}

fun Application.ws() {
    install(WebSockets)

    install(StatusPages) {
        exception<BadTokenException> {
            call.respond(HttpStatusCode.NotAcceptable)
        }
    }

    routing {
        webSocket("/bank/transaction") {
            val bankToken = call.request.header("bank_token") ?: throw BadTokenException()

            incoming.
        }
    }
}