<?php
require_once("db.php");
$conn = konexioaSortu();
 
if (isset($_GET['erabiltzailea']) && isset($_GET['pasahitza'])){
    $erabiltzailea= strval(value: $_GET['erabiltzailea']);
    $pasahitza= strval(value: $_GET['pasahitza']);
 
    $sql = "SELECT * FROM bezeroa WHERE erabiltzaileIzena = '$erabiltzailea' and pasahitza='$pasahitza'";
    $result = $conn->query($sql);
    $erabiltzailea = [];
 
    if ($result->num_rows > 0) {
        $counter = 0;
        while ($row = $result->fetch_assoc()) {
            $erabiltzailea[$counter] = ["Erabiltzailea" => $row["erabiltzaileIzena"]];
            $counter++;
        }
       
        $erabiltzailea["kopurua"] = $counter;
        echo json_encode($erabiltzailea);
        die;
 
    } else {
        $erabiltzailea["kopurua"] = 0;
        echo json_encode($erabiltzailea);
        die;
    }
}