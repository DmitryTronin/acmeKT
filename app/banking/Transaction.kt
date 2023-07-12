// Transaction Data Class
data class Transaction(
    val transactionID: String,
    val fromAccount: BankAccount,
    val toAccount: BankAccount?,
    val amount: Double,
    val type: TransactionType
)
