# Stage 1: Builder
FROM python:3.10-alpine as builder

# Set environment variables
ENV PYTHONDONTWRITEBYTECODE=1 \
    PYTHONUNBUFFERED=1

WORKDIR /code

# Install system dependencies required for building python packages
# libffi-dev and build-base are often needed for python wheels on alpine
RUN apk add --no-cache libffi-dev build-base

# Install poetry and export plugin
RUN pip install poetry poetry-plugin-export

# Copy poetry configuration
COPY pyproject.toml poetry.lock .

# Generate lock file and export requirements.txt
RUN poetry lock && \
    poetry export -f requirements.txt --output requirements.txt --without-hashes

# Install python dependencies
RUN pip wheel --no-cache-dir --no-deps --wheel-dir /code/wheels -r requirements.txt

# Stage 2: Runner
FROM python:3.10-alpine as runner

# Metadata
LABEL maintainer="Monolith Team" \
      description="Monolithic FastAPI Service" \
      version="1.0"

ENV PYTHONDONTWRITEBYTECODE=1 \
    PYTHONUNBUFFERED=1

WORKDIR /code

# Create a non-root user for security
# Alpine uses adduser -D (no password)
RUN addgroup -S appuser && adduser -S appuser -G appuser

# Install system dependencies (curl for healthcheck)
RUN apk add --no-cache curl

# Copy wheels from builder stage
COPY --from=builder /code/wheels /code/wheels
COPY --from=builder /code/requirements.txt .

# Install dependencies from wheels
RUN pip install --no-cache-dir --no-index --find-links=/code/wheels -r requirements.txt && \
    rm -rf /code/wheels

# Copy application code
COPY ./app /code/app

# Change ownership to non-root user
RUN chown -R appuser:appuser /code

# Switch to non-root user
USER appuser

# Expose the port
EXPOSE 8000

# Healthcheck to ensure the service is running
HEALTHCHECK --interval=30s --timeout=30s --start-period=5s --retries=3 \
  CMD curl -f http://localhost:8000/ || exit 1

# Command to run the application
CMD ["uvicorn", "app.main:app", "--host", "0.0.0.0", "--port", "8000"]
