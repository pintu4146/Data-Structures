"""
Application configuration management using Pydantic Settings.
Supports multiple environments: development, staging, production.
Configuration is loaded from environment variables and .env files.

Environment file loading priority:
1. .env.{ENVIRONMENT} (e.g., .env.production)
2. .env (fallback)
3. System environment variables (highest priority)
"""

import os
from pathlib import Path
from typing import Literal
from functools import lru_cache
from pydantic import Field
from pydantic_settings import BaseSettings, SettingsConfigDict


class Settings(BaseSettings):
    """Application settings loaded from environment variables."""
    
    # Application
    app_name: str = Field(default="Monolith E-commerce Service", description="Application name")
    app_version: str = Field(default="0.1.0", description="Application version")
    environment: Literal["development", "staging", "production"] = Field(
        default="development",
        description="Runtime environment"
    )
    debug: bool = Field(default=False, description="Debug mode")
    
    # Server
    host: str = Field(default="0.0.0.0", description="Server host")
    port: int = Field(default=8000, ge=1, le=65535, description="Server port")
    
    # CORS
    cors_origins: list[str] = Field(default=["*"], description="Allowed CORS origins")
    cors_credentials: bool = Field(default=True, description="Allow credentials")
    cors_methods: list[str] = Field(default=["*"], description="Allowed HTTP methods")
    cors_headers: list[str] = Field(default=["*"], description="Allowed headers")
    
    # Logging
    log_level: str = Field(default="INFO", description="Logging level")
    log_json_format: bool = Field(
        default=False,
        description="Use JSON format for logs (recommended for production)"
    )
    
    # Database
    database_url: str = Field(
        default="sqlite:///./monolith.db",
        description="Database connection URL"
    )
    
    # Security
    secret_key: str = Field(
        default="dummy-secret-key-change-in-production",
        min_length=32,
        description="Secret key for JWT and encryption (MUST change in production)"
    )
    
    # API Rate Limiting
    rate_limit_enabled: bool = Field(default=False, description="Enable rate limiting")
    rate_limit_per_minute: int = Field(
        default=60,
        ge=1,
        description="Maximum requests per minute"
    )
    
    # Pydantic v2 configuration
    model_config = SettingsConfigDict(
        # Load from .env.{environment} first, then .env as fallback
        env_file=(".env", f".env.{os.getenv('ENVIRONMENT', 'development')}"),
        env_file_encoding="utf-8",
        case_sensitive=False,
        extra="ignore",  # Ignore extra fields in .env files
    )
    
    @property
    def is_development(self) -> bool:
        """Check if running in development environment."""
        return self.environment == "development"
    
    @property
    def is_production(self) -> bool:
        """Check if running in production environment."""
        return self.environment == "production"
    
    @property
    def is_staging(self) -> bool:
        """Check if running in staging environment."""
        return self.environment == "staging"
    
    def model_post_init(self, __context) -> None:
        """Post-initialization validation and setup."""
        # Auto-enable JSON logging in production
        if self.is_production and not self.log_json_format:
            self.log_json_format = True
        
        # Auto-disable debug in production
        if self.is_production and self.debug:
            self.debug = False


@lru_cache()
def get_settings() -> Settings:
    """
    Get cached settings instance.
    
    Uses lru_cache to ensure settings are loaded only once per application lifecycle.
    The environment is determined by the ENVIRONMENT variable.
    
    Usage:
        # Set environment before importing
        export ENVIRONMENT=production  # Linux/Mac
        set ENVIRONMENT=production     # Windows
        
        # Then use settings
        from app.config import settings
    
    Returns:
        Settings: Configured settings instance
    """
    return Settings()


# Convenience instance - use this throughout the application
settings = get_settings()
