let ikonoak = document.querySelector(".ikonoak");
link = document.querySelectorAll("a");
title = document.querySelector(".title");
description = document.querySelector(".description");


link.forEach((el) => {
    el.addEventListener("click", () => {
        ikonoak.querySelector(".active").classList.remove("active");
        el.classList.add("active");

        let language = el.getAttribute("language");
        title.textContent = data[language].title;
        description.textContent = data[language].description;
    });
});

let data = {
    euskara: {
       description: "Euskara" 
    },
    english: {
        description: "English"
    },
}