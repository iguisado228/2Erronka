<?php
session_start();


if (!isset($_SESSION["erabiltzailea"])) {
    die("Saioa hasi gabe zaude.");
}

include 'db.php';
$conn = konexioaSortu();
if (!isset($conn)) {
    die("Datu baseekin konexioa ez da gauzatu");
}

if ($_SERVER["REQUEST_METHOD"] === "POST") {
    if (!isset($_SESSION["erabiltzailea"])) {
        echo "Errorea: Erabiltzailea ez du saioa hasi.";
        exit;
    }

    $erabiltzailea = $_SESSION["erabiltzailea"];
    $idBezeroa = $_SESSION["erabiltzaileaId"];
    $helbidea = $_SESSION["helbideaErabiltzailea"] ?? "Helbidea ez dago eskuragarri"; /* Helbidea ez dago eskuragarri jartzen du momentu guztian, ez du bezeroaren helbidea ongi gordetzen loginEgiaztatu dokumentuan */
    $eskaeraData = date("Y-m-d H:i:s");
    $egoera = "Berrikusten";

    if (!isset($_POST["produktuak"])) {
        echo "Errorea: Ez dago produkturik karritoan.";
        exit;
    }

    $produktuak = json_decode($_POST["produktuak"], true);

    if (empty($produktuak)) {
        echo "Errorea: Ez dago produkturik karritoan.";
        exit;
    }

    $conn->begin_transaction();

    try {
        $idEskaera = uniqid(); /* Zenbaki random bat jartzen du, aldatu egin behar da, auto increment bat egin dezan */

        foreach ($produktuak as $produktua) {
            $idProduktua = $produktua["id"];

            $stmt = $conn->prepare("INSERT INTO eskaera (idEskaera, bezeroa_idBezeroa, produktua_idProduktua, helbidea, eskaeraData, egoera) 
                                    VALUES (?, ?, ?, ?, ?, ?)");
            $stmt->bind_param("iiisss", $idEskaera, $idBezeroa, $idProduktua, $helbidea, $eskaeraData, $egoera);
            $stmt->execute();
        }

        $conn->commit();
        echo " Eskaera ongi gorde da!";
    } catch (Exception $e) {
        $conn->rollback();
        echo "Errorea: " . $e->getMessage();
    }
}
?>