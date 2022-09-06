
const homeUrl = "http://localhost:8081";

const screeningTime = document.querySelector('#screeningTime');
const model = document.querySelector('#screeningModal');
// const adultTicket = document.querySelector("adultTicket");
const seatRef = document.querySelector('#seatRef');

const newForename = document.querySelector('#newForename');
const newSurname = document.querySelector('#newSurname');
const newEmailAddress = document.querySelector('#newEmailAddress');


const bookTicket = () => {
    // const adultTicketQuant = adultTicket.value;
    const newForenameBook = newForename.value;
    const newSurnameBook = newSurname.value;
    const newEmailAddressBook = newEmailAddress.value;
    const seatRefBook = seatRef.value;

    const bookingData = {
        "forename": newForenameBook,
        "surname": newSurnameBook,
        "emailAddress": newEmailAddressBook,
        "screeningId": seatRefBook,
    }
    console.log(bookingData)

    fetch(`http://localhost:8081/booking/createBooking`, {
        method: "POST",
        body: JSON.stringify(bookingData),
        headers: {
            "Content-Type": "application/json"
        }
    })

        .then(response => response.json())
        .then(model => {
            console.log(model);
            //getBooking()
        })
        .catch(err => console.error(` ${err}`));
};