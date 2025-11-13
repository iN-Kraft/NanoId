package dev.datlag.inkraft

import kotlin.random.Random
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.fail

class NanoIdTest {

    @Test
    @Ignore
    fun `verify 100k random nano ids are unique`() {
        val idCount = 100000
        val ids = hashSetOf<String>()

        for (i in 0 until idCount) {
            val id = NanoId.generate()

            if (ids.contains(id)) {
                fail("Non-unique ID generated: $id")
            } else {
                ids.add(id)
            }
        }
    }

    @Test
    fun `seeded random`() {
        val random = Random(12345)
        val expectedIds = arrayOf(
            "CBf3MTFR_-Yje-f5imwBO",
            "J-6TdBAz6_lc9OZ1E1J8H",
            "H3dTyOKNz5Q2POgun3BBD",
            "p_V_DgrPnjHn9OxAVuJtO",
            "OQCnbHGL6r-C5ocjxt6J9"
        )

        for (expectedId in expectedIds) {
            val generatedId = NanoId.generate(random)
            assertEquals(expectedId, generatedId)
        }
    }

    @Test
    @Ignore
    fun `various sizes`() {
        for (size in 1 until 1001) {
            val id = NanoId.generate(size = size)

            assertEquals(size, id.length)
        }
    }

    @Test
    fun `empty alphabet`() {
        assertFails {
            NanoId.generate(alphabet = "")
        }
    }

    @Test
    fun `too large alphabet`() {
        val alphabet = buildString {
            for (i in 0 until 256) {
                append(i.toChar())
            }
        }

        assertFails {
            NanoId.generate(alphabet = alphabet)
        }
    }

    @Test
    fun `negative size`() {
        assertFails {
            NanoId.generate(size = -10)
        }
    }

    @Test
    fun `zero size`() {
        assertFails {
            NanoId.generate(size = 0)
        }
    }
}