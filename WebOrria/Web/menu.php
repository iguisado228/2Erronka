<div class ="ikonoak">
    <img class="ikurriña" src="../irudiak/ikurriña.png" alt="ikurriña" />

<div class="menu-container">
        <div class="menu-icon">
            <i class="fa fa-bars" aria-hidden="true"></i>
        </div>
        <div class="menu">
            <ul>
                <li>Inicio</li>
                <li>Servicios</li>
                <li>Acerca de</li>
                <li>Contacto</li>
            </ul>
        </div>
    </div>
    <i class="fa fa-user-circle-o" id="ikonoa" aria-hidden="true"></i>
    <i class="fa fa-shopping-cart" id="ikonoa" aria-hidden="true"></i>

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