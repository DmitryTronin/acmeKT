package banking

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    println("Welcome to banking app")
    
    val validUserNames = listOf("karl", "johan", "sophie", "manuel", "lucas", "emma", "liam", "noah", "mila", "lina")
    
    println("Please log in using username:")
    
    val name = scanner.nextLine()
    if(!validUserNames.contains(name)) {
        println("Invalid username")
        return
    }       
    
    
    val account = Account()
    val user = User(name, account)
    
    var exit = false
    
    while (!exit) {
        println("\nAvailable operations:")
        println("1: Deposit")
        println("2: Withdraw")
        println("3: Check balance")
        println("4: Exit")
        
        when(scanner.nextInt()) {
            1 -> {
                println("Enter amount to deposit: ")
                val amount = scanner.nextDouble()
                scanner.nextLine() // consume the newline character
                user.account.deposit(amount)
            }
            2 -> {
                println("Enter amount to withdraw: ")
                val amount = scanner.nextDouble()
                scanner.nextLine() // consume the newline character
                user.account.withdraw(amount)
            }
            3 -> user.displayBalance()
            4 -> exit = true
            else -> println("Invalid operation. Try again.")
        }
    }
}