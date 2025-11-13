package dev.datlag.inkraft

import korlibs.crypto.SecureRandom
import kotlin.experimental.and
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.log
import kotlin.random.Random

data object NanoId {

    @JvmStatic
    val DEFAULT_NUMBER_GENERATOR = SecureRandom
    const val DEFAULT_ALPHABET = "_-0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    const val DEFAULT_SIZE = 12

    private fun calculateMask(alphabet: String): Int {
        return (2 shl floor(log((alphabet.length - 1).toDouble(), 2.0)).toInt()) -1
    }

    private fun calculateStep(alphabet: String, size: Int = DEFAULT_SIZE, mask: Int = calculateMask(alphabet)): Int {
        return ceil(1.6 * mask * size / alphabet.length).toInt()
    }

    @JvmStatic
    @JvmOverloads
    fun generate(
        random: Random = DEFAULT_NUMBER_GENERATOR,
        alphabet: String = DEFAULT_ALPHABET,
        size: Int = DEFAULT_SIZE
    ): String {
        require(alphabet.length in 1..255) {
            "Alphabet must contain between 1 and 255 symbols."
        }
        require(size > 0) {
            "Size must be greater than zero."
        }

        if (alphabet.length == 1) {
            return buildString {
                repeat(size) {
                    append(alphabet[0])
                }
            }
        }

        val mask = calculateMask(alphabet)
        val step = calculateStep(alphabet, size, mask)
        val bytes = ByteArray(step)

        return buildString {
            while (true) {
                random.nextBytes(bytes)

                for (i in 0 until step) {
                    val alphabetIndex = (bytes[i] and mask.toByte()).toInt()

                    if (alphabetIndex < alphabet.length) {
                        append(alphabet[alphabetIndex])

                        if (length >= size) {
                            return@buildString
                        }
                    }
                }
            }
        }
    }

}