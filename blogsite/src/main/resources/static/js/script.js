// scripts.js

document.addEventListener("DOMContentLoaded", () => {
  loadBlogPosts();
});

function loadBlogPosts() {
  const apiUrl = "http://localhost:8080/blogs"; // Example API for testing

  // Show loading message
  const blogContainer = document.getElementById("blog-posts");
  blogContainer.innerHTML = "<p>Loading blog posts...</p>";

  fetch(apiUrl)
    .then((response) => response.json())
    .then((posts) => {
      blogContainer.innerHTML = ""; // Clear loading message

      if (posts.length === 0) {
        blogContainer.innerHTML = "<p>No blog posts found.</p>";
        return;
      }

      posts.forEach((post) => {
        const postElement = document.createElement("div");
        postElement.className = "blog-post";

        postElement.innerHTML = `
                    <h2>${post.title}</h2>
                    <h4>By ${post.author}</h4>
                    <p>${post.description}</p>
                `;

        blogContainer.appendChild(postElement);
      });
    })
    .catch((error) => {
      console.error("Error fetching posts:", error);
      blogContainer.innerHTML =
        "<p>Failed to load blog posts. Please try again later.</p>";
    });
}
