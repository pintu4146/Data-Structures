from fastapi import APIRouter, HTTPException, Depends
from app.models import Order
from app.services.order_service import OrderService

router = APIRouter()

def get_order_service():
    return OrderService()

@router.post("/orders", response_model=Order)
def create_order(order: Order, service: OrderService = Depends(get_order_service)):
    try:
        return service.create_order(order)
    except ValueError as e:
        raise HTTPException(status_code=400, detail=str(e))

@router.get("/orders/{order_id}", response_model=Order)
def get_order(order_id: int, service: OrderService = Depends(get_order_service)):
    order = service.get_order(order_id)
    if not order:
        raise HTTPException(status_code=404, detail="Order not found")
    return order
