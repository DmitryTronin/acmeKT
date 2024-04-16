package banking

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