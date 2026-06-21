function loadBookings() {

  fetch(BASE_URL + "/bookings")
    .then(res => res.json())
    .then(data => {

      document.getElementById("totalBookings").innerText =
        data.length;

      document.getElementById("paidBookings").innerText =
        data.filter(b =>
          b.paymentStatus === "PAID" &&
          b.status !== "CANCELLED"
        ).length;

      document.getElementById("pendingBookings").innerText =
        data.filter(b =>
          b.paymentStatus === "PENDING" &&
          b.status !== "CANCELLED"
        ).length;

      document.getElementById("cancelledBookings").innerText =
        data.filter(b =>
          b.status === "CANCELLED"
        ).length;

      let html = "";

      data.forEach(b => {

        let statusColor = "";

        if (b.status === "CONFIRMED") {
          statusColor = "green";
        } else if (b.status === "CANCELLED") {
          statusColor = "red";
        } else {
          statusColor = "orange";
        }

        html += `
          <div class="card">

            <p><strong>User:</strong>
              ${b.user?.name || "N/A"}
            </p>

            <p><strong>Slot:</strong>
              ${b.slot?.startTime || "N/A"} -
              ${b.slot?.endTime || ""}
            </p>

            <p><strong>Date:</strong>
              ${b.bookingDate}
            </p>

            <p>
              <strong>Status:</strong>
              <span style="color:${statusColor};font-weight:bold;">
                ${b.status}
              </span>
            </p>

            <p><strong>Payment:</strong>
              ${b.paymentStatus}
            </p>

          </div>
        `;
      });

      document.getElementById("result").innerHTML = html;
    })
    .catch(error => {
      console.error(error);
      alert("Failed to load bookings");
    });
}