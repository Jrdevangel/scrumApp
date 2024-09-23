## Scrum APP - Task Management System

## 🚀 Project Overview
Scrum APP is a REST API developed with Java 17 and Spring Boot, designed to manage users, projects, and tasks efficiently and securely. We use JWT (JSON Web Tokens) for authentication and Spring Security for role-based authorization. The application is powered by a MySQL database, containerized with Docker, and features continuous integration (CI/CD) with GitHub Actions.

## 🏆 Project Goals
API Development: Build a robust API for task and user management.
Database Relationships: Implement relationships between users, projects, and tasks.
Authentication & Authorization: Secure authentication via JWT and role-based authorization with Spring Security.
CI/CD Automation: First steps with GitHub Actions for automated deployment.

## 🧰 Technical Requirements
Java 17 and Spring Boot
Spring Security and JWT
Object-Oriented Programming (OOP) knowledge
GitHub Actions for CI/CD
Docker for containerization
Lombok and the @Autowired annotation cannot be used to reinforce manual configurations.

## ⚙️ Key Features
1. User Roles
   Administrator: Manages users and tasks.
   Manager: Creates, assigns, and supervises tasks but cannot manage users.
   User: Can only view and update their assigned tasks.
2. Authentication & Authorization
   JWT is used for secure authentication.
   Spring Security manages role-based authorization, providing different permissions depending on the user’s role.
3. Task CRUD Operations
   Create: Managers can create tasks and assign them to users.
   Read: Users can view their own tasks, while managers can view tasks assigned to any user.
   Update: Users can update the status of their tasks (Pending, In Progress, Completed).
   Delete: Only managers can delete tasks.
4. User Management
   Administrators manage user registration, deactivation, and role assignments.
   Managers can filter tasks by user for personalized tracking.

## 🛠️ API Endpoints

### Authentication
POST /api/auth/login: User authentication (Returns JWT)
POST /api/auth/register: Register a new user (Admin only)

### Users
GET /api/users: List all users (Admin only)
GET /api/users/{id}: Get user by ID (Admin or self)
POST /api/users: Create a new user (Admin only)
PUT /api/users/{id}: Update a user (Admin only)
DELETE /api/users/{id}: Delete a user (Admin only)

### Projects
GET /api/projects: List all projects
POST /api/projects: Create a new project (Admin and Manager only)
PUT /api/projects/{id}: Update a project (Admin and Manager only)
DELETE /api/projects/{id}: Delete a project (Admin and Manager only)

### Tasks
GET /api/tasks: List all tasks (Admin and Manager only)
GET /api/tasks/{id}: Get a specific task (Users can only see their own)
POST /api/tasks: Create a new task (Manager only)
PUT /api/tasks/{id}: Update a task (Users can only update their own)
DELETE /api/tasks/{id}: Delete a task (Manager only)

## 🤝 Contributions
This project was developed collaboratively by [Jrdevangel](https://github.com/Jrdevangel), [FJRJ3D](https://github.com/FJRJ3D), [jmatisam](https://github.com/jmatisam), and [Krisel1](https://github.com/Krisel1). Contributions are welcome! Please fork this repository, create a new branch for your feature or bugfix, and submit a pull request.
