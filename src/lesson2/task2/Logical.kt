@file:Suppress("UNUSED_PARAMETER")
package lesson2.task2

import lesson1.task1.sqr

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
        sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    val a = (number % 100) / 10 + (number % 100) % 10
    val b = (number / 100) / 10 + (number / 100) % 10
    if (a == b) return true
    else return false
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean = TODO()


/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    if (((year%4==0) && (year%100!=0)) or (year%400==0)) {
            if (month == 2) return 29
            if ((month in 1..7 step 2) or (month in 8..12 step 2)) return 31
            else return 30
        }
    else {
        if (month == 2) return 28
        if ((month in 1..7 step 2) or (month in 8..12 step 2)) return 31
        else return 30
    }
}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(x1: Double, y1: Double, r1: Double,
                 x2: Double, y2: Double, r2: Double): Boolean {
    val a = sqr(x2 - x1) + sqr(y2 - y1)
    if (a<= sqr(r2-r1)&&(r1<r2) or ((a <= sqr(r2-r1)) && (r1==r2))) return true
    else return false
}


/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    val d = r * s
    val e = a * b
    val f = b * c
    val j = a * c
    if (e <= d) {
                if (((a <= r) or (a<= s)) && ((b <= r) or (b <= s))) return true
            }
    if (f <= d)  {
        if (((b<=r) or (b<=s)) && ((c<=r) or (c<=s))) return true
    }
    if (j<= d)    {
        if (((a<=r) or (a<=s)) && ((c<=r) or (c<=s))) return true
    }
    return false
    }

