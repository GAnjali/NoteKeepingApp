$(document).ready(function () {
    console.log("in notes from notes.js");
    $.ajax({
        url: "/list-notes/Anju", success: function (result) {
            console.log(result);
        }
    });
});