# Configuration Package

This package manages application configuration using Pydantic Settings with support for multiple environments.

## Environment Files

The application supports environment-specific configuration through `.env` files:

- **`.env.development`** - Local development settings
- **`.env.staging`** - Staging environment settings  
- **`.env.production`** - Production environment settings
- **`.env.example`** - Template file with all available variables

## Usage

### Setting the Environment

The environment is controlled by the `ENVIRONMENT` variable:

**Linux/Mac:**
```bash
export ENVIRONMENT=production
python -m uvicorn app.main:app
```

**Windows (PowerShell):**
```powershell
$env:ENVIRONMENT="production"
python -m uvicorn app.main:app
```

**Windows (CMD):**
```cmd
set ENVIRONMENT=production
python -m uvicorn app.main:app
```

### Loading Priority

Configuration is loaded in this order (later overrides earlier):

1. Default values in `Settings` class
2. `.env` file (if exists)
3. `.env.{ENVIRONMENT}` file (e.g., `.env.production`)
4. System environment variables (highest priority)

### Importing Settings

```python
# Recommended: Use the singleton instance
from app.config import settings

print(settings.app_name)
print(settings.database_url)

# Alternative: Get fresh instance (rarely needed)
from app.config import get_settings

settings = get_settings()
```

## Configuration Variables

See `.env.example` for a complete list of available configuration variables.

### Key Settings

- **ENVIRONMENT** - Runtime environment (`development`, `staging`, `production`)
- **DEBUG** - Enable debug mode (auto-disabled in production)
- **SECRET_KEY** - Secret key for JWT/encryption (MUST be 32+ characters)
- **DATABASE_URL** - Database connection string
- **LOG_LEVEL** - Logging verbosity
- **LOG_JSON_FORMAT** - Use JSON logs (auto-enabled in production)

## Best Practices

1. **Never commit `.env` files** - They're in `.gitignore`
2. **Always use `.env.example`** - Keep it updated as a template
3. **Generate secure keys** - Use `python -c "import secrets; print(secrets.token_urlsafe(32))"`
4. **Validate in production** - Settings include validation (e.g., `min_length=32` for `secret_key`)
5. **Use environment variables** - In containers/cloud, set env vars directly instead of `.env` files

## Auto-Configuration

The settings automatically adjust based on environment:

- **Production mode** (`ENVIRONMENT=production`):
  - Forces `debug=False`
  - Forces `log_json_format=True`
  - Validates `secret_key` length

## Example: Docker

```dockerfile
# Set environment in Dockerfile
ENV ENVIRONMENT=production
ENV SECRET_KEY=your-secure-key-here
ENV DATABASE_URL=postgresql://user:pass@db:5432/mydb
```

## Example: Kubernetes

```yaml
env:
  - name: ENVIRONMENT
    value: "production"
  - name: SECRET_KEY
    valueFrom:
      secretKeyRef:
        name: app-secrets
        key: secret-key
```
