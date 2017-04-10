package com.cto3543.exokotlin.block

import java.io.UnsupportedEncodingException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import kotlin.experimental.and


@Throws(NoSuchAlgorithmException::class, UnsupportedEncodingException::class)
fun SHA1(text: String): String {
    val md = MessageDigest.getInstance("SHA-1")
    val textBytes = text.toByteArray(charset("iso-8859-1"))
    md.update(textBytes, 0, textBytes.size)
    val sha1hash = md.digest()
    return convertToHex(sha1hash)
}

private fun convertToHex(data: ByteArray): String {
    val buf = StringBuilder()
    for (b: Byte in data) {
        var halfbyte = b.toInt().ushr(4) and 0x0F
        var two_halfs = 0
        do {
            buf.append(if (0 <= halfbyte && halfbyte <= 9) ('0' + halfbyte).toChar() else ('a' + (halfbyte - 10)).toChar())
            halfbyte = (b and 0x0F).toInt()
        } while (two_halfs++ < 1)
    }
    return buf.toString()
}