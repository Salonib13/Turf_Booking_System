let selectedSlotId = null;
function loadSlots() {

  fetch(BASE_URL + "/slots")
    .then(response => response.json())
    .then(slots => {

      let html = "";

      slots.forEach(slot => {

        html += `
          <div class="slot-card">
            <div>
              <h4>${slot.startTime} - ${slot.endTime}</h4>
            </div>

            <button class="btn"
                    onclick="selectSlot(${slot.id})">
              Select
            </button>
          </div>
        `;
      });

      document.getElementById("slots").innerHTML = html;

    })
    .catch(err => {
      console.log(err);
      document.getElementById("slots").innerHTML =
        "<p>No slots available</p>";
    });
}

function selectSlot(id) {
  selectedSlotId = id;
  alert("Slot Selected");
}

function bookSlot() {

  let user = JSON.parse(localStorage.getItem("user"));

  if (!user) {
    alert("Please login first");
    return;
  }

  let date = document.getElementById("date").value;
  let paymentStatus = document.getElementById("paymentStatus").value;

  if (!date) {
    alert("Please select a date");
    return;
  }

  if (!selectedSlotId) {
    alert("Please select a slot");
    return;
  }

  if (!paymentStatus) {
    alert("Please select payment status");
    return;
  }

  fetch(BASE_URL + "/bookings/create", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      userId: user.id,
      slotId: selectedSlotId,
      bookingDate: date,
      paymentStatus: paymentStatus
    })
  })
  .then(res => {

    if (!res.ok) {
      throw new Error("Slot already booked");
    }

    return res.json();
  })
  .then(data => {

    alert(
      "Booking Successful!\n" +
      "Booking ID: " + data.id + "\n" +
      "Date: " + date + "\n" +
      "Payment: " + paymentStatus
    );

    selectedSlotId = null;
    loadSlots();
  })
  .catch(err => {

    console.log(err);

    alert(
      "Slot already booked.\nPlease choose another slot."
    );
  });
}