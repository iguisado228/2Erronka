
<?php
$output = "";
$username = "root";
$password = "1MG2024";
$dbname = "2.erronka";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Konexioa egiterako orduan errore bat egon da: " . $conn->connect_error);
}

$sql = "SELECT izena, prezioa, irudia FROM produktua";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    echo "<div class='produktuak'>";
    while($row = $result->fetch_assoc()) {
        echo "<div class='produktua'>";
        echo "<h2>" . $row["izena"]. "</h2>";
        echo "<p>Prezioa: " . $row["prezioa"]. "€</p>";
        echo "<img src='../irudiak/produktuak/".$row["irudia"]."' >";

        echo "</div>";
    }
    echo "</div>";
} else {
    echo "Ez dira produktuak geratzen";
}
$conn->close();
?>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Produktuak</title>
    <style>
        .produktuak {
            display: flex;
            flex-wrap: wrap;
        }
        .produktua {
            border: 1px solid #ccc;
            padding: 16px;
            margin: 16px;
            width: 30%;
            box-sizing: border-box;
        }
        @media (max-width: 768px) {
            .produktua {
                width: 30%;
            }
        }
        @media (max-width: 480px) {
            .produktua {
                width: 100%;
            }
        }

        .produktua img {
            width: 100%;
            height: auto;
        }
    </style>
</head>
<body>
    <h1>Produktuen katalogoa</h1>
    <?php echo $output; ?>
</body>
</html>