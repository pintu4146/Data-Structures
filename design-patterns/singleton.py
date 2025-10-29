import threading
class DatabaseConnection:
    _instances = None
    _lock = threading.Lock()

    def __new__(cls):
        if cls._instances is None:
            