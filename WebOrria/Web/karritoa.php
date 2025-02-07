<script>
    $(document).ready(function () {
        const karritoa = [];
        const karritoaElementua = document.getElementById("karrito-elementuak");

        document.querySelector(".content").addEventListener("click", (event) => {
            if (event.target.classList.contains("gehitu-karritora")) {
                const produktuaElementua = event.target.closest(".produktua");
                const produktua = {
                    id: produktuaElementua.dataset.idproduktua,
                    izena: produktuaElementua.dataset.name,
                    prezioa: parseFloat(produktuaElementua.dataset.price)
                };

                gehituKarritora(produktua);
            }

            if (event.target.classList.contains("kendu-karritotik")) {
                const produktuaId = event.target.dataset.id;
                kenduKarritotik(produktuaId);
            }

            if (event.target.classList.contains("eskaeraGehitu")) {
                if (karritoa.length === 0) {
                    alert("Errorea: Karritoa hutsik dago!");
                    return;
                }

                $.ajax({
                    url: "eskaeraraGehitu.php",
                    type: "POST",
                    data: {
                        produktuak: JSON.stringify(karritoa)
                    },
                    success: function (response) {
                        alert(response);
                        window.location.href = "erabiltzailePanela.php";
                    },
                    error: function () {
                        alert("Errorea eskaera bidaltzean!");
                    }
                });
            }
        });

        function gehituKarritora(produktua) {
            karritoa.push(produktua);
            bistaratuKarritoa();
        }

        function kenduKarritotik(produktuaId) {
            const index = karritoa.findIndex(item => item.id === produktuaId);
            if (index !== -1) {
                karritoa.splice(index, 1);
                bistaratuKarritoa();
            }
        }

        function bistaratuKarritoa() {
            if (karritoa.length === 0) {
                karritoaElementua.innerHTML = "<p>Karritoa hutsik dago.</p>";
                return;
            }

            const karritoElementuak = karritoa.map(item => `
                <p>
                    ${item.izena} - ${item.prezioa.toFixed(2)}€ 
                    <button class="kendu-karritotik" data-id="${item.id}">Kendu</button>
                </p>
            `).join("");

            karritoaElementua.innerHTML = `
                <h3>Produktuak karritoan:</h3>
                ${karritoElementuak}
                <p><strong>Guztira: ${karritoa.reduce((guztira, item) => guztira + item.prezioa, 0).toFixed(2)}€</strong></p>
                
                <button class="eskaeraGehitu">Eskaera gehitu</button>
            `;
        }

        $(".karritoa").click(function () {
            $(".karritoa2").slideToggle(300);
        });

        $(".karritoa").click(function (event) {
            if (!$(event.target).closest(".karritoa").length) {
                $(".karritoa2").slideUp(300);
            }
        });
    });
</script>