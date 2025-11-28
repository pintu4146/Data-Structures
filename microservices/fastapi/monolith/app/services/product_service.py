from app.db import db
from app.models import Product
from typing import List, Optional

class ProductService:
    def create_product(self, product: Product) -> Product:
        product.id = len(db["products"]) + 1
        db["products"].append(product)
        return product

    def get_products(self) -> List[Product]:
        return db["products"]

    def get_product(self, product_id: int) -> Optional[Product]:
        for product in db["products"]:
            if product.id == product_id:
                return product
        return None
