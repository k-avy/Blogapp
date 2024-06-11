# Blogapp

Blog Application to create, read, update, and delete blog posts.

## Prerequisites

Before running this Spring project, make sure you have the following prerequisites installed:

- Java Development Kit (JDK) 17 or higher
- Apache Maven
- MongoDB

## Installation

To install and run the Blogapp project, follow these steps:

1. Clone the repository:

    ```shell
    git clone https://github.com/your-username/Blogapp.git
    ```

2. Navigate to the project directory:

    ```shell
    cd Blogapp
    cd blogsite
    ```

3. Build the project using Maven:

    ```shell
    mvn clean install
    ```

4. Configure the database connection in the `application.properties` file:

    ```properties
    spring.data.mongodb.uri=mongodb://localhost:27017/BlogModelDB
    ```
5. Start the mongoDB sever:
   
   ```shell
   mongosh
   ```
6. Setup the database:
   ```shell
   use BlogModelDB
    ```
7. Run the application:

    ```shell
    mvn spring-boot:run
    ```

## Usage

Once the application is running, you can access it at `http://localhost:8080` in your web browser. From there, you can create, read, update, and delete blog posts.

## Features

### Create Blog Post
To create a new blog post, send a POST request to the `/blogs` endpoint with the following JSON payload:

```json
{
    "author":"Author Name",
    "title": "New Blog Post",
    "content": "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
}
```

The server will respond with the newly created blog post object, including its unique identifier.

### Fetch All Blog Posts
To fetch all blog posts, send a GET request to the `/blogs` endpoint. The server will respond with a list of all blog posts available in the application.

Example response:
```json
[
    {
        "id": "1",
        "author": "Author Name",
        "title": "First Blog Post",
        "content": "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
    },
    {
        "id": "2",
        "author": "Author Name",
        "title": "Second Blog Post",
        "content": "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
    },
    ...
]
```

You can use this response to display a list of all blog posts on your application's frontend.


### Read Blog Post
To retrieve a specific blog post, send a GET request to the `/blogs{posId}` endpoint, where `{postId}` is the unique identifier of the desired blog post.

The server will respond with the blog post object, including its title, content, and other details.

### Update Blog Post
To update an existing blog post, send a PUT request to the `/blogs/{postId}` endpoint, where `{postId}` is the unique identifier of the blog post to be updated. Include the updated content in the JSON payload:

```json
{
    "id":"1",
    "author":"Author Name",
    "title": "Updated Blog Post",
    "content": "New content for the blog post."
}
```

The server will respond with the updated blog post object.

### Delete Blog Post
To delete a blog post, send a DELETE request to the `/blogs/{postId}` endpoint, where `{postId}` is the unique identifier of the blog post to be deleted.

The server will respond with a success message indicating that the blog post has been deleted.
