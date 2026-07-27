# Corerouter-Workers

Corerouter-Workers is the background processing layer of the Corerouter platform. It handles asynchronous and long-running tasks so the main API service can stay responsive.

## What it solves

- Heavy or deferred operations should not block live API responses.
- Corerouter-Workers solves this by executing background jobs separately from the main request/response flow.

## What Corerouter-Workers does

- Processes async tasks triggered by Corerouter.
- Runs scheduled and deferred backend jobs.
- Handles retryable background operations.
- Supports OCR, speech, and model-related post-processing workflows when needed.
- Reduces pressure on Corerouter’s synchronous API path.

## Tech stack

- Backend: Java, Spring Boot.
- Queue/Caching: Redis Streams and Redis-based coordination.
- Database integration: Works with platform persistence flows managed by Corerouter.
- Deployment: Docker-based services and CI/CD-aligned runtime setup.

## Security and reliability

- Worker execution is isolated from public API traffic.
- Background retries and failure handling improve processing reliability.
- Access is controlled through internal service-level authentication and role boundaries.

## Testing

- Unit tests for worker services and job handlers.
- Integration coverage for async flow handoff from Corerouter.
- API/system validation through shared testing workflows.

## Repository relationship

- Corerouter: Main backend and unified API layer.
- Corerouter-Workers (this repo): Background and deferred processing.
- Corerouter-Frontend: User-facing dashboard and application interface.

## How to run

- Clone: `git clone https://github.com/dashivam06/corerouter-workers.git`
- Configure environment variables for Redis, database access, and internal auth settings.
- Start required dependencies (Redis and database connectivity).
- Run the worker service using the project’s Maven/Gradle command.

## Project status

- Corerouter-Workers is part of the final year project infrastructure and is not currently operated as a public live service.
