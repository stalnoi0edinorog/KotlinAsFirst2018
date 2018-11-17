package lesson5.task1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class Tests {
    @Test
    @Tag("Example")
    fun shoppingListCostTest() {
        val itemCosts = mapOf(
                "Хлеб" to 50.0,
                "Молоко" to 100.0
        )
        assertEquals(
                150.0,
                shoppingListCost(
                        listOf("Хлеб", "Молоко"),
                        itemCosts
                )
        )
        assertEquals(
                150.0,
                shoppingListCost(
                        listOf("Хлеб", "Молоко", "Кефир"),
                        itemCosts
                )
        )
        assertEquals(
                0.0,
                shoppingListCost(
                        listOf("Хлеб", "Молоко", "Кефир"),
                        mapOf()
                )
        )
    }

    @Test
    @Tag("Example")
    fun filterByCountryCode() {
        val phoneBook = mutableMapOf(
                "Quagmire" to "+1-800-555-0143",
                "Adam's Ribs" to "+82-000-555-2960",
                "Pharmakon Industries" to "+1-800-555-6321"
        )

        filterByCountryCode(phoneBook, "+1")
        assertEquals(2, phoneBook.size)

        filterByCountryCode(phoneBook, "+1")
        assertEquals(2, phoneBook.size)

        filterByCountryCode(phoneBook, "+999")
        assertEquals(0, phoneBook.size)
    }

    @Test
    @Tag("Example")
    fun removeFillerWords() {
        assertEquals(
                "Я люблю Котлин".split(" "),
                removeFillerWords(
                        "Я как-то люблю Котлин".split(" "),
                        "как-то"
                )
        )
        assertEquals(
                "Я люблю Котлин".split(" "),
                removeFillerWords(
                        "Я как-то люблю таки Котлин".split(" "),
                        "как-то",
                        "таки"
                )
        )
        assertEquals(
                "Я люблю Котлин".split(" "),
                removeFillerWords(
                        "Я люблю Котлин".split(" "),
                        "как-то",
                        "таки"
                )
        )
    }

    @Test
    @Tag("Example")
    fun buildWordSet() {
        assertEquals(
                buildWordSet("Я люблю Котлин".split(" ")),
                mutableSetOf("Я", "люблю", "Котлин")
        )
        assertEquals(
                buildWordSet("Я люблю люблю Котлин".split(" ")),
                mutableSetOf("Котлин", "люблю", "Я")
        )
        assertEquals(
                buildWordSet(listOf()),
                mutableSetOf<String>()
        )
    }

    @Test
    @Tag("Normal")
    fun mergePhoneBooks() {
        assertEquals(
                mapOf("Emergency" to "112"),
                mergePhoneBooks(
                        mapOf("Emergency" to "112"),
                        mapOf("Emergency" to "112")
                )
        )
        assertEquals(
                mapOf("Emergency" to "112", "Police" to "02"),
                mergePhoneBooks(
                        mapOf("Emergency" to "112"),
                        mapOf("Emergency" to "112", "Police" to "02")
                )
        )
        assertEquals(
                mapOf("Emergency" to "112, 911", "Police" to "02"),
                mergePhoneBooks(
                        mapOf("Emergency" to "112"),
                        mapOf("Emergency" to "911", "Police" to "02")
                )
        )
        assertEquals(
                mapOf("Emergency" to "112, 911", "Fire department" to "01", "Police" to "02"),
                mergePhoneBooks(
                        mapOf("Emergency" to "112", "Fire department" to "01"),
                        mapOf("Emergency" to "911", "Police" to "02")
                )
        )
    }

    @Test
    @Tag("Easy")
    fun buildGrades() {
        assertEquals(
                mapOf<Int, List<String>>(),
                buildGrades(mapOf())
        )
        // TODO: Sort the values here or let the students do it?
        assertEquals(
                mapOf(5 to listOf("Семён", "Михаил"), 3 to listOf("Марат")),
                buildGrades(mapOf("Марат" to 3, "Семён" to 5, "Михаил" to 5))
        )
        assertEquals(
                mapOf(3 to listOf("Семён", "Михаил", "Марат")),
                buildGrades(mapOf("Марат" to 3, "Семён" to 3, "Михаил" to 3))
        )
    }

    @Test
    @Tag("Easy")
    fun containsIn() {
        assertTrue(containsIn(mapOf("a" to "z"), mapOf("a" to "z", "b" to "sweet")))
        assertFalse(containsIn(mapOf("a" to ""), mapOf("a" to "z", "b" to "sweet")))
        assertFalse(containsIn(mapOf("a" to "z"), mapOf("a" to "zee", "b" to "sweet")))
        assertFalse(containsIn(mapOf("a" to "z", "am" to "nott"), mapOf("a" to "z", "b" to "sweet")))
        assertTrue(containsIn(mapOf("b" to "ne", "a" to "z", "k" to "m"), mapOf("a" to "z", "b" to "ne", "k" to "m", "l" to "sweet")))
        assertFalse(containsIn(mapOf("b" to "ne", "a" to "0", "k" to "m"), mapOf("a" to "z", "b" to "ne", "k" to "m", "l" to "sweet")))


    }

    @Test
    @Tag("Normal")
    fun averageStockPrice() {
        assertEquals(
                mapOf<String, Double>(),
                averageStockPrice(listOf())
        )
        assertEquals(
                mapOf("MSFT" to 100.0, "NFLX" to 40.0),
                averageStockPrice(listOf("MSFT" to 100.0, "NFLX" to 40.0))
        )
        assertEquals(
                mapOf("MSFT" to 150.0, "NFLX" to 40.0),
                averageStockPrice(listOf("MSFT" to 100.0, "MSFT" to 200.0, "NFLX" to 40.0))
        )
        assertEquals(
                mapOf("MSFT" to 150.0, "NFLX" to 45.0),
                averageStockPrice(listOf("MSFT" to 100.0, "MSFT" to 200.0, "NFLX" to 40.0, "NFLX" to 50.0))
        )
    }

    @Test
    @Tag("Normal")
    fun findCheapestStuff() {
        assertNull(
                findCheapestStuff(
                        mapOf("Мария" to ("печенье" to 20.0), "Орео" to ("печенье" to 100.0)),
                        "торт"
                )
        )
        assertEquals(
                "Мария",
                findCheapestStuff(
                        mapOf("Мария" to ("печенье" to 20.0), "Орео" to ("печенье" to 100.0)),
                        "печенье"
                )
        )
        assertEquals(
                "Мария",
                findCheapestStuff(
                        mapOf("Мария" to ("печенье" to Double.MAX_VALUE)),
                        "печенье"
                )
        )
        assertEquals(
                "\\?6`t;ADupy1D1F6[-c!X*/=[5c$\tK\tbO0|2b5Y{/fkK7^oyk=A<A\n6=U*vZ'/@v(=\nJgtA#|13Pc=$3>aoP\nO\\SjJC3x &-VD0\"k xI^98k.KJ]x@qKzKiL2!O#(L$<g*$*<]@bQ,EBEy;7!.nvPn\nb2jdl1dM0Av!gpoT!\tcuT+ZKdk^}\n~UWt]yDFu V@7",
                findCheapestStuff(
                        mapOf(
                                "W" to ("q ?zCM6y?ST1dM q!y.`4UN'E4C@=@%k`lFT+;SR:}>Htk`~\\\"%\$~uMoL('T|%TU\$!]V<D6FH?-Q>5kF\\\"rp/Nj<bi2I GP9}~_(\\\\\\\"XO#=EQdi\\n:~Y#Sk$\\\\gm%z1[P4Izo[~I46V~wJ;P\$!N[:~g 40c&_-S1x" to 0.17145688151946714),
                                "f" to ("89" to 0.4113725541983201),
                                "\"\"" to ("6" to 0.7334655249825457),
                                "\\?6`t;ADupy1D1F6[-c!X*/=[5c$\tK\tbO0|2b5Y{/fkK7^oyk=A<A\n6=U*vZ'/@v(=\nJgtA#|13Pc=$3>aoP\nO\\SjJC3x &-VD0\"k xI^98k.KJ]x@qKzKiL2!O#(L$<g*$*<]@bQ,EBEy;7!.nvPn\nb2jdl1dM0Av!gpoT!\tcuT+ZKdk^}\n~UWt]yDFu V@7"
                                        to ("\"\"" to 1.7976931348623157e+308)
                        ),
                        "\"\""

                )
        )
    }

    @Test
    @Tag("Hard")
    fun propagateHandshakes() {
        assertEquals(
                mapOf(
                        "Marat" to setOf("Mikhail", "Sveta"),
                        "Sveta" to setOf("Mikhail"),
                        "Mikhail" to setOf()
                ),
                propagateHandshakes(
                        mapOf(
                                "Marat" to setOf("Sveta"),
                                "Sveta" to setOf("Mikhail")
                        )
                )
        )
        assertEquals(
                mapOf(
                        "Marat" to setOf("Mikhail", "Sveta"),
                        "Sveta" to setOf("Marat", "Mikhail"),
                        "Mikhail" to setOf("Sveta", "Marat")
                ),
                propagateHandshakes(
                        mapOf(
                                "Marat" to setOf("Mikhail", "Sveta"),
                                "Sveta" to setOf("Marat"),
                                "Mikhail" to setOf("Sveta")
                        )
                )
        )
        assertEquals(
                mapOf(
                        "Marat" to setOf(),
                        "Sveta" to setOf("Marat"),
                        "Mikhail" to setOf("Sveta", "Marat")
                ),
                propagateHandshakes(
                        mapOf(
                                "Sveta" to setOf("Marat"),
                                "Mikhail" to setOf("Sveta")
                        )
                )
        )
        assertEquals(
                mapOf(
                        "0" to setOf("5f", "135", "154", "15d", "1", "12", "fb", "194"),
                        "135" to setOf("154", "15d", "5f", "1", "0", "12", "fb", "194"),
                        "15d" to setOf("12", "135", "194", "fb", "154", "0", "5f", "1"),
                        "1" to setOf("0", "135", "fb", "5f", "12", "15d", "154", "194"),
                        "12" to setOf("194", "135", "15d", "fb", "154", "0", "5f", "1"),
                        "194" to setOf("135", "12", "15d", "154", "5f", "1", "0", "fb"),
                        "fb" to setOf("0", "135", "15d", "1", "12", "154", "194", "5f"),
                        "154" to setOf("15d", "12", "135", "194", "fb", "0", "5f", "1"),
                        "5f" to setOf("135", "154", "15d", "1", "0", "12", "fb", "194")

                ),
                propagateHandshakes(
                        mapOf(
                                "0" to setOf("5f"),
                                "135" to setOf("154", "15d", "5f", "1", "0", "12", "fb", "194"),
                                "15d" to setOf("12", "135"),
                                "1" to setOf("0", "135", "fb", "5f", "12", "15d", "154", "194"),
                                "12" to setOf("194", "135", "15d", "fb", "154", "0"),
                                "194" to setOf("135", "12", "15d"),
                                "fb" to setOf("0", "135", "15d", "1", "12", "154", "194"),
                                "154" to setOf("15d"),
                                "5f" to setOf("135")

                        )
                )
        )

    }

    @Test
    @Tag("Easy")
    fun subtractOf() {
        val from = mutableMapOf("a" to "z", "b" to "c")

        subtractOf(from, mapOf())
        assertEquals(from, mapOf("a" to "z", "b" to "c"))

        subtractOf(from, mapOf("b" to "z"))
        assertEquals(from, mapOf("a" to "z", "b" to "c"))

        subtractOf(from, mapOf("a" to "z"))
        assertEquals(from, mapOf("b" to "c"))
    }

    @Test
    @Tag("Easy")
    fun whoAreInBoth() {
        assertEquals(
                emptyList<String>(),
                whoAreInBoth(emptyList(), emptyList())
        )
        assertEquals(
                listOf("Marat"),
                whoAreInBoth(listOf("Marat", "Mikhail"), listOf("Marat", "Kirill"))
        )
        assertEquals(
                emptyList<String>(),
                whoAreInBoth(listOf("Marat", "Mikhail"), listOf("Sveta", "Kirill"))
        )
        assertEquals(
                listOf("Marat", "Julia"),
                whoAreInBoth(listOf("Marat", "Mikhail", "Julia"), listOf("Sveta", "Julia", "Marat", "Kirill"))
        )
        assertEquals(
                listOf("Marat", "Julia"),
                whoAreInBoth(listOf("Sveta", "Julia", "Marat", "Kirill"), listOf("Marat", "Mikhail", "Julia"))
        )
    }

    @Test
    @Tag("Normal")
    fun canBuildFrom() {
        assertFalse(canBuildFrom(emptyList(), "foo"))
        assertTrue(canBuildFrom(listOf('a', 'b', 'o'), "baobab"))
        assertFalse(canBuildFrom(listOf('a', 'm', 'r'), "Marat"))
        assertFalse(canBuildFrom(listOf('a', 'm', 'r'), "Julia"))
        assertTrue(canBuildFrom(listOf('l', 'a', 'j', 'm', 'u', 'r', 'i'), "Julia"))

    }

    @Test
    @Tag("Normal")
    fun extractRepeats() {
        assertEquals(
                emptyMap<String, Int>(),
                extractRepeats(emptyList())
        )
        assertEquals(
                mapOf("a" to 2),
                extractRepeats(listOf("a", "b", "a"))
        )
        assertEquals(
                emptyMap<String, Int>(),
                extractRepeats(listOf("a", "b", "c"))
        )
        assertEquals(
                mapOf("a" to 4, "c" to 3),
                extractRepeats(listOf("c", "a", "c", "b", "a", "a", "c", "l", "a"))
        )
    }

    @Test
    @Tag("Normal")
    fun hasAnagrams() {
        assertFalse(hasAnagrams(emptyList()))
        assertTrue(hasAnagrams(listOf("рот", "свет", "тор")))
        assertFalse(hasAnagrams(listOf("рот", "свет", "код", "дверь")))
        assertTrue(hasAnagrams(listOf("кабан", "свет", "насос", "банка", "сосна")))
    }

    @Test
    @Tag("Hard")
    fun findSumOfTwo() {
        assertEquals(
                Pair(-1, -1),
                findSumOfTwo(emptyList(), 1)
        )
        assertEquals(
                Pair(0, 2),
                findSumOfTwo(listOf(1, 2, 3), 4)
        )
        assertEquals(
                Pair(-1, -1),
                findSumOfTwo(listOf(1, 2, 3), 6)
        )
        assertEquals(
                Pair(0, 4),
                findSumOfTwo(listOf(12, 7, 8, 2, 6, 2, 3), 18)
        )
        assertEquals(
                Pair(0, 1),
                findSumOfTwo(listOf(2, 2, 3), 4)
        )
    }

    @Test
    @Tag("Impossible")
    fun bagPacking() {
        assertEquals(
                emptySet<String>(),
                bagPacking(
                        mapOf(),
                        850
                )
        )
        assertEquals(
                setOf("Кубок"),
                bagPacking(
                        mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
                        850
                )
        )
        assertEquals(
                emptySet<String>(),
                bagPacking(
                        mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
                        450
                )
        )
        assertEquals(
                setOf("Кубок", "Подтяжки для носков", "Бикини Ариэль"),
                bagPacking(
                        mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000),
                                "Подтяжки для носков" to (150 to 1500), "Бикини Ариэль" to (230 to 2200)),
                        885
                )
        )
        assertEquals(
                setOf("Слиток"),
                bagPacking(
                        mapOf("Кубок" to (500 to 2000), "Слиток" to (450 to 5000),
                                "Подтяжки для носков" to (150 to 1500), "Бикини Ариэль" to (230 to 2200)),
                        500
                )
        )
        assertEquals(
                setOf("Леопардовый халат", "Автомат по физике", "Подтяжки для носков", "Бикини Ариэль"),
                bagPacking(
                        mapOf("Кубок" to (500 to 2000), "Что-то ценное" to (885 to 2300),
                                "Леопардовый халат" to (125 to 1450), "Автомат по физике" to(50 to 1100), "Слиток" to (1000 to 5000),
                                "Подтяжки для носков" to (150 to 1500), "Бикини Ариэль" to (230 to 2200)),
                        885
                )
        )
        assertEquals(
                emptySet<String>(),
                bagPacking(
                        mapOf("Сон" to (1225 to 9999999), "Свободное время" to (1226 to 5300),
                                "Отдых" to (1250 to 1450), "Автомат по физике" to(5000 to 1100)),
                        1224
                )
        )
        assertEquals(
                setOf("21"),
                bagPacking(
                        mapOf("21" to (1 to 301), "Свободное время" to (3 to 3),
                                "Отдых" to (5 to 1450), "Автомат по физике" to(2 to 1100)),
                        1
                )
        )

    }

    // TODO: map task tests
}
