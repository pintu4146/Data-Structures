# Models Package

Pydantic v2 data models for the monolith e-commerce service.

## Models

### User
Represents a customer/user in the system.

**Fields:**
- `id` - Auto-generated unique identifier
- `username` - 3-50 characters, alphanumeric + underscores, auto-normalized to lowercase
- `email` - Valid email address (validated with `EmailStr`)

**Validation:**
- Username must contain only letters, numbers, and underscores
- Email must be valid format
- Whitespace is automatically stripped

### Product
Represents an inventory item.

**Fields:**
- `id` - Auto-generated unique identifier
- `name` - 1-200 characters, auto-normalized to Title Case
- `price` - Must be > 0
- `quantity` - Must be >= 0

**Computed Properties:**
- `in_stock` - Boolean indicating if quantity > 0
- `total_value` - Total inventory value (price × quantity)

**Methods:**
- `can_fulfill_order(quantity)` - Check if enough stock available

### Order
Represents a customer purchase.

**Fields:**
- `id` - Auto-generated unique identifier
- `user_id` - Must be > 0
- `product_id` - Must be > 0
- `quantity` - Must be > 0 and <= 1000
- `status` - One of: `pending`, `confirmed`, `shipped`, `delivered`, `cancelled`

**Computed Properties:**
- `is_active` - True if not delivered or cancelled

**Methods:**
- `can_cancel()` - Check if order can be cancelled
- `can_ship()` - Check if order can be shipped

## Pydantic v2 Features

All models use modern Pydantic v2 syntax:

### Field Validation
```python
username: str = Field(
    min_length=3,
    max_length=50,
    description="Username for the user"
)
```

### Custom Validators
```python
@field_validator('username')
@classmethod
def validate_username(cls, v: str) -> str:
    # Custom validation logic
    return v.lower()
```

### Computed Fields
```python
@computed_field
@property
def in_stock(self) -> bool:
    return self.quantity > 0
```

### ConfigDict (Pydantic v2)
```python
model_config = ConfigDict(
    str_strip_whitespace=True,
    validate_assignment=True,
    json_schema_extra={"example": {...}}
)
```

## Usage Examples

### Creating Models
```python
from app.models import User, Product, Order

# Create a user
user = User(username="john_doe", email="john@example.com")

# Create a product
product = Product(name="laptop", price=999.99, quantity=10)

# Create an order
order = Order(user_id=1, product_id=1, quantity=2)
```

### Validation
```python
# Automatic validation
user = User(username="ab", email="invalid")  # ❌ Raises ValidationError

# Valid
user = User(username="john_doe", email="john@example.com")  # ✅

# Computed fields
product = Product(name="laptop", price=100, quantity=5)
print(product.in_stock)      # True
print(product.total_value)   # 500.0
```

### Business Logic
```python
# Check stock availability
if product.can_fulfill_order(3):
    print("Order can be fulfilled")

# Check order status
if order.can_cancel():
    order.status = "cancelled"
```

## API Schema

All models automatically generate OpenAPI schemas for FastAPI:

```python
@app.post("/users", response_model=User)
def create_user(user: User):
    return user
```

FastAPI will show:
- Field descriptions
- Validation rules
- Example values
- Required vs optional fields

## Migration from Pydantic v1

### Old (v1):
```python
class User(BaseModel):
    id: Optional[int] = None
    username: str
    
    class Config:
        validate_assignment = True
```

### New (v2):
```python
class User(BaseModel):
    id: Optional[int] = Field(default=None, description="...")
    username: str = Field(min_length=3, max_length=50)
    
    model_config = ConfigDict(
        validate_assignment=True
    )
```

## Benefits

✅ **Type Safety** - Full type hints and validation  
✅ **Auto Documentation** - OpenAPI schemas generated automatically  
✅ **Data Validation** - Automatic validation on creation and assignment  
✅ **Business Logic** - Computed fields and helper methods  
✅ **Developer Experience** - Clear error messages and IDE support
