# UserManager

UserManager is a user management application that allows you to manage user data efficiently. This application provides various functionalities to create, read, update, and search for users.

## Features

- **User Registration**: Allows users to register with a username, password, email, phone number, and other personal details.
- **User Management**: Admins can save, update, and delete user information.
- **Search Functionality**: Users can search for other users by username, roles, statuses, or age.
- **Pagination**: Supports pagination for user lists to enhance performance and usability.
- **Role Management**: Users can be assigned different roles (e.g., Admin, User) to manage permissions.
- **Status Management**: Users can have different statuses (e.g., Active, Inactive) to indicate their current state.
- **Validation**: Input validation is enforced to ensure data integrity (e.g., email format, password strength).
- **Database Integration**: Utilizes H2 database for data storage with JPA for ORM.

## Technologies Used

- **Spring Boot**: For building the application.
- **Spring Data JPA**: For database interactions.
- **H2 Database**: For lightweight database management.
- **Lombok**: For reducing boilerplate code.
- **Jakarta Validation**: For validating user input.

Access the application at `http://localhost:8070`.

## API Endpoints

- **POST /user/save**: Save a new user.
- **POST /user/saveAll**: Save multiple users.
- **POST /user/list**: Get a paginated list of users.
- **GET /user/single**: Get a user by ID.
- **GET /user/search**: Search for users by username.
- **GET /user/users/roles**: Get users by roles.
- **GET /user/users/statuses**: Get users by statuses.
- **GET /user/users/age**: Get users by age.

