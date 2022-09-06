
const homeUrl = "http://localhost:8081";

const screeningTime = document.querySelector('#screeningTime');
const model = document.querySelector('#screeningModal');
// const adultTicket = document.querySelector("adultTicket");
const seatRef = document.querySelector('#seatRef');

const newForename = document.querySelector('#newForename');
const newSurname = document.querySelector('#newSurname');
const newEmailAddress = document.querySelector('#newEmailAddress');


// const getBooking = (bookingId) => {
//     console.log('bookingId');

//     fetch(`${homeUrl}/booking/getBooking/${bookingId}`, {
//         method: "GET",
//         headers: {
//             "Content-Type": "application/json"
//         }
//     })

// }



const bookTicket = () => {
    // const adultTicketQuant = adultTicket.value;
    const newForenameBook = newForename.value;
    const newSurnameBook = newSurname.value;
    const newEmailAddressBook = newEmailAddress.value;
    //const screeningTimeBook = screeningTime.value;
    const seatRefBook = seatRef.value;

    const bookingData = {
        "forename": newForenameBook,
        "surname": newSurnameBook,
        "emailAddress": newEmailAddressBook,
        "screeningId": seatRefBook,
    }
    console.log(bookingData)

    fetch(`${homeUrl}/booking/createBooking`, {
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
        // .then(model => {
        //     createTicket()
        // })
        .catch(err => console.error(` ${err}`));

        
    const createTicket = (bookingId) => {
        const ticketData = {
            "bookingId": bookingId,
            "seatRef": seatRefBook,
        }
        console.log(ticketData)

    }
};



