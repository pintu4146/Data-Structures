"""User model definition with Pydantic v2."""

from pydantic import BaseModel, Field, EmailStr, ConfigDict, field_validator
from typing import Optional


class User(BaseModel):
    """
    User model representing a customer or user in the system.
    
    Attributes:
        id: Unique identifier (auto-generated, optional on creation)
        username: Unique username (3-50 characters, alphanumeric and underscores)
        email: Valid email address
    """
    
    id: Optional[int] = Field(
        default=None,
        description="Unique user identifier",
        examples=[1, 42, 100]
    )
    
    username: str = Field(
        min_length=3,
        max_length=50,
        description="Username for the user",
        examples=["john_doe", "alice123", "bob_smith"]
    )
    
    email: EmailStr = Field(
        description="User's email address",
        examples=["user@example.com", "alice@company.com"]
    )
    
    # Pydantic v2 configuration
    model_config = ConfigDict(
        str_strip_whitespace=True,  # Auto-strip whitespace from strings
        validate_assignment=True,    # Validate on attribute assignment
        json_schema_extra={
            "example": {
                "id": 1,
                "username": "john_doe",
                "email": "john@example.com"
            }
        }
    )
    
    @field_validator('username')
    @classmethod
    def validate_username(cls, v: str) -> str:
        """Validate username contains only alphanumeric characters and underscores."""
        if not v.replace('_', '').isalnum():
            raise ValueError('Username must contain only letters, numbers, and underscores')
        return v.lower()  # Normalize to lowercase

