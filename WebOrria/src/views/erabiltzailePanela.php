<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../public/css/css.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <title>Erabiltzaile gunea</title>

    <style>
        
    </style>
</head>

<body class="grid-container">
    <header class="header">
        <?php require_once "parts/header.php"; ?>
    </header>

    <nav class="nav">
        <?php require_once "parts/menu.php"; ?>
    </nav>

    <div class="content">
        <div class="zestoaGuztia">
            <h2><?= trans("erosketarenBaieztapena") ?></h2>
            <table class="zestoa">
                <thead>
                    <tr>
                        <th><?= trans("produktuaEP") ?></th>
                        <th><?= trans("irudiaEP") ?></th>
                        <th><?= trans("prezioaEP") ?></th>
                        <th><?= trans(indexPhrase: "egoeraEP") ?></th>
                        <th><?= trans(indexPhrase: "guztiraEP") ?></th>
                    </tr>
                </thead>
                <tbody>
                    <?php

                    require_once("db.php");

                    $conn = konexioaSortu();

                    if ($conn->connect_error) {
                        die("Konexioa egiterako orduan errore bat egon da: " . $conn->connect_error);
                    }

                    if (!isset($_SESSION['erabiltzaileaId'])) {
                        die("Erabiltzaileak ez du saioa hasi.");
                    }

                    $idErabiltzailea = intval($_SESSION['erabiltzaileaId']); // ida zenbaki batean bihurtzen da
                    
                    $sql = "SELECT 
            e.idEskaera, 
            e.bezeroa_idBezeroa, 
            e.produktua_idProduktua, 
            e.eskaeraData, 
            e.egoera,
            p.izena, 
            p.prezioa, 
            p.irudia 
        FROM eskaera e 
        JOIN produktua p ON e.produktua_idProduktua = p.idProduktua 
        WHERE e.bezeroa_idBezeroa = $idErabiltzailea";

                    $result = $conn->query($sql);

                    if ($result === false) {
                        die("Errore bat gertatu da: " . $conn->error);
                    }
                    $ordainketaGuztira = 0;
                    if ($result->num_rows > 0) {
                        while ($row = $result->fetch_assoc()) {
                            $kopurua = 1;
                            $produktuenGehiketa = $row["prezioa"] * $kopurua;
                            $ordainketaGuztira += $produktuenGehiketa;

                            echo "<tr>";
                            echo "<td>" . $row["izena"] . "</td>";
                            echo "<td><img src='../../public/irudiak/produktuak/" . $row["irudia"] . "' ></td>";
                            echo "<td>" . $row["prezioa"] . "€</td>";
                            echo "<td>" . $row["egoera"] . "</td>";
                            echo "<td>" . number_format($produktuenGehiketa, 2) . "€</td>";
                            echo "</tr>";
                        }
                    } else {
                        echo "<tr><td colspan='5'>" . trans("zestoaHutsa") . "</td></tr>";
                    }

                    $conn->close();
                    ?>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="4"><strong><?= trans("prezioaGuztira") ?></strong></td>
                        <td><strong><?php echo number_format($ordainketaGuztira, 2); ?>€</strong></td>
                    </tr>
                </tfoot>
            </table>
            <button class="erosiBotoia" data-id="<?= $idErabiltzailea ?>"><?= trans("erosketaEgin") ?></button>
        </div>
    </div>

    <?php require_once("karritoa.php"); ?>

    <footer class="footer">
        <?php require_once "parts/footer.php"; ?>
    </footer>



    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function () {

            function taulaEguneratu() {
                var erabiltzaileaId = $(".erosiBotoia").data("id");

                $.ajax({
                    url: "parts/egoeraUpdate.php",
                    type: "POST",
                    data: { idErabiltzailea: erabiltzaileaId, eguneraketa: "fetch" },
                    dataType: "json",
                    success: function (response) {
                        if (response.success) {
                            var tableBody = $(".zestoa tbody");
                            tableBody.empty();
                            var totalAmount = 0;

                            response.egoerak.forEach(function (eskaera) {
                                var row = `<tr>
                                <td>${eskaera.izena}</td>
                                <td><img src='../../public/irudiak/produktuak/${eskaera.irudia}'></td>
                                <td>${eskaera.prezioa}€</td>
                                <td id='egoera-${eskaera.idEskaera}'>${eskaera.egoeraAldatua}</td>
                                <td>${(eskaera.prezioa * eskaera.kopurua).toFixed(2)}€</td>
                            </tr>`;

                                totalAmount += eskaera.prezioa * eskaera.kopurua;
                                tableBody.append(row);
                            });

                            $(".zestoa tfoot td:last-child").html(`<strong>${totalAmount.toFixed(2)}€</strong>`);
                        } else {
                            alert("Errorea: " + response.message);
                        }
                    },
                    error: function () {
                        alert("Errorea datuak bidaltzerakoan.");
                    }
                });
            }

            $(".erosiBotoia").click(function () {
                var erabiltzaileaId = $(this).data("id");

                $.ajax({
                    url: "parts/egoeraUpdate.php",
                    type: "POST",
                    data: { idErabiltzailea: erabiltzaileaId },
                    dataType: "json",
                    success: function (response) {
                        if (response.success) {
                            taulaEguneratu();
                        } else {
                            alert("Errorea: " + response.message);
                        }
                    },
                    error: function () {
                        alert("Errorea datuak bidaltzerakoan.");
                    }
                });
            });

            taulaEguneratu();
        });
    </script>


</body>

</html>