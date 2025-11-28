from app.db import db
from app.models import Order
from typing import Optional

class OrderService:
    def create_order(self, order: Order) -> Order:
        # Check if user exists
        user_exists = False
        for user in db["users"]:
            if user.id == order.user_id:
                user_exists = True
                break
        if not user_exists:
            raise ValueError("User not found")

        # Check if product exists and has stock
        product_found = None
        for product in db["products"]:
            if product.id == order.product_id:
                product_found = product
                break
        
        if not product_found:
            raise ValueError("Product not found")
        
        if product_found.quantity < order.quantity:
            raise ValueError("Insufficient stock")

        # Deduct stock
        product_found.quantity -= order.quantity

        order.id = len(db["orders"]) + 1
        order.status = "confirmed"
        db["orders"].append(order)
        return order

    def get_order(self, order_id: int) -> Optional[Order]:
        for order in db["orders"]:
            if order.id == order_id:
                return order
        return None
