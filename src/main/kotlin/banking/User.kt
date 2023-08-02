package banking



class User(val name: String, val account: Account) {

    fun displayBalance() {
        println("Your current balance is: ${account.balance}")
    }
}