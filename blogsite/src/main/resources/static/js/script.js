// script.js

document.addEventListener("DOMContentLoaded", () => {
  loadBlogPosts();
  setupCreatePostButton();
  setupCreatePostModal();
  setupPostModal();
});

const apiUrl = "http://localhost:8080/blogs"; // Example API

function loadBlogPosts() {
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
          <button class="delete-button" onclick="deletePost('${post.id}')"><i class="fa-solid fa-trash"></i></button>
        `;

        postElement.querySelector("h2").addEventListener("click", () => {
          showFullPost(post);
        });

        blogContainer.appendChild(postElement);
      });
    })
    .catch((error) => {
      console.error("Error fetching posts:", error);
      blogContainer.innerHTML =
        "<p>Failed to load blog posts. Please try again later.</p>";
    });
}

function setupCreatePostButton() {
  document
    .getElementById("create-post-button")
    .addEventListener("click", () => {
      document.getElementById("create-post-modal").style.display = "block";
    });
}

function setupCreatePostModal() {
  const modal = document.getElementById("create-post-modal");
  const closeButton = modal.querySelector(".close-button");

  closeButton.addEventListener("click", () => {
    modal.style.display = "none";
  });

  window.addEventListener("click", (event) => {
    if (event.target === modal) {
      modal.style.display = "none";
    }
  });

  document.getElementById("post-form").addEventListener("submit", (event) => {
    event.preventDefault();

    const title = document.getElementById("title").value;
    const author = document.getElementById("author").value;
    const description = document.getElementById("description").value;

    createPost({ title, author, description });

    modal.style.display = "none";
    document.getElementById("post-form").reset();
  });
}

function createPost(post) {
  fetch(apiUrl, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(post),
  })
    .then((response) => response.json())
    .then((newPost) => {
      console.log("Post created:", newPost);
      loadBlogPosts(); // Refresh the posts
    })
    .catch((error) => {
      console.error("Error creating post:", error);
    });
}

function deletePost(postId) {
  if (confirm("Are you sure you want to delete this post?")) {
    fetch(`${apiUrl}/${postId}`, {
      method: "DELETE",
    })
      .then((response) => {
        if (response.ok) {
          console.log("Post deleted:", postId);
          loadBlogPosts(); // Refresh the posts
        } else {
          console.error("Failed to delete post:", postId);
        }
      })
      .catch((error) => {
        console.error("Error deleting post:", error);
      });
  }
}

function setupPostModal() {
  const postModal = document.getElementById("post-modal");
  const closeButton = postModal.querySelector(".close-button");

  closeButton.addEventListener("click", () => {
    postModal.style.display = "none";
  });

  window.addEventListener("click", (event) => {
    if (event.target === postModal) {
      postModal.style.display = "none";
    }
  });
}

function showFullPost(post) {
  const modal = document.getElementById("post-modal");
  document.getElementById("modal-title").textContent = post.title;
  document.getElementById("modal-author").textContent = "By " + post.author;
  document.getElementById("modal-description").textContent = post.description;

  modal.style.display = "block";
}