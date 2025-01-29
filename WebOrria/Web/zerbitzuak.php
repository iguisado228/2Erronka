<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href="css_m.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <title>Zerbitzuak</title>
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
            </div>
        <div class="eskainitakoZerbitzuak">
            <table class="garraioZerbitzua">
                <tr>
                    <th>Garraio zerbitzua</th>
                </tr>
                <tr>
                    <td>Garraio zerbitzua eskaintzen dugu pertsonen edo salgaien mugikortasuna errazteko modu eraginkor,
                        azkar eta seguruan. Bezeroen beharrak asetzeko, hainbat garraio aukera eskaintzen ditugu, hala
                        nola, puntualtasuna, erosotasuna eta fidagarritasuna bermatuz. Helburua da erabiltzaileen
                        eguneroko bizitza erraztea eta logistika beharrei erantzutea, lehiakortasuna eta gogobetetasuna
                        hobetuz. <br><img class="garraioZerbitzuaImg"
                            src="../irudiak/garraioZerbitzua.png">
                    </td>
                </tr>
            </table>
            


            <table class="bezeroarenArreta">

                <tr>
                    <th>Bezeroaren arreta</th>
                </tr>
                <tr>
                    <td>Bezeroaren arreta eskaintzen dugu bezeroei laguntza, informazioa eta konponbideak emateko, haien
                        beharrak eta arazoak modu azkar eta eraginkorrean kudeatuz. Helburua da bezeroaren
                        gogobetetasuna
                        bermatzea, konfiantza sortzea eta esperientzia positiboa eskaintzea, gure zerbitzuaren kalitatea
                        eta
                        fidagarritasuna indartuz.<br><img class="bezeroarenArretaImg"
                            src="../irudiak/bezeroarenArreta.png">
                    </td>
                </tr>
            </table>

            <table class="paketearenJarraipena">

                <tr>
                    <th>Paketearen jarraipena</th>
                </tr>

                <tr>
                    <td>Paketearen jarraipen zerbitzua eskaintzen dugu bezeroek haien bidalketen egoera eta kokapena
                        uneoro
                        ezagutu ahal izateko. Helburua da gardentasuna, segurtasuna eta lasaitasuna bermatzea,
                        bidalketen
                        kontrol osoa eta entrega puntualaren konfiantza eskainiz.<br><img
                            class="paketearenJarraipenaImg"
                            src="https://img.freepik.com/vector-premium/smartphone-aplicacion-seguimiento-rastreo-paquete-abierto_107173-9206.jpg">
                    </td>
                </tr>
            </table>

        </div>


    </div>
    <?php
    require_once("karritoa.php")
    ?>

    <footer class="footer">
        <?php require_once "footer_m.php" ?>
    </footer>


</body>

</html>