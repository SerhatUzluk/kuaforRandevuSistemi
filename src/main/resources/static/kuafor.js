const xhr = new XMLHttpRequest();

function kuaforleriGetir() {
    xhr.addEventListener('readystatechange', () => {
        if (xhr.readyState === 4) {
            console.log(xhr.responseText);
        }
    })
    var url = '/api/kuaforler'
    xhr.open('GET', url);
    xhr.send();
}
