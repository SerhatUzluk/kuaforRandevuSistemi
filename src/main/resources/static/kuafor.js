const xhr = new XMLHttpRequest();

function kuaforleriGetir() {
    xhr.addEventListener('readystatechange', () => {
        if (xhr.readyState === 4) {
            //json türünde gget edilen kuaför bilgileri diziye dönüştürlerek option'lara eklenecek.
            var kuaforListesiSelect = document.getElementById("KuaforListesi");
            var kuaforBilgileri = xhr.responseText;

                var option = document.createElement("option");
                option.value = kuafor.id;
                option.text = kuafor.ad + " " + kuafor.soyad;

                kuaforListesiSelect.appendChild(option);
        }
    })
    var url = '/api/kuaforler'
    xhr.open('GET', url);
    xhr.send();
}

window.addEventListener("load", kuaforleriGetir)