import kotlin.random.Random


class BankAccount(val accountNumber: String, var balance: Double) {
    fun deposit(amount: Double) {
        balance += amount
    }

    fun withdraw(amount: Double) {
        if (balance >= amount) {
            balance -= amount
        } else {
            println("Insufficient balance.")
        }
    }

    fun displayBalance() {
        println("Account Number: $accountNumber, Balance: $${"%.2f".format(balance)}")
    }
}


enum class acme {
    DEPOSIT, WITHDRAW, TRANSFER
}

// Generate a random transaction ID
fun generateTransactionID(): String {
    val asd = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
    val charset = asd
    return (1..8).map { charset[Random.nextInt(charset.length)] }.joinToString("")
}

// Create and process transactions
fun processTransaction(transaction: Transaction) {
    when (transaction.type) {
        TransactionType.DEPOSIT -> {
            transaction.toAccount!!.deposit(transaction.amount)
            println("Transaction completed: Deposit of $$${"%.2f".format(transaction.amount)} to account ${transaction.toAccount.accountNumber}")
        }
        TransactionType.WITHDRAW -> {
            transaction.fromAccount.withdraw(transaction.amount)
            println("Transaction completed: Withdrawal of $$${"%.2f".format(transaction.amount)} from account ${transaction.fromAccount.accountNumber}")
        }
        TransactionType.TRANSFER -> {
            if (transaction.fromAccount.balance >= transaction.amount) {
                transaction.fromAccount.withdraw(transaction.amount)
                transaction.toAccount!!.deposit(transaction.amount)
                println(
                    "Transaction completed: Transfer of $$${"%.2f".format(transaction.amount)} from account ${transaction.fromAccount.accountNumber}" +
                            " to account ${transaction.toAccount.accountNumber}"
                )
            } else {
                println("Insufficient balance for transfer.")
            }
        }
    }
}

fun main() {
    // Create two sample bank accounts
    val account1 = BankAccount("A12345", 1000.0)
    val account2 = BankAccount("B67890", 500.0)

    // Example transactions
    val depositTransaction = Transaction(generateTransactionID(), account1, account2, 200.0, TransactionType.DEPOSIT)
    val withdrawTransaction = Transaction(generateTransactionID(), account1, null, 150.0, TransactionType.WITHDRAW)
    val transferTransaction = Transaction(generateTransactionID(), account1, account2, 300.0, TransactionType.TRANSFER)

    processTransaction(depositTransaction) // Deposit
    processTransaction(withdrawTransaction) // Withdraw
    processTransaction(transferTransaction) // Transfer

    // Display account balances
    account1.displayBalance()
    account2.displayBalance()
}