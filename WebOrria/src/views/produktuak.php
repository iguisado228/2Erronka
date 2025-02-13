<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../../public/css/css.css">
    <title>Produktuak</title>
</head>

<body class="produktuenAtala">
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
                ?>
                <form id="produktuFiltroa">
                    <label for="produktuaBilatu"> <?= trans("produktuakBilatu") ?></label>
                    <input type="text" name="produktuaBilatu" id="produktuaBilatu">

                    <label for="gutxienekoPrezioa"><?= trans(indexPhrase: "prezioMinimoa") ?></label>
                    <input type="number" name="gutxienekoPrezioa" id="gutxienekoPrezioa" min="0">

                    <label for="gehienezkoPrezioa"><?= trans("prezioMaximoa") ?></label>
                    <input type="number" name="gehienezkoPrezioa" id="gehienezkoPrezioa" min="0">

                    <button type="submit"><?= trans("filtratu") ?></button>
                </form>

                <div id="produktuak"></div>

                <?php
                if ($result->num_rows > 0) {
                    echo "<h1 class='produktuGuztiak'>" . trans('produktuGuztiak') . "</h1>";
                    echo "<div class='produktuak'>";
                    while ($row = $result->fetch_assoc()) {
                        echo "<div class='produktua' data-idProduktua='" . $row["idProduktua"] . "' data-name='" . $row["izena"] . "' data-price='" . $row["prezioa"] . "'>";
                        echo "<h2 class='produktuIzena'>" . $row["izena"] . "</h2>";
                        echo "<p class='produktuPrezioa'>" . trans("prezioa") . $row["prezioa"] . "€</p>";
                        echo "<div class='argazkia'>";
                        echo "<img src='../../public/irudiak/produktuak/" . $row["irudia"] . "' >";
                        echo "</div>";
                        echo "<div class='gehituBotoia'>";
                        echo "<button class='gehitu-karritora'>" . trans('gehituZestora') . "</button>";
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

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
   $(document).ready(function () {
    function produktuakFiltratu() {
        let formData = $("#produktuFiltroa").serialize();  

        if (!formData.includes("produktuaBilatu") && !formData.includes("gutxienekoPrezioa") && !formData.includes("gehienezkoPrezioa")) {
            $(".filtratutakoProduktuak").hide(); 
            $("#produktuak").html("");
            return;
        }

        $.ajax({
            url: 'filtratu.php',
            method: 'GET',
            data: formData,
            success: function (response) {
                if (response.includes("Ez da produkturik aurkitu")) {
                    $("#produktuak").html(response);  
                    $(".filtratutakoProduktuak").hide();  
                } else {
                    $("#produktuak").html(response);  
                    $(".filtratutakoProduktuak").show();  
                }
            },
        });
    }

    $("#produktuFiltroa").on("submit", function (event) {
        event.preventDefault();  
        produktuakFiltratu();  
    });

    $("#produktuaBilatu, #gutxienekoPrezioa, #gehienezkoPrezioa").on("input", function () {
        produktuakFiltratu(); 
    });
});


    </script>


</body>

</html>