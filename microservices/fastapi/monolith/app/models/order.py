"""Order model definition with Pydantic v2."""

from pydantic import BaseModel, Field, ConfigDict, field_validator, computed_field
from typing import Optional, Literal
from datetime import datetime


class Order(BaseModel):
    """
    Order model representing a customer purchase.
    
    Attributes:
        id: Unique identifier (auto-generated, optional on creation)
        user_id: ID of the user placing the order
        product_id: ID of the product being ordered
        quantity: Number of items ordered (must be positive)
        status: Current order status
    """
    
    id: Optional[int] = Field(
        default=None,
        description="Unique order identifier",
        examples=[1, 42, 100]
    )
    
    user_id: int = Field(
        gt=0,
        description="ID of the user placing the order",
        examples=[1, 5, 10]
    )
    
    product_id: int = Field(
        gt=0,
        description="ID of the product being ordered",
        examples=[1, 3, 7]
    )
    
    quantity: int = Field(
        gt=0,  # Must be at least 1
        description="Number of items to order",
        examples=[1, 2, 5]
    )
    
    status: Literal["pending", "confirmed", "shipped", "delivered", "cancelled"] = Field(
        default="pending",
        description="Current status of the order"
    )
    
    # Pydantic v2 configuration
    model_config = ConfigDict(
        str_strip_whitespace=True,
        validate_assignment=True,
        use_enum_values=True,  # Use enum values instead of enum objects
        json_schema_extra={
            "example": {
                "id": 1,
                "user_id": 1,
                "product_id": 1,
                "quantity": 2,
                "status": "pending"
            }
        }
    )
    
    @field_validator('quantity')
    @classmethod
    def validate_quantity(cls, v: int) -> int:
        """Validate order quantity is reasonable."""
        if v > 1000:
            raise ValueError('Order quantity cannot exceed 1000 items')
        return v
    
    @computed_field
    @property
    def is_active(self) -> bool:
        """Check if order is still active (not delivered or cancelled)."""
        return self.status not in ["delivered", "cancelled"]
    
    def can_cancel(self) -> bool:
        """Check if order can be cancelled."""
        return self.status in ["pending", "confirmed"]
    
    def can_ship(self) -> bool:
        """Check if order can be shipped."""
        return self.status == "confirmed"

