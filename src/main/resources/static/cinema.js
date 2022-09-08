
const homeUrl = "http://localhost:8081";

const screeningTime = document.querySelector('#screeningTime');
const model = document.querySelector('#screeningModal');
const adultTicket = document.querySelector("#adultTicket");
const childTicket = document.querySelector("#childTicket");
const concTicket = document.querySelector("#concTicket");
// const seatRef = document.querySelector('#seatRef');
//const screeningId = document.querySelector('#screeningId');

var screeningId = 1;
const newForename = document.querySelector('#newForename');
const newSurname = document.querySelector('#newSurname');
const newEmailAddress = document.querySelector('#newEmailAddress');

// const screening1 = document.querySelector('#screening1');
// const screening2 = document.querySelector('#screening2');

// screening1.onclick = function () {
//     screeningId = 1;
// }

// screening2.onclick = function () {
//     screeningId = 2;
// }

// const getBooking = (bookingId) => {
//     console.log('bookingId');

//     fetch(`${homeUrl}/booking/getBooking/${bookingId}`, {
//         method: "GET",
//         headers: {
//             "Content-Type": "application/json"
//         }
//     })

// }

// const createTicket = (bookingId) => {
//     const ticketData = {
//         "bookingId": bookingId,
//         "seatRef": seatRef.value,
//     }
//     fetch(`${homeUrl}/booking/createTicket`, {
//         method: "POST",
//         headers: {
//             "Content-Type": "application/json",
//             mode: 'cors',


//         },
//         body: JSON.stringify(ticketData),
//     })
//         .then(response => response.json())
//         .then(data => console.log(data))
//         .catch(err => console.err(err))
//     console.log(ticketData)



// }

const bookTicket = () => {
    const adultTicketBook = adultTicket.value;
    const childTicketBook = childTicket.value;
    const concTicketBook = concTicket.value;
    const newForenameBook = newForename.value;
    const newSurnameBook = newSurname.value;
    const newEmailAddressBook = newEmailAddress.value;
    const screeningIdBook = screeningId;
    //const seatRefBook = seatRef.value;

    const bookingData = {
        "forename": newForenameBook,
        "surname": newSurnameBook,
        "emailAddress": newEmailAddressBook,
        "screeningId": screeningIdBook,
        "adultTickets": adultTicketBook,
        "childTickets": childTicketBook,
        "concessionTickets": concTicketBook,
    }
    console.log(bookingData)

    fetch(`${homeUrl}/booking/createBooking`, {
        method: "POST",
        body: JSON.stringify(bookingData),
        headers: {
            "Content-Type": "application/json"

        },
        //body: JSON.stringify(bookingData),
    })

        .then((response) => response.json())
        .then((data) => {
            console.log(data);
        })

        .catch(err => console.error(`${err}`));


};



