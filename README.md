# CoreRouter Email Worker

CoreRouter Email Worker is an asynchronous email processing system built for reliable and scalable email delivery in SaaS applications. It decouples email sending from the main backend using a Redis based job queue. This prevents API latency and improves system resilience.

## Overview

The system follows an event driven architecture.

The main backend publishes email jobs into Redis queues. Workers consume these jobs independently and send emails through a cloud provider.

This design ensures fault tolerance, horizontal scalability, and clean separation of concerns.

---

## Architecture

### Flow

1. Backend creates an email job.
2. Job is pushed to Redis queue.
3. Worker consumes the job using blocking pop.
4. Worker processes the email request.
5. Email is sent via provider API.