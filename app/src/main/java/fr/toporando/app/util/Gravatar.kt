package fr.toporando.app.util

import java.security.MessageDigest

/**
 * Created by Rémi de Chazelles on 15/10/18.
 */
object Gravatar {

    @Throws(Exception::class)
    fun String.md5(): String {
        val md = MessageDigest.getInstance("MD5")
        md.update(this.toByteArray())

        val byteData = md.digest()
        val hexString = StringBuffer()
        for (i in byteData.indices) {
            val hex = Integer.toHexString(255 and byteData[i].toInt())
            if (hex.length == 1) hexString.append('0')
            hexString.append(hex)
        }

        return hexString.toString()
    }

    fun gravatarUrl(email: String, size: Int = 80): String {
        val hash = email.trim().toLowerCase().md5()
        return "https://www.gravatar.com/avatar/$hash?s=$size"
    }
}
