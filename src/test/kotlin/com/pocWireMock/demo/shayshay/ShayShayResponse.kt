package com.pocWireMock.demo.shayshay

data class ShayShayResponse(
        val source : String,
        val quotes : Array<String>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ShayShayResponse

        if (source != other.source) return false
        if (!quotes.contentEquals(other.quotes)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = source.hashCode()
        result = 31 * result + quotes.contentHashCode()
        return result
    }
}