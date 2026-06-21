function loadMyBookings() {

    let user = JSON.parse(localStorage.getItem("user"));

    if (!user) {
        alert("Please login first");
        window.location.href = "login.html";
        return;
    }

    fetch(BASE_URL + "/bookings/user/" + user.id)
        .then(res => res.json())
        .then(data => {

            const today = new Date().toISOString().split("T")[0];

            document.getElementById("totalBookings").innerText =
                data.length;

            document.getElementById("upcomingBookings").innerText =
                data.filter(b =>
                    b.status === "CONFIRMED" &&
                    b.bookingDate >= today
                ).length;

            document.getElementById("completedBookings").innerText =
                data.filter(b =>
                    b.bookingDate < today
                ).length;

            let html = "";

            data.forEach(b => {

                let actionButton = "";

                if (b.status === "CANCELLED") {

                    actionButton =
                        `<button disabled>
                            Cancelled
                        </button>`;

                } else if (b.bookingDate < today) {

                    actionButton =
                        `<button disabled>
                            Completed
                        </button>`;

                } else {

                    actionButton =
                        `<button onclick="cancelBooking(${b.id})">
                            Cancel Booking
                        </button>`;
                }

                html += `
                    <div class="card">

                        <h3>Booking #${b.id}</h3>

                        <p>
                            <strong>Slot:</strong>
                            ${b.slot.startTime} - ${b.slot.endTime}
                        </p>

                        <p>
                            <strong>Date:</strong>
                            ${b.bookingDate}
                        </p>

                        <p>
                            <strong>Status:</strong>
                            ${b.status}
                        </p>

                        <p>
                            <strong>Payment:</strong>
                            ${b.paymentStatus}
                        </p>

                        <br>

                        ${actionButton}

                    </div>

                    <br>
                `;
            });

            if (data.length === 0) {

                html = `
                    <div class="card">
                        <h3>No Bookings Found</h3>
                    </div>
                `;
            }

            document.getElementById("bookings").innerHTML = html;
        })
        .catch(error => {

            console.error(error);

            document.getElementById("bookings").innerHTML =
                "<p>Failed to load bookings</p>";
        });
}

function cancelBooking(id) {

    if (!confirm("Are you sure you want to cancel this booking?")) {
        return;
    }

    fetch(BASE_URL + "/bookings/cancel/" + id, {
        method: "PUT"
    })
    .then(res => {

        if (!res.ok) {
            throw new Error("Failed to cancel booking");
        }

        return res.json();
    })
    .then(() => {

        alert("Booking Cancelled Successfully");

        loadMyBookings();
    })
    .catch(error => {

        console.error(error);

        alert("Unable to cancel booking");
    });
}

function logout() {

    localStorage.removeItem("user");

    window.location.href = "login.html";
}