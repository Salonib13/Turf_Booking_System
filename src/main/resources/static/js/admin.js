function loadBookings() {

  fetch(BASE_URL + "/bookings")
    .then(res => res.json())
    .then(data => {

      
      document.getElementById("totalBookings").innerText = data.length;

      document.getElementById("paidBookings").innerText =
        data.filter(b => b.paymentStatus === "PAID").length;

      document.getElementById("pendingBookings").innerText =
        data.filter(b => b.paymentStatus === "PENDING").length;

      let html = "";

      data.forEach(b => {

        html += `
          <div class="card">
            <p><strong>User:</strong> ${b.user?.name || "N/A"}</p>
            <p><strong>Slot:</strong> ${b.slot?.startTime || "N/A"} - ${b.slot?.endTime || ""}</p>
            <p><strong>Date:</strong> ${b.bookingDate}</p>
            <p><strong>Payment:</strong> ${b.paymentStatus}</p>
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