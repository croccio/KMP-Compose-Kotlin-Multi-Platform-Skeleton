package it.croccio.ticketshare

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform