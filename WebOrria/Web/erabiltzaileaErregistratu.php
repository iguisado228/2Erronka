<?php
require_once("db.php");

$conn = konexioaSortu();

if (isset($_POST["erregistratu"])) {
    $nan = $_POST["nan"];
    $izena = $_POST["izena"];
    $abizena = $_POST["abizena"];
    $telefonoa = $_POST["telefonoa"];
    $helbidea = $_POST["helbidea"];
    $erabiltzaileIzena = $_POST["erabiltzaileIzena"];
    $pasahitza = $_POST["pasahitza"];
    $helbideElektronikoa = $_POST["helbideElektronikoa"];



    if (!empty($izena) && !empty($nan) && !empty($erabiltzaileIzena) && !empty($pasahitza) && !empty($helbideElektronikoa)) {
        $sql = "INSERT INTO bezeroa (NAN, izena, abizena, telefonoa, helbidea, erabiltzaileIzena, pasahitza, helbideElektronikoa) VALUES ('$nan', '$izena', '$abizena', '$telefonoa', '$helbidea', '$erabiltzaileIzena', '$pasahitza', '$helbideElektronikoa')";

        if ($conn->query($sql) === TRUE) {
            header("Location: index_m.php");
            die();
        } else {
            echo "Error: " . $conn->error;
        }
    }
}
?>

<!DOCTYPE html>
<html>

<head>
    <title>Erregistratu</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css_m.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <style>
       
    </style>
</head>

<body class="grid-container">
    <header class="header">
        <?php require_once "header_m.php" ?>
    </header>
    <nav class="nav">
        <?php require_once "menu.php" ?>
    </nav>
    <div class="content">
    <div class="botoia">
                <div class="cart">
                    <h2>Karrito</h2>
                    <div id="cart-items">
                        <p>Karritoa hutsik dago.</p>
                    </div>
                </div>
        <article class="main">

            <form method="post" action="erabiltzaileaErregistratu.php" class="ERformularioa">
                <h1 class="ERh1">Sartu zure datuak</h1>
                <label for="nan" class="ERetiketa">Nan</label>
                <input type="text" name="nan" id="nan" required><br><br>

                <label for="izena" class="ERetiketa">Izena</label>
                <input type="text" name="izena" id="izena" required><br><br>

                <label for="abizena" class="ERetiketa">Abizena/Abizenak</label>
                <input type="text" name="abizena" id="abizena"><br><br>

                <label for="telefonoa" class="ERetiketa">Tlf.Zenbakia</label>
                <input type="text" name="telefonoa" id="telefonoa" placeholder="XXX-XXX-XXX" pattern="[0-9]{9}"> <br>
                <br>

                <label for="helbidea" class="ERetiketa">Helbidea</label>
                <input type="text" name="helbidea" id="helbidea"><br><br>

                <label for="erabiltzaileIzena" class="ERetiketa">Erabiltzaile izena</label>
                <input type="text" name="erabiltzaileIzena" id="erabiltzaileIzena" required><br><br>

                <label for="pasahitza" class="ERetiketa">Pasahitza</label>
                <input type="password" name="pasahitza" id="pasahitza" required><br><br>

                <label for="helbideElektronikoa" class="ERetiketa">Helbide elektronikoa</label>
                <input type="email" name="helbideElektronikoa" id="helbideElektronikoa" placeholder="exmpl@gmail.com"
                    pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}" required> <br><br>


                <button type="submit" class="ERbotoia" name="erregistratu">Erregistratu</button>
            </form>
        </article>

    </div>
    <footer class="footer">
        <?php require_once "footer_m.php" ?>
    </footer>
    <?php
    $conn->close();
    ?>
    <?php
    require_once("karritoa.php");
    ?>
</body>

</html>