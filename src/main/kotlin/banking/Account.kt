package banking

class Account {
    var balance: Double = 0.0

    fun deposit(amount: Double) {
        balance += amount
    }

    fun withdraw(amount: Double) {
        if (balance >= amount) {
            balance -= amount
        } else {
            println("Insufficient balance")
        }
    }
}