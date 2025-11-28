from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from starlette.middleware.base import BaseHTTPMiddleware
from starlette.requests import Request
import time
from app.routers import users, products, orders
from app.config import settings
from app.utils.app_logger import get_logger

# Initialize logger
logger = get_logger(__name__, json_format=settings.log_json_format)

app = FastAPI(
    title=settings.app_name,
    version=settings.app_version,
    debug=settings.debug
)

# CORS Middleware - configuration from settings
app.add_middleware(
    CORSMiddleware,
    allow_origins=settings.cors_origins,
    allow_credentials=settings.cors_credentials,
    allow_methods=settings.cors_methods,
    allow_headers=settings.cors_headers,
)

# Custom Logging Middleware
class LoggingMiddleware(BaseHTTPMiddleware):
    async def dispatch(self, request: Request, call_next):
        start_time = time.time()
        response = await call_next(request)
        process_time = time.time() - start_time
        response.headers["X-Process-Time"] = str(process_time)
        logger.info(f"{request.method} {request.url.path} - {process_time:.4f}s")
        return response

app.add_middleware(LoggingMiddleware)

app.include_router(users.router)
app.include_router(products.router)
app.include_router(orders.router)

@app.get("/")
def read_root():
    return {
        "message": f"Welcome to {settings.app_name}",
        "version": settings.app_version,
        "environment": settings.environment
    }

@app.get("/health")
def health_check():
    """Health check endpoint for container orchestration."""
    return {"status": "healthy", "environment": settings.environment}
