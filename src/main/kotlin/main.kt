const val wasOnline = "был(а) в сети "
const val minuteWord1 = "минут"
const val minuteWord2 = "минуту"
const val minuteWord3 = "минуты"
const val hourWord1 = "час"
const val hourWord2 = "часов"
const val hourWord3 = "часа"


fun main() {
    println(agoToText(1))
    println(agoToText(61))
    println(agoToText(1000))
    println(agoToText(1200))
    println(agoToText(1500))
    println(agoToText(2000))
    println(agoToText(3200))
    println(agoToText(3700))
    println(agoToText(8000))
    println(agoToText(86500))
    println(agoToText(172900))
}

fun agoToText(seconds: Int): String {
    return when (seconds) {
        in 0..60 -> wasOnline + "только что"
        in 61..60 * 60 -> wasOnline + (seconds / 60) + " " + getMinutesWord(seconds) + " назад"
        in (60 * 60 + 1)..(24 * 60 * 60) -> wasOnline + (seconds / (60 * 60)) + " " + getHoursWord(seconds) + " назад"
        in (24 * 60 * 60 + 1)..(48 * 60 * 60) -> wasOnline + "сегодня"
        in 48 * 60 * 60 + 1..72 * 60 * 60 -> wasOnline + "вчера"
        else -> "был(а) в сети давно"
    }
}

fun getMinutesWord(seconds: Int): String {
    val minutes = seconds / 60
    return when {
        minutes % 100 in 5..20 || seconds == 0 -> minuteWord1
        minutes % 10 == 1 -> minuteWord2
        minutes % 10 in 2..4 -> minuteWord3
        else -> minuteWord1
    }
}

fun getHoursWord(seconds: Int): String {
    val hours = seconds / (60 * 60)
    return when {
        hours % 100 in 5..20 || seconds == 0 -> hourWord1
        hours % 10 == 1 -> hourWord2
        hours % 10 in 2..4 -> hourWord3
        else -> hourWord1
    }
}