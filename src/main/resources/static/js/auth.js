function register() {

  fetch("http://localhost:8080/api/users/register", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      name: document.getElementById("name").value,
      email: document.getElementById("email").value,
      password: document.getElementById("password").value,
      role: "USER"
    })
  })
  .then(res => res.json())
  .then(data => {
    alert("Registered Successfully");
    window.location.href = "login.html";
  })
  .catch(err => {
    console.log(err);
    alert("Registration failed");
  });

}
function login() {

  fetch("http://localhost:8080/api/users/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      email: document.getElementById("email").value,
      password: document.getElementById("password").value
    })
  })
  .then(res => {
    if (!res.ok) {
      throw new Error("Invalid credentials");
    }
    return res.json();
  })
  .then(user => {

    alert("Login Successful ");

    localStorage.setItem("user", JSON.stringify(user));

    if (user.role === "ADMIN") {
      alert("Welcome Admin ");
      window.location.href = "admin-dashboard.html";
    } else {
      alert("Welcome User ");
      window.location.href = "booking.html";
    }

  })
  .catch(err => {
    console.log(err);
    alert("Login Failed.Check email or password");
  });

}
