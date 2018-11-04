package fr.toporando.app.util

import java.io.UnsupportedEncodingException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * Created by Rémi de Chazelles on 15/10/18.
 */
object Gravatar {

    private fun hex(array: ByteArray): String {
        val hexString = StringBuffer()
        for (byte in array) {
            val hex = Integer.toHexString(0xFF and byte.toInt())
            if (hex.length == 1) hexString.append('0')

//            val b:Byte = (byte and 0xFF) || 0x100
//            sb.append(Integer.toHexString(b.substring(1, 3)))
        }
        return hexString.toString()
    }

    fun md5Hex(message: String): String? {
        try {
            val md = MessageDigest.getInstance("MD5")
            return hex(md.digest(message.toByteArray(charset("CP1252"))))
        } catch (e: NoSuchAlgorithmException) {
        } catch (e: UnsupportedEncodingException) {
        }

        return null
    }
}
