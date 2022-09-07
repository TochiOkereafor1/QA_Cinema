
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

const createTicket = (bookingId) => {
    const ticketData = {
        "bookingId": bookingId,
        "seatRef": seatRef.value,
    }
    fetch(`${homeUrl}/booking/createTicket`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            mode: 'cors',


        },
        body: JSON.stringify(ticketData),
    })
        .then(response => response.json())
        .then(data => console.log(data))
        .catch(err => console.err(err))


    console.log(ticketData)



}

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

        },
        //body: JSON.stringify(bookingData),
    })

        .then((response) => response.json())
        .then((data) => {
            createTicket(data.bookingId);
        })

         .catch(err => console.error(`${err}`));


};



// function onLoaderFunc() {
//     $(".seatStructure *").prop("disabled", true);
//     $(".displayerBoxes *").prop("disabled", true);
// }
// function takeData() {
//     if (($("#Username").val().length == 0) || ($("#Numseats").val().length == 0)) {
//         alert("Please Enter your Name and Number of Seats");
//     }
//     else {
//         $(".inputForm *").prop("disabled", true);
//         $(".seatStructure *").prop("disabled", false);
//         document.getElementById("notification").innerHTML = "<b style='margin-bottom:0px;background:yellow;'>Please Select your Seats NOW!</b>";
//     }
// }


// function updateTextArea() {

//     if ($("input:checked").length == ($("#Numseats").val())) {
//         $(".seatStructure *").prop("disabled", true);

//         var allNameVals = [];
//         var allNumberVals = [];
//         var allSeatsVals = [];

//         //Storing in Array
//         allNameVals.push($("#Username").val());
//         allNumberVals.push($("#Numseats").val());
//         $('#seatsBlock :checked').each(function () {
//             allSeatsVals.push($(this).val());
//         });

//         //Displaying 
//         $('#nameDisplay').val(allNameVals);
//         $('#NumberDisplay').val(allNumberVals);
//         $('#seatsDisplay').val(allSeatsVals);
//     }
//     else {
//         alert("Please select " + ($("#Numseats").val()) + " seats") //creates alert box if constraints aren't fulfilled
//     }
// }


// function myFunction() {
//     alert($("input:checked").length);
// }

/*
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}
*/


// $(":checkbox").click(function () {
//     if ($("input:checked").length == ($("#Numseats").val())) {
//         $(":checkbox").prop('disabled', true);
//         $(':checked').prop('disabled', false);
//     }
//     else {
//         $(":checkbox").prop('disabled', false);
//     }
// });


