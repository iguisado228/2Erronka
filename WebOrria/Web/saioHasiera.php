<!DOCTYPE html>
<html lang="es">

<head>
    <link rel="stylesheet" href="css_m.css">
</head>

<body>
    <div class="lehioa-contenido">
        <a href="#" class="itxi">&times;</a>
        <h1>Saio Hasiera</h1>
        <form method="POST">
            <div class="erabiltzailea">
                <input class="sesioHasiera" type="text" id="erabiltzailea" name="erabiltzailea" required />
                <label for="erabiltzailea">Erabiltzailea</label>
            </div>
            <div class="pasahitza">
                <input class="sesioHasiera" type="password" id="pasahitza" name="pasahitza" required />
                <label for="pasahitza">Pasahitza</label>
            </div>
            <input type="submit" value="Saioa Hasi" id="bidali" />
            <div class="erregistratu">
                <a href="erabiltzaileaErregistratu.php">Erregistratu</a> egin nahi dut.
            </div>
        </form>
    </div>
    <?php

    ?>

    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script>
        $(document).ready(function () {

            $("#bidali").on("click", function (e) {
                e.preventDefault();
                login();
            });



        });
        function login() {
            var erabiltzailea = $("#erabiltzailea").val();
            var pasahitza = $("#pasahitza").val();

            $.ajax({
                url: "loginEgiaztatu.php",
                type: "GET",
                data: { erabiltzailea: erabiltzailea, pasahitza: pasahitza }
            })
                .done(function (bueltatutakoInfo) {
                    var datuak = JSON.parse(bueltatutakoInfo);
                    if (datuak.kopurua > 0) {
                        window.location.href = 'index_m.php';
                    } else {
                        alert("Erabiltzailea edo pasahitza ez da zuzena.");
                    }
                })
                .fail(function () {
                    alert("Errore bat egon da");
                });
        }

    </script>
</body>