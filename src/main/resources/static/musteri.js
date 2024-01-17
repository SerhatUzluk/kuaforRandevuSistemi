
    const btnOn=document.querySelector(".btnOn");
    function onayla(){
        alert("çalıştı")
    var tarih=document.getElementById("tarihsaatdakika").value;
    var kuafor=document.getElementById("kuafor").value;
}

    //-------------------------------------------------
    document.addEventListener("DOMContentLoaded", function() {
    // Tüm kuaförleri getir ve dropdown'u doldur
    kuaforleriGetir();
    });

    function kuaforleriGetir() {
    fetch('/api/kuaforler', {
        method: 'GET',
    })
        .then(response => response.json())
        .then(data => {
            // Dropdown menüsüne kuaförleri ekle
            kuaforleriDropdownaEkle(data);
        })
        .catch(error => console.error('Hata:', error));
    }

    function kuaforleriDropdownaEkle(kuaforListesi) {
    var selectElement = document.getElementById("kuafor");

    kuaforListesi.forEach(function(kuafor) {
    var option = document.createElement("option");
    option.value = kuafor.id;
    option.text = kuafor.ad + ' ' + kuafor.soyad;
    selectElement.appendChild(option);
});
}
    document.querySelector('#postData').addEventListener('click', MusteriOlustur)
    document.querySelector('#postDataForLogin').addEventListener('click', MusteriGirisi)
    function MusteriOlustur() {
        const data = {

            "ad":document.getElementById('exampleInputAd').value,
            "soyad":document.getElementById('exampleInputSoyad').value,
            "mailAdres":document.getElementById('exampleInputEmail1').value,
            "telefonNo":document.getElementById('exampleInputtel1').value,
            "sifre":document.getElementById('exampleInputPassword1').value
        }

        var json = JSON.stringify(data);
        var url = "/api/musteriler/kayit";
        var xhr = new XMLHttpRequest();
        xhr.open('POST', url, true);
        xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');

        xhr.onload = function (){
            if (xhr.status === 201 && xhr.readyState ===4){
                var post = xhr.responseText;
                console.log(post);
                alert('Kayıt başarılı.')
                window.location.href = 'http://localhost:8080/';

            }else{
                alert('Bu e-posta kullanılmaktadır.')
            }
        }
        xhr.send(json);
    }

    function MusteriGirisi(){
        const data = {
            mailAdres:"ozan@gmail.com",
            sifre:"ozan1"
        }

        var json1 = JSON.stringify(data);
        var url1 = "/api/musteriler/giris";
        var xhr1 = new XMLHttpRequest();
        xhr1.open('POST', url1, true);
        xhr1.setRequestHeader('Content-type', 'application/json; charset=utf-8');

        xhr1.onload = function (){
            if (xhr1.status === 200 && xhr1.readyState ===4){
                var post = xhr1.responseText;
                console.log(post);
                alert('Giriş başarılı.')
                window.location.href = 'http://localhost:8080/MusteriEkrani.html';

            }else{
                alert('Bu e-posta kullanılmamaktadır.')
                alert(json1)
            }
        }
        xhr1.send(json1);
    }
