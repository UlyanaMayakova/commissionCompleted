import kotlin.math.roundToInt

fun main() {
    println(
        """
        �������� ��� ����� ����� (������� ����� �� 1 �� 3):
        1. Mastercard ��� Maestro
        2. Visa ��� ���
        3. VK Pay
        """
    )
    val card: Int = readLine()!!.toInt()

    println("������� ����� ��������� � ���� ������")
    val moneySent = readLine()!!.toInt() * 100
    if (moneySent > 600_000 * 100) {
        println("�������� ����� ����� �������� �� �����")
    } else {
        println("������� ����� ��������")
        val money = readLine()!!.toInt() * 100
        if (card == 2 && money < 35 * 100) {
            println("�������� ������� ������ �� 35 ������")
        } else {
            val userCommission = cardType(card, money, moneySent)
            val commission = userCommission / 100
            println("�������� ��������� $commission ������")
        }
    }
}

fun cardType(card: Int = 3, money: Int, moneySent: Int = 0): Int {
    return when (card) {
        1 -> masterMaestroCommission(money, moneySent)
        2 -> visaMirCommission(money)
        else -> vkPayCommission()
    }
}

fun masterMaestroCommission(money: Int, moneySent: Int): Int {
    return when {
        moneySent < 75_000 * 100 -> 0
        else -> {
            val userCommission = (money * 0.006 + 20 * 100).roundToInt()
            userCommission
        }
    }
}

fun visaMirCommission(money: Int): Int {
    val commission = 0.0075
    return (money * commission).roundToInt()
}

fun vkPayCommission(): Int {
    return 0
}