<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../../public/css/css.css">
    <title>Produktuak</title>
    <style>

    </style>
</head>

<body>
    <div class="grid-container">
        <header class="header">
            <?php require_once "parts/header.php" ?>
        </header>
        <nav class="nav">
            <?php require_once "parts/menu.php" ?>
        </nav>
        <article class="main">
            <div class="content">
            <div class="botoia">
                <div class="karritoa2">
                    <h2><?= trans("erosketaZestoa") ?></h2>
                    <div id="karrito-elementuak">
                        <?= trans("zestoaHutsik") ?>
                    </div>
                </div>
            </div>
                <?php
                require_once("db.php");

                $conn = konexioaSortu();

                if ($conn->connect_error) {
                    die("Konexioa egiterako orduan errore bat egon da: " . $conn->connect_error);
                }

                $sql = "SELECT idProduktua, izena, prezioa, irudia FROM produktua";
                $result = $conn->query($sql);

                if ($result->num_rows > 0) {
                    echo "<div class='produktuak'>";
                    while ($row = $result->fetch_assoc()) {
                        echo "<div class='produktua' data-idProduktua='" . $row["idProduktua"] . "' data-name='" . $row["izena"] . "' data-price='" . $row["prezioa"] . "'>";
                        echo "<h2 class='produktuIzena'>" . $row["izena"] . "</h2>";
                        echo "<p class='produktuPrezioa'>". trans("prezioa") . $row["prezioa"] . "€</p>";
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
                    echo "Ez dira produktuak geratzen";
                }
                $conn->close();
                ?>
            </div>
        </article>
        <footer class="footer">
            <?php require_once "parts/footer.php" ?>
        </footer>
    </div>


<?php
require_once("karritoa.php")
?>

</body>

</html>