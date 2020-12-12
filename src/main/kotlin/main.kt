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
        cardType(card, money)
    }
}

fun cardType(card: Int = 3, money: Int, moneySent: Int = 0) {
    return when (card) {
        1 -> masterMaestroCommission(money, moneySent)
        2 -> visaMirCommission(money)
        else -> vkPayCommission()
    }
}

fun masterMaestroCommission(moneySent: Int, money: Int) {
    when {
        moneySent < 75_000 * 100 -> println("�������� �� ���������")
        else -> {
            val userCommission = (money * 0.006 + 20 * 100).roundToInt().toDouble() / 100
            println("��������: $userCommission ������")
        }
    }
}

fun visaMirCommission(money: Int) {
    val commission = 0.0075
    val minimalSum = 3500
    val userCommission: Double

    if (money >= minimalSum) {
        userCommission = (money * commission).roundToInt().toDouble() / 100
        println("����� �������� $userCommission ������")
    } else {
        println("�������� ������� ������ �� 35 ������")
    }
}

fun vkPayCommission() {
    println("�������� �� ���������")
}