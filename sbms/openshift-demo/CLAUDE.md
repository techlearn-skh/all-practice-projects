# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Spring Boot 4.0.6 WebFlux (reactive) application demonstrating containerized deployment on OpenShift/Kubernetes. Exposes a small REST API with Swagger/OpenAPI docs and shows how to inject configuration via ConfigMaps and Secrets.

- **Java 21**, Gradle 9.4.1, Spring Boot 4.0.6
- **Port:** 9001 (configurable via `SERVER_PORT`)
- **Profiles:** `dev` (default, local), `ocp` (OpenShift)
- **Namespace:** `kamalredhat-2025-dev`

## Project Structure

```
openshift-demo/
├── CLAUDE.md
├── Dockerfile
├── HELP.md
├── build.gradle
├── settings.gradle
├── gradlew
├── gradlew.bat
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── src/
│   ├── main/
│   │   ├── java/com/skh/
│   │   │   ├── OCPDemoController.java
│   │   │   ├── OpenshiftDemoApplication.java
│   │   │   └── SwaggerApiConfig.java
│   │   └── resources/
│   │       ├── application.yaml          # dev profile defaults
│   │       ├── configmap.yml             # base ConfigMap
│   │       ├── deployment.yaml           # base Deployment
│   │       ├── routes.yaml               # base Route
│   │       ├── secret.yml                # base Secret
│   │       ├── service.yaml              # base Service
│   │       └── env/
│   │           ├── application-ocp.yaml                    # ocp profile config
│   │           ├── configmap-env.yml                       # env ConfigMap
│   │           ├── deployment-with-secrets-configmaps.yaml # env Deployment
│   │           ├── routes-env.yaml                         # env Route
│   │           ├── secret-env.yml                          # env Secret
│   │           └── service-env.yaml                        # env Service
│   └── test/
│       └── java/com/skh/
│           └── OpenshiftDemoApplicationTests.java
└── build/                                # generated — not committed
    └── libs/
        └── openshift-demo-0.0.1-SNAPSHOT.jar
```

## Commands

```bash
# Build
./gradlew clean build
./gradlew build -x test        # skip tests
./gradlew bootJar              # produces build/libs/openshift-demo-0.0.1-SNAPSHOT.jar

# Run
./gradlew bootRun
./gradlew bootRun --args='--spring.profiles.active=ocp'
java -jar build/libs/openshift-demo-0.0.1-SNAPSHOT.jar

# Test
./gradlew test
./gradlew test --tests OpenshiftDemoApplicationTests

# Docker
docker login                                                              # login to Docker Hub (prompts for username/password)
docker login -u kamaltechlearn                                            # login with specific username
docker build -t ocp-swagger-demo:latest .                                 # build image from Dockerfile in current directory
docker build -t ocp-swagger-demo:3.0 .                                   # build with a specific version tag
docker tag ocp-swagger-demo:latest kamaltechlearn/ocp-swagger-env-demo:latest   # tag local image for Docker Hub
docker tag ocp-swagger-demo:3.0 kamaltechlearn/ocp-swagger-env-demo:3.0        # tag with version for Docker Hub
docker push kamaltechlearn/ocp-swagger-env-demo:latest                   # push to Docker Hub
docker push kamaltechlearn/ocp-swagger-env-demo:3.0                      # push specific version to Docker Hub
docker run -p 9001:9001 ocp-swagger-demo:latest
```

## Architecture

### Application Layer (`src/main/java/com/skh/`)

- **`OCPDemoController`** — Two GET endpoints: `/` (welcome + pod info) and `/fullName?firstName=&lastName=`. Pod name/IP are read from `POD_NAME` and `POD_IP` env vars (injected by Kubernetes downward API); falls back to localhost info when running locally.
- **`SwaggerApiConfig`** — SpringDoc OpenAPI 3 config (metadata, sorting). Swagger UI is disabled by default; enable with `SWAGGER_UI_ENABLED=true`.
- **`OpenshiftDemoApplication`** — Standard `@SpringBootApplication` entry point.

### Configuration

| File | Purpose |
|------|---------|
| `application.yaml` | Dev defaults (Swagger disabled) |
| `application-ocp.yaml` | OCP profile; all values map to env vars |

Environment variables override YAML values. In Kubernetes, ConfigMaps and Secrets are injected as env vars so images don't need to be rebuilt per environment.

### Kubernetes / OpenShift Resources (`src/main/resources/`)

Two sets of manifests — apply one set per environment:

**Base** (root of `resources/`): minimal manifests.

**Env-specific** (`resources/env/`): includes full ConfigMap key set and `imagePullPolicy: Always`.

| Resource | Kind | Notes |
|----------|------|-------|
| `deployment*.yaml` | Deployment | 3 replicas, rolling update, image `docker.io/kamaltechlearn/ocp-swagger-env-demo:3.0` |
| `service*.yaml` | Service | ClusterIP, port 9001→9001 |
| `routes*.yaml` | Route | OpenShift-specific ingress |
| `configmap*.yml` | ConfigMap | `ocp-swagger-demo-config` — non-sensitive settings |
| `secret*.yml` | Secret | `ocp-swagger-demo-secret` — credentials (MY_USERNAME / MY_PASSWORD) |

Apply env-specific resources:
```bash
kubectl apply -f src/main/resources/env/configmap-env.yml
kubectl apply -f src/main/resources/env/secret-env.yml
kubectl apply -f src/main/resources/env/deployment-with-secrets-configmaps.yaml
kubectl apply -f src/main/resources/env/service-env.yaml
kubectl apply -f src/main/resources/env/routes-env.yaml
```

### Pod Info via Downward API

The controller reads pod identity from env vars. Add these to any deployment that needs accurate pod info:
```yaml
env:
  - name: POD_NAME
    valueFrom:
      fieldRef:
        fieldPath: metadata.name
  - name: POD_IP
    valueFrom:
      fieldRef:
        fieldPath: status.podIP
```

## Key Environment Variables

| Variable | Default | Purpose |
|----------|---------|---------|
| `SERVER_PORT` | `9001` | HTTP port |
| `SWAGGER_UI_ENABLED` | `false` | Toggle Swagger UI |
| `SWAGGER_API_DOCS_ENABLED` | `true` | Toggle `/v3/api-docs` |
| `MY_USERNAME` / `MY_PASSWORD` | — | Demo credentials (from Secret) |
| `POD_NAME` / `POD_IP` | — | Injected by Kubernetes downward API |

## API Endpoints

- `GET /` — welcome message with pod/host info
- `GET /fullName?firstName=X&lastName=Y` — formatted full name with pod info
- `GET /v3/api-docs` — OpenAPI JSON
- `GET /swagger-ui.html` — Swagger UI (requires `SWAGGER_UI_ENABLED=true`)
