from fastapi import APIRouter, HTTPException, Depends
from ..models import Product
from ..services.product_service import ProductService
from typing import List

router = APIRouter()

def get_product_service():
    return ProductService()

@router.post("/products", response_model=Product)
def create_product(product: Product, service: ProductService = Depends(get_product_service)):
    return service.create_product(product)

@router.get("/products", response_model=List[Product])
def get_products(service: ProductService = Depends(get_product_service)):
    return service.get_products()

@router.get("/products/{product_id}", response_model=Product)
def get_product(product_id: int, service: ProductService = Depends(get_product_service)):
    product = service.get_product(product_id)
    if not product:
        raise HTTPException(status_code=404, detail="Product not found")
    return product
