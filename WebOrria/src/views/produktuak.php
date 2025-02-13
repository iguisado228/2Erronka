<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../../public/css/css.css">
    <title>Produktuak</title>
    <style>
        form {
            display: flex;
            flex-wrap: wrap;
            gap: 10px;
            align-items: center;
            justify-content: center;
            margin-bottom: 20px;
            background: #f8f8f8;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1);
        }

        form input {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        form button {
            background: #007bff;
            color: white;
            border: none;
            padding: 8px 15px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background 0.3s;
        }

        form button:hover {
            background: #0056b3;
        }



        @media (max-width: 768px) {
            form {
                flex-direction: column;
                gap: 5px;
            }

            form input,
            form button {
                width: 100%;
                max-width: 300px;
            }

            .produktuak {
                grid-template-columns: repeat(auto-fit, minmax(150px, 1fr));
            }
        }
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
                ?>
                <form id="produktuFiltroa">
                    <label for="produktuaBilatu">Bilatu produktua:</label>
                    <input type="text" name="produktuaBilatu" id="produktuaBilatu">

                    <label for="gutxienekoPrezioa">Prezio minimoa:</label>
                    <input type="number" name="gutxienekoPrezioa" id="gutxienekoPrezioa" min="0">

                    <label for="gehienezkoPrezioa">Prezio maximoa:</label>
                    <input type="number" name="gehienezkoPrezioa" id="gehienezkoPrezioa" min="0">

                    <button type="submit">Filtratu</button>
                </form>

                <div id="produktuak"></div>

                <?php
                if ($result->num_rows > 0) {
                    echo "<h1 class='produktuGuztiak'>Produktu guztiak</h1>";
                    echo "<div class='produktuak'>";
                    while ($row = $result->fetch_assoc()) {
                        echo "<div class='produktua' data-idProduktua='" . $row["idProduktua"] . "' data-name='" . $row["izena"] . "' data-price='" . $row["prezioa"] . "'>";
                        echo "<h2 class='produktuIzena'>" . $row["izena"] . "</h2>";
                        echo "<p class='produktuPrezioa'>" . trans("prezioa") . $row["prezioa"] . "€</p>";
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