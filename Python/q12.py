from datetime import date
from dateutil.relativedelta import relativedelta

class BrokeAF(Exception):
    pass

class PasswordWrong(Exception):
    pass

class TimeTraveller(Exception):
    pass

class BankAccount:
    def __init__(self, balance:int , pin:int , user_id:str) -> None:
        self.balance = balance
        self.pin = pin
        self.user_id = user_id

    def deposit(self , muney:int) -> None:
        self.balance += muney
        print("Money deposited $" , self.balance)

    def withdraw(self, amount: int) -> None:
        if amount > self.balance:
            raise BrokeAF("Not enough money")
        self.balance -= amount
        print("Money now $" , self.balance)

    def get_balance(self) -> int:
        return self.balance

    def get_pin(self) -> int:
        return self.pin

    def change_pin(self, new_pin:int, old_pin:int) -> None:
        if old_pin != new_pin:
            raise PasswordWrong("Wrong pin")
        self.pin = new_pin
        print("Pin changed")

class SavingsAccount(BankAccount):
    interest_rate:float = 0.075

    def __init__(self, balance:int , pin:int, user_id:str , create_date:date) -> None:
        super().__init__(balance , pin , user_id)
        self.date_now = None
        self.create_date = create_date
        self.mature_date = create_date

    def interest_mature(self) -> None:
        self.date_now = date.today()
        years = relativedelta(self.date_now , self.mature_date).years
        self.balance = self.balance*(1 + years * SavingsAccount.interest_rate)
        print("Interest matured $" , self.balance)
        self.mature_date = date.today()


class FeeSavingsAccount(SavingsAccount):
    fee:int = 2
    def __init__(self, balance:int , pin:int, user_id:str , create_date:date) -> None:
        super().__init__(balance , pin , user_id , create_date)

    def withdraw(self, amount: int) -> None:
        if self.balance < amount + self.fee:
            raise BrokeAF("Not enough money")
        self.balance -= amount + FeeSavingsAccount.fee
        print("Fee_savings now $" , self.balance)

if __name__ == '__main__':
    fee_savings_account = FeeSavingsAccount(10000 , 1234 , "1" , date(1991, 7, 20))
    savings_account = SavingsAccount(10000 , 1235 , "2" , date(1997, 8, 22))

    savings_account.interest_mature()
    fee_savings_account.interest_mature()
    savings_account.withdraw(1500)
    fee_savings_account.withdraw(1500)

    savings_account.deposit(1500)
    fee_savings_account.deposit(1500)

    try:
        savings_account.change_pin(3123 , 1232)
        fee_savings_account.change_pin(7843 , 1234)
    except PasswordWrong as e:
        print(e)








