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
    <link rel="stylesheet" href="css_m.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <style>
        body #erregistratu {
            font-family: Arial, sans-serif;
            background-color: #e0f7fa;
            color: #01579b;
            align-items: center;
            text-align: center;
            padding: 20px;
        }

        h1 {
            color: #0277bd;
            text-align: center;
        }

        form {
            background: #b3e5fc;
            max-width: 400px;
            margin: auto;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"],
        input[type="email"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #0288d1;
            border-radius: 5px;
        }

        button {
            background: #0288d1;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin-top: 15px;
        }

        button:hover {
            background: #0277bd;
        }
    </style>
</head>

<body id="erregistratu">
    <header class="header">
        <?php require_once "header_m.php" ?>
    </header>
    <nav class="nav">
        <?php require_once "menu.php" ?>
    </nav>
    <article class="main">
        <div class="content">
            
            <form method="post" action="erabiltzaileaErregistratu.php">
            <h1>Sartu zure datuak</h1>
                <label for="nan">Nan</label>
                <input type="text" name="nan" id="nan" required><br><br>

                <label for="izena">Izena</label>
                <input type="text" name="izena" id="izena" required><br><br>

                <label for="abizena">Abizena/Abizenak</label>
                <input type="text" name="abizena" id="abizena"><br><br>

                <label for="telefonoa">Tlf.Zenbakia</label>
                <input type="text" name="telefonoa" id="telefonoa" placeholder="XXX-XXX-XXX" pattern="[0-9]{9}"> <br>
                <br>

                <label for="helbidea">Helbidea</label>
                <input type="text" name="helbidea" id="helbidea"><br><br>

                <label for="erabiltzaileIzena">Erabiltzaile izena</label>
                <input type="text" name="erabiltzaileIzena" id="erabiltzaileIzena" required><br><br>

                <label for="pasahitza">Pasahitza</label>
                <input type="password" name="pasahitza" id="pasahitza" required><br><br>

                <label for="helbideElektronikoa">Helbide elektronikoa</label>
                <input type="email" name="helbideElektronikoa" id="helbideElektronikoa" placeholder="exmpl@gmail.com"
                    pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}" required> <br><br>


                <button type="submit" name="erregistratu">Erregistratu</button>
            </form>

        </div>
    </article>
    <footer class="footer">
            <?php require_once "footer_m.php" ?>
        </footer>
    <?php
    $conn->close();
    ?>
</body>

</html>