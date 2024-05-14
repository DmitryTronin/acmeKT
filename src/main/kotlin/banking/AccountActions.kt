package banking

/**
 * The AccountActions class defines the financial operations that can be performed on a user's account.
 *
 * The class has two main properties:
 * 1. balance: which represent the current balance in the user's account.
 * 2. writeOnlyBalance: a private property that represents a second balance with write-only capabilities.
 *
 * - The class has a method deposit(), which allows depositing an amount into the account.
 *   Invalid amounts (<=0) or exceptions during the operation will cause it to fail and display a relevant message.
 *
 * - The class has a withdraw() method, which allows withdrawing an amount from the account. The Withdrawal will fail if the requested amount is
 *   less than or equal to zero, or if the balance is insufficient to cover the withdrawal. If an exception occurs during the operation,
 *   the method also fails with an error message.
 *
 * - The class includes a displayBalance() method, which displays the current balance of the account.
 *
 * - The class contains method depositBlindly(), which allows to deposit an amount to the write-only balance without any conditions.
 *
 * - The class contains method depositBlindlyAgain(), another way to deposit an amount to the write-only balance without conditions.
 *
 * - The class has a method setWriteOnlyBalance(), which allows setting the value of the write-only balance.
 */
class AccountActions {
    var balance: Double = 0.0

    private var writeOnlyBalance: Double = 0.0
        set(value) {
            balance = value
            field = value
        }

    fun deposit(amount: Double) {

        if (amount <= 0) {
            println("Deposit unsuccessful: Invalid value. Amount deposited must be greater than zero.")
        } else {
            try {
                balance += amount
                println("Deposit successful.")
            } catch (e: Exception) {
                println ("Deposit unsuccessful: An error occurred.")
            }
        }
    }

    fun withdraw(amount: Double) {
        if (amount <= 0) {
            println("Withdrawal unsuccessful: Invalid value. Amount to withdraw must be greater than zero.")
        } else if (balance < amount) {
            println("Withdrawal unsuccessful: Insufficient balance.")
        } else {
            try {
                balance -= amount
                println("Withdrawal successful.")
            } catch (e: Exception) {
                println("Withdrawal unsuccessful: An error occurred.")
            }
        }

    }
    fun displayBalance() {
        println("Your current balance is: $balance")
    }
    
    fun depositBlindly(amount: Double){
        writeOnlyBalance += amount
        println("Done")
    }
    fun depositBlindlyAgain(amount: Double){
        writeOnlyBalance += amount
        println("Done")
    }
    fun setWriteOnlyBalance(value: Double){
        writeOnlyBalance = value
    }

}