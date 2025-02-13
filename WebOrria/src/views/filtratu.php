<?php
define('APP_DIR', $_SERVER['DOCUMENT_ROOT'] . '/2ERRONKA/WebOrria');
define('HREF_VIEWS_DIR', '/2ERRONKA/WebOrria/src/views'); 

require_once(APP_DIR . "/src/translation/translations.php"); 
require_once("db.php");

$conn = konexioaSortu();
if ($conn->connect_error) {
    die("Konexioa egiterako orduan errore bat egon da: " . $conn->connect_error);
}

$sql = "SELECT idProduktua, izena, prezioa, irudia FROM produktua WHERE 1=1";

if (!empty($_GET["produktuaBilatu"])) {
    $produktuaBilatu = $conn->real_escape_string($_GET["produktuaBilatu"]);
    $sql .= " AND izena LIKE '%$produktuaBilatu%'";
}

if (!empty($_GET["gutxienekoPrezioa"])) {
    $gutxienekoPrezioa = (int) $_GET["gutxienekoPrezioa"];
    $sql .= " AND prezioa >= $gutxienekoPrezioa";
}

if (!empty($_GET["gehienezkoPrezioa"])) {
    $gehienezkoPrezioa = (int) $_GET["gehienezkoPrezioa"];
    $sql .= " AND prezioa <= $gehienezkoPrezioa";
}

$result = $conn->query($sql);

if ($result->num_rows > 0) {
    echo "<h1 class='filtratutakoProduktuak'>Filtratutako produktuak</h1>"; 
    echo "<div class='produktuak'>";
    while ($row = $result->fetch_assoc()) {
        echo "<div class='produktua' data-idProduktua='" . $row["idProduktua"] . "' data-name='" . $row["izena"] . "' data-price='" . $row["prezioa"] . "'>";
        echo "<h2 class='produktuIzena'>" . $row["izena"] . "</h2>";
        echo "<p class='produktuPrezioa'>" . trans("prezioa") . $row["prezioa"] . "€</p>";
        echo "<div class='argazkia'>";
        echo "<img src='../../public/irudiak/produktuak/" . $row["irudia"] . "' >";
        echo "</div>";
        echo "<div class='gehituBotoia'>";
        echo "<button class='gehitu-karritora'>Gehitu zestora</button>";
        echo "</div>";
        echo "</div>";
    }
    echo "</div>";
} else {
    echo "<h1 class='produktuGabe'>Ez da produkturik aurkitu</h1>"; 
}


$conn->close();
?>
