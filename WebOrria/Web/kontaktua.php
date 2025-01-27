<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css_m.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <title>Kontaktua</title>
</head>

<body class="grid-container">
    <header class="header">
        <?php require_once "header_m.php" ?>
    </header>

    <nav class="nav">

        <?php require_once "menu.php" ?>

    </nav>
    <div class="content">

        <div class="formularioa">
            <form action="" method="get">
                <h1>Kontaktatu</h1> <br>

                <label for="izena">Izena*</label>
                <input type="text" name="izena" id="izena" required> <br> <br>
                <label for="abizena">Abizena</label>
                <input type="text" name="abizena" id="abizena"> <br> <br>
                <label for="telefonoa">Telefonoa*</label>
                <input type="tel" name="telefonoa" id="telefonoa" placeholder="+34 6xxxxxxx" required> <br> <br>
                <label for="emaila">Emaila*</label>
                <input type="email" name="emaila" id="emaila" pattern=".+@.+\..+" required> <br> <br>

                <label for="informazioajaso"><strong> Nola jaso nahi duzu informazioa?*</strong></label> <br> <br>

                <input type="radio" name="informazioajaso" id="telefonozjaso" checked value="telefonoz">
                <label for="informazioajaso">Telefono bidez</label> <br>



                <input type="radio" name="informazioajaso" id="emailezjaso" value="emailez">
                <label for="informazioajaso">Email bidez</label> <br> <br>

                <label for="errorea">Akats mota*</label>
                <select id="arazoa">
                    <option disabled selected>Arazoa</option>
                    <option value="bueltatu">Gailua bueltatu nahi dut</option>
                    <option value="konponketa">Arazo bat konpondu nahi du</option>
                    <option value="bestelakoa">Beste arazo bat</option>
                </select> <br> <br>

                <label for="explikazioa">Esplikatu zure arazoa</label> <br>
                <textarea type="textarea" name="explikazioa" id="explikazioa" class="explikaziokaxa"></textarea>
                <br>
                <br>
                <div class="kontaktatubotoiak">
                    <input type="submit" name="bidali" value="Bidali" class="bidalibotoia">
                    <input type="reset" value="Garbitu" class="ezabatubotoia">
                </div>
            </form>
        </div>
        

        </table>

    </div>

    <footer class="footer">
        <?php require_once "footer_m.php" ?>
    </footer>

</body>
</html>