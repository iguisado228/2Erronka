<head>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<div class ="ikonoak">
    <img class="ikurriña" src="../irudiak/ikurriña.png" alt="ikurriña" />

<div class="menu-container">
        <div class="menu-icon">
            <i class="fa fa-bars" aria-hidden="true"></i>
        </div>
        <div class="menu">
            <ul>
                <li><a href="index_m.php">Hasiera</a></li>
                <li><a href="produktuak.php">Produktuak</a></li>
                <li><a href="kontaktua.php">Kontaktua</a></li>
                <li><a href="zerbitzuak.php">Zerbitzuak</a></li>
            </ul>
        </div>
    </div>
    <i class="fa fa-user-circle-o" id="ikonoa" aria-hidden="true"></i>
    <a href="karritoa.php"><i class="fa fa-shopping-cart" id="ikonoa" aria-hidden="true"></i>

</div>
</div>
<script src="https://code.jquery.com/jquery-3.7.1.js"> </script>
<script>
        $(document).ready(function() {
            $(".menu-icon").click(function() {
                $(".menu").slideToggle(300);
            });
 
            // Cerrar menú al hacer clic fuera
            $(document).click(function(event) {
                if (!$(event.target).closest(".menu-container").length) {
                    $(".menu").slideUp(300);
                }
            });
        });
    </script>