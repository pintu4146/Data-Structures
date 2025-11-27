from fastapi import FastAPI
from app.routers import users, products, orders

app = FastAPI()

app.include_router(users.router)
app.include_router(products.router)
app.include_router(orders.router)

@app.get("/")
def read_root():
    return {"message": "Welcome to the Monolith E-commerce Store"}
