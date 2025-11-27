from ..database import db
from ..models import User
from typing import Optional

class UserService:
    def create_user(self, user: User) -> User:
        user.id = len(db["users"]) + 1
        db["users"].append(user)
        return user

    def get_user(self, user_id: int) -> Optional[User]:
        for user in db["users"]:
            if user.id == user_id:
                return user
        return None
