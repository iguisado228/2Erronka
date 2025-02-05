<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css_m.css">
    <title>Produktuak</title>
    <style>

    </style>
</head>

<body>
    <div class="grid-container">
        <header class="header">
            <?php require_once "header_m.php" ?>
        </header>
        <nav class="nav">
            <?php require_once "menu.php" ?>
        </nav>
        <article class="main">
            <div class="content">
                <div class="botoia">
                    <div class="karritoa2">
                        <h2>Karrito</h2>
                        <div id="karrito-elementuak">
                            <p>Karritoa hutsik dago.</p>
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
                        echo "<p class='produktuPrezioa'>Prezioa: " . $row["prezioa"] . "€</p>";
                        echo "<div class='argazkia'>";
                        echo "<img src='../irudiak/produktuak/" . $row["irudia"] . "' >";
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
            <?php require_once "footer_m.php" ?>
        </footer>
    </div>
<<<<<<< HEAD


<?php
require_once("karritoa.php")
?>
=======
    <?php
    require_once("karritoa.php")
        ?>
>>>>>>> 846eda0c635f523ca6a63aeaca08ceaadcd2ecdd
</body>

</html>