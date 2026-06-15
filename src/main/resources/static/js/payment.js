function makePayment() {

  let bookingId = localStorage.getItem("bookingId");

  if (!bookingId) {
    alert("No booking found");
    return;
  }

  fetch(BASE_URL + "/payment/process/" + bookingId, {
    method: "POST"
  })
  .then(res => res.text())
  .then(msg => {
    alert("Payment Completed");
  });
 }