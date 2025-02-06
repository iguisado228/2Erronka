<?php

session_start();
include("db.php");
$conn = konexioaSortu();

if (isset($_GET['erabiltzailea']) && isset($_GET['pasahitza'])) {
    $erabiltzailea = strval(value: $_GET['erabiltzailea']);
    $pasahitza = strval(value: $_GET['pasahitza']);

    $sql = "SELECT * FROM bezeroa WHERE erabiltzaileIzena = '$erabiltzailea' and pasahitza='$pasahitza'";
    $result = mysqli_query($conn, $sql);

    $datuak = [];
    $_SESSION['erabiltzaileaId'] = 0;
    $_SESSION['helbideaErabiltzailea'] = "";
    if (mysqli_num_rows($result) > 0) {
        $_SESSION['erabiltzailea'] = $erabiltzailea;

        while ($fila = mysqli_fetch_assoc($result)) {
            $datuak[] = $fila;
            $_SESSION['erabiltzaileaId'] = $fila['idBezeroa'];
            $_SESSION['helbideaErabiltzailea'] = $fila['helbidea'];
        }
    }

    echo json_encode(["kopurua" => count($datuak), "datuak" => $datuak]);
}
?>