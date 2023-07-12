package app.banking

import java.util.Scanner
import kotlin.random.Random

// BankAccount and Transaction classes from the previous code should be moved to separate files in your actual project
// ... (Include BankAccount, Transaction, TransactionType, generateTransactionID, and processTransaction functions here)

// Helper function to read a double value from the user
fun readDouble(message: String): Double {
    val input = Scanner(System.`in`)
    print(message)
    return input.nextDouble()
}

fun readAccount(accounts: List<BankAccount>, message: String): BankAccount? {
    val input = Scanner(System.`in`)
    print(message)
    val accountNumber = input.next()
    return accounts.find { it.accountNumber == accountNumber }
}

fun main() {
    // Create sample bank accounts
    val accounts = listOf(
        BankAccount("A12345", 1000.0),
        BankAccount("B67890", 500.0)
    )

    // Print initial account balances
    println("Initial Balances:")
    accounts.forEach { it.displayBalance() }

    while (true) {
        println("\nSelect an operation: (D)eposit, (W)ithdraw, (T)ransfer, (B)alances, (Q)uit")
        val input = Scanner(System.`in`)
        val operation = input.next().toLowerCase()
        
        if (operation == "q") {
            println("Goodbye!")
            break
        }

        when (operation) {
            
            "d" -> {
                val toAccount = readAccount(accounts, "Enter the account number to deposit to: ")
                if (toAccount == null) {
                    println("Account not found.")
                } else {
                    val amount = readDouble("Enter deposit amount: $")
                    val depositTransaction = Transaction(generateTransactionID(), BankAccount("", 0.0), toAccount, amount, TransactionType.DEPOSIT)
                    processTransaction(depositTransaction)
                }
            }
            "w" -> {
                val fromAccount = readAccount(accounts, "Enter the account number to withdraw from: ")
                if (fromAccount == null) {
                    println("Account not found.")
                } else {
                    val amount = readDouble("Enter withdrawal amount: $")
                    val withdrawTransaction = Transaction(generateTransactionID(), fromAccount, null, amount, TransactionType.WITHDRAW)
                    processTransaction(withdrawTransaction)
                }
            }
            "t" -> {
                val fromAccount = readAccount(accounts, "Enter the account number to transfer from: ")
                val toAccount = readAccount(accounts, "Enter the account number to transfer to: ")
                if (fromAccount == null || toAccount == null) {
                    println("Account not found.")
                } else {
                    val amount = readDouble("Enter transfer amount: $")
                    val transferTransaction = Transaction(generateTransactionID(), fromAccount, toAccount, amount, TransactionType.TRANSFER)
                    processTransaction(transferTransaction)
                }
            }
            "b" -> {
                println("Current Balances:")
                accounts.forEach { it.displayBalance() }
            }
            else -> println("Invalid operation. Please try again.")
        }
    }
}