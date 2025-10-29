import threading

# Abstract Factory Interface
class BankingFactory:
    def create_account(self, balance): pass
    def create_card(self): pass

# Concrete Factories
class SavingsFactory(BankingFactory):
    def create_account(self, balance):
        return SavingsAccount(balance)
    def create_card(self):
        return DebitCard()

class LoanFactory(BankingFactory):
    def create_account(self, balance):
        return LoanAccount(balance)
    def create_card(self):
        return CreditCard()

# Products
class SavingsAccount:
    def __init__(self, balance):
        self.type = "Savings"
        self.balance = balance

class LoanAccount:
    def __init__(self, balance):
        self.type = "Loan"
        self.balance = balance

class DebitCard:
    def __init__(self):
        self.card_type = "Debit"

class CreditCard:
    def __init__(self):
        self.card_type = "Credit"

# Factory Registry (Thread-Safe)
class FactoryRegistry:
    _registry = {}
    _lock = threading.Lock()

    @classmethod
    def register(cls, name, factory_cls):
        with cls._lock:
            cls._registry[name.lower()] = factory_cls

    @classmethod
    def get_factory(cls, name):
        key = name.lower()
        if key in cls._registry:
            return cls._registrykey
        raise ValueError("Invalid factory type")

# Register factories dynamically
FactoryRegistry.register("savings", SavingsFactory)
FactoryRegistry.register("loan", LoanFactory)

# Usage
factory = FactoryRegistry.get_factory("loan")
account = factory.create_account(10000)
card = factory.create_card()
print(account.type, account.balance, card.card_type)