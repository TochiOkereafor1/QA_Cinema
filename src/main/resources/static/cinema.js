
const homeUrl = "http://localhost:8081/home";

const screeningTime = document.querySelector('#screeningTime');
const model = document.querySelector('#screeningModal');
// const adultTicket = document.querySelector("adultTicket");
const seatRef = document.querySelector("seatRef");

const newForename = document.querySelector('#newForename');
const newSurname = document.querySelector('#newSurname');
const newEmailAddress = document.querySelector('#newEmailAddress');


const bookTicket = () => {
// const adultTicketQuant = adultTicket.value;
const newForenameBook = newForename.value;
const newSurnameBook = newSurname.value;
const newEmailAddressBook = newEmailAddress.value;

let bookingData = {
    "forename": newForenameBook,
    "surname": newSurnameBook,
    "emailAddress": newEmailAddressBook,
}
console.log(bookingData)

fetch(`${homeUrl}/booking/createBooking`,{
    method: "POST",
    body: JSON.stringify(bookingData),
    headers: {
        "Content-Age": "application/json"
    }
})

.then(response => response.json())
.then(model => {
    console.log(model);
    //getBooking()
})
.catch(err => console.error(` ${err}`));
};