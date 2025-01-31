$(document).ready(function() {
    $("#loginForm").submit(function(event) {
        event.preventDefault(); 
        
        var erabiltzailea = $("#username").val();
        var pasahitza = $("#password").val();
        
        $.ajax({
            url: "saioHasiera.php", 
            type: "POST",
            data: {
                erabiltzailea: erabiltzailea,
                pasahitza: pasahitza
            },
            success: function(response) {
                if (response === "success") {
                    alert("Saio hasiera ongi gauzatu da!");
                    window.location.href = "index_m.php";
                } else {
                    alert("Erabiltzailea edo pasahitza ez da zuzena.");
                }
            },
            error: function() {
                alert("Errore bat egon da!");
            }
        });
    });
});
