<?php
define('APP_DIR', value: $_SERVER['DOCUMENT_ROOT'] . '/2ERRONKA/WebOrria'); //Aplikazioaren karpeta edozein lekutatik atzitzeko.
define('HREF_VIEWS_DIR', '/2ERRONKA/WebOrria/src/views'); //Aplikazioaren views karpeta edozein lekutatik deitzeko

require_once(APP_DIR . "/src/translation/translations.php"); //APP_DIR erabilita itzulpenen dokumentua atzitu dugu.

?>

<!DOCTYPE html>
<html lang="es">

<head>
    <link rel="stylesheet" href="../../public/css/css.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
    <div class="lehioa-contenido">
        <a href="#" class="itxi">&times;</a>
        <h1><?= trans("saioHasiera") ?></h1>
        <form method="POST">
            <div class="erabiltzailea">
                <input class="sesioHasiera" type="text" id="erabiltzailea" name="erabiltzailea" required />
                <label for="erabiltzailea"><?= trans("erabiltzailea") ?></label>
            </div>
            <div class="pasahitza">
                <input class="sesioHasiera" type="password" id="pasahitza" name="pasahitza" required />
                <label for="pasahitza"><?= trans("pasahitza") ?></label>
            </div>
            <input type="submit" value="Saioa Hasi" id="bidali" />
            <div class="erregistratu">
                <a href="erabiltzaileaErregistratu.php"><?= trans("erregistratu") ?></a> <?= trans("eginNahi") ?>.
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
                        window.location.href = 'index.php';
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