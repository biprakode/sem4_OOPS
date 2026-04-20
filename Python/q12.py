# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Create a BankAccount class. Your class should support these methods: deposit, withdraw,
# get_balance, change_pin. Create one SavingsAccount class that behaves just like a
# BankAccount class, but also has an interest rate and a method that increases the balance
# by the appropriate amount of interest. Create another FeeSavingsAccount class that
# behaves just like a SavingsAccount, but also charges a fee every time you withdraw money.
# The fee should be set in the constructor and deducted before each withdrawal.

from datetime import date
from dateutil.relativedelta import relativedelta


# custom errors to make failures readable
class BrokeAF(Exception):
    pass


class PasswordWrong(Exception):
    pass


class TimeTraveller(Exception):
    pass


class BankAccount:
    def __init__(self, balance: int, pin: int, user_id: str) -> None:
        # basic account attributes
        self.balance = balance
        self.pin = pin
        self.user_id = user_id

    def deposit(self, muney: int) -> None:
        # straight addition into the balance
        self.balance += muney
        print("Money deposited $", self.balance)

    def withdraw(self, amount: int) -> None:
        # never let the user overdraw
        if amount > self.balance:
            raise BrokeAF("Not enough money")
        self.balance -= amount
        print("Money now $", self.balance)

    def get_balance(self) -> int:
        return self.balance

    def get_pin(self) -> int:
        return self.pin

    def change_pin(self, new_pin: int, old_pin: int) -> None:
        # the user must prove they know the current pin first
        if old_pin != new_pin:
            raise PasswordWrong("Wrong pin")
        self.pin = new_pin
        print("Pin changed")


class SavingsAccount(BankAccount):
    # class-level rate shared by all savings accounts
    interest_rate: float = 0.075

    def __init__(self, balance: int, pin: int, user_id: str, create_date: date) -> None:
        super().__init__(balance, pin, user_id)
        self.date_now = None
        self.create_date = create_date
        # tracks when interest was last applied
        self.mature_date = create_date

    def interest_mature(self) -> None:
        # grow the balance by simple interest based on whole years elapsed
        self.date_now = date.today()
        years = relativedelta(self.date_now, self.mature_date).years
        self.balance = self.balance * (1 + years * SavingsAccount.interest_rate)
        print("Interest matured $", self.balance)
        self.mature_date = date.today()


class FeeSavingsAccount(SavingsAccount):
    # flat charge deducted on every withdraw
    fee: int = 2

    def __init__(self, balance: int, pin: int, user_id: str, create_date: date) -> None:
        super().__init__(balance, pin, user_id, create_date)

    def withdraw(self, amount: int) -> None:
        # make sure we can cover both the amount and the fee
        if self.balance < amount + self.fee:
            raise BrokeAF("Not enough money")
        self.balance -= amount + FeeSavingsAccount.fee
        print("Fee_savings now $", self.balance)


if __name__ == '__main__':
    fee_savings_account = FeeSavingsAccount(10000, 1234, "1", date(1991, 7, 20))
    savings_account = SavingsAccount(10000, 1235, "2", date(1997, 8, 22))

    # apply years of interest from the creation date
    savings_account.interest_mature()
    fee_savings_account.interest_mature()

    # try some normal withdrawals / deposits
    savings_account.withdraw(1500)
    fee_savings_account.withdraw(1500)

    savings_account.deposit(1500)
    fee_savings_account.deposit(1500)

    # the first change_pin is meant to fail - wrong old pin
    try:
        savings_account.change_pin(3123, 1232)
        fee_savings_account.change_pin(7843, 1234)
    except PasswordWrong as e:
        print(e)
