from fastapi import APIRouter, HTTPException, Depends
from app.models import User
from app.services.user_service import UserService

router = APIRouter()

def get_user_service():
    return UserService()

@router.post("/users", response_model=User)
def create_user(user: User, service: UserService = Depends(get_user_service)):
    return service.create_user(user)

@router.get("/users/{user_id}", response_model=User)
def get_user(user_id: int, service: UserService = Depends(get_user_service)):
    user = service.get_user(user_id)
    if not user:
        raise HTTPException(status_code=404, detail="User not found")
    return user
