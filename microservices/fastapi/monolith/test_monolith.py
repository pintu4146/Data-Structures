import requests
import sys

BASE_URL = "http://127.0.0.1:8000"

def test_flow():
    print(f"Testing against {BASE_URL}...")
    
    # 1. Create User
    user_data = {"username": "alice", "email": "alice@example.com"}
    try:
        response = requests.post(f"{BASE_URL}/users", json=user_data)
        if response.status_code != 200:
            print(f"Failed to create user: {response.text}")
            return
        print("Create User: SUCCESS", response.json())
        user_id = response.json()["id"]
    except requests.exceptions.ConnectionError:
        print("Error: Could not connect to server. Make sure it is running on port 8000.")
        return

    # 2. Create Product
    product_data = {"name": "Laptop", "price": 1000.0, "quantity": 10}
    response = requests.post(f"{BASE_URL}/products", json=product_data)
    print("Create Product: SUCCESS", response.json())
    product_id = response.json()["id"]

    # 3. Create Order
    order_data = {"user_id": user_id, "product_id": product_id, "quantity": 1}
    response = requests.post(f"{BASE_URL}/orders", json=order_data)
    print("Create Order: SUCCESS", response.json())

    # 4. Check Product Stock
    response = requests.get(f"{BASE_URL}/products/{product_id}")
    product = response.json()
    print("Check Product Stock: SUCCESS", product)
    
    if product["quantity"] == 9:
        print("\nVERIFICATION PASSED: Stock was correctly deducted.")
    else:
        print("\nVERIFICATION FAILED: Stock was not deducted correctly.")

if __name__ == "__main__":
    test_flow()
