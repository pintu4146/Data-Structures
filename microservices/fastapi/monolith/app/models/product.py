"""Product model definition with Pydantic v2."""

from pydantic import BaseModel, Field, ConfigDict, field_validator, computed_field
from typing import Optional
from decimal import Decimal


class Product(BaseModel):
    """
    Product model representing an item in the inventory.
    
    Attributes:
        id: Unique identifier (auto-generated, optional on creation)
        name: Product name (1-200 characters)
        price: Product price (must be positive)
        quantity: Available stock quantity (must be non-negative)
    """
    
    id: Optional[int] = Field(
        default=None,
        description="Unique product identifier",
        examples=[1, 42, 100]
    )
    
    name: str = Field(
        min_length=1,
        max_length=200,
        description="Product name",
        examples=["Laptop", "Wireless Mouse", "USB-C Cable"]
    )
    
    price: float = Field(
        gt=0,  # Greater than 0
        description="Product price in USD",
        examples=[999.99, 29.99, 15.50]
    )
    
    quantity: int = Field(
        ge=0,  # Greater than or equal to 0
        description="Available stock quantity",
        examples=[10, 0, 500]
    )
    
    # Pydantic v2 configuration
    model_config = ConfigDict(
        str_strip_whitespace=True,
        validate_assignment=True,
        json_schema_extra={
            "example": {
                "id": 1,
                "name": "Laptop",
                "price": 999.99,
                "quantity": 10
            }
        }
    )
    
    @computed_field
    @property
    def in_stock(self) -> bool:
        """Check if product is in stock."""
        return self.quantity > 0
    
    @computed_field
    @property
    def total_value(self) -> float:
        """Calculate total inventory value for this product."""
        return round(self.price * self.quantity, 2)
    
    @field_validator('name')
    @classmethod
    def validate_name(cls, v: str) -> str:
        """Validate and normalize product name."""
        if not v.strip():
            raise ValueError('Product name cannot be empty or whitespace')
        return v.strip().title()  # Normalize to title case
    
    def can_fulfill_order(self, requested_quantity: int) -> bool:
        """Check if there's enough stock to fulfill an order."""
        return self.quantity >= requested_quantity

