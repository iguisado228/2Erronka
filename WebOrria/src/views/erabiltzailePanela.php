<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../public/css/css.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <title>Erabiltzaile gunea</title>

    <style>
        .content .zestoaGuztia {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 900px;
            text-align: center;
            margin: 20px auto;
        }

        .content h2 {
            margin-bottom: 20px;
        }

        .content .zestoa {
            width: 100%;
            border-collapse: collapse;
        }

        .content .zestoa th,
        .content .zestoa td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
            text-align: center;
        }

        .content .zestoa th {
            background-color: #007bff;
            color: white;
        }

        .content .zestoa tr:hover {
            background-color: #f1f1f1;
        }

        .content .zestoa img {
            width: 50px;
            height: auto;
            border-radius: 5px;
        }

        .content tfoot td {
            font-size: 18px;
            background-color: #eee;
        }

        .content .erosiBotoia {
            margin-top: 20px;
            padding: 10px 20px;
            font-size: 16px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: 0.3s;
        }

        .content .erosiBotoia:hover {
            background-color: #218838;
        }
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
                        <th><?= trans("kopuruaEP") ?></th>
                        <th><?= trans("guztiraEP") ?></th>
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
                            echo "<td>" . $kopurua . "</td>";
                            echo "<td>" . number_format($produktuenGehiketa, 2) . "€</td>";
                            echo "</tr>";
                        }
                    } else {
                        echo "<tr><td colspan='5'>". trans("zestoaHutsa"). "</td></tr>";
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
            <button class="erosiBotoia"><?= trans("erosketaEgin") ?></button>
        </div>
    </div>

    <?php require_once("karritoa.php"); ?>

    <footer class="footer">
        <?php require_once "parts/footer.php"; ?>
    </footer>

</body>

</html>