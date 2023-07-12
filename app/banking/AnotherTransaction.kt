import app.banking.TransactionType

data class AnotherTransaction(
    val id: String,
    val type: TransactionType,
    val amount: Double
) {
    fun applyTransaction() {
        when (type) {
            TransactionType.DEPOSIT -> println("Deposit transaction of $amount")
            TransactionType.WITHDRAW -> println("Withdraw transaction of $amount")
            TransactionType.TRANSFER -> println("Transfer transaction of $amount")
        }
    }
}