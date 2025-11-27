from pydantic import BaseModel
from typing import List, Optional

class User(BaseModel):
    id: Optional[int] = None
    username: str
    email: str

class Product(BaseModel):
    id: Optional[int] = None
    name: str
    price: float
    quantity: int

class Order(BaseModel):
    id: Optional[int] = None
    user_id: int
    product_id: int
    quantity: int
    status: str = "pending"
