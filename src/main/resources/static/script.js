const sigIn=document.getElementById("signIn");
function giris(){
    window.location.href="Giris.html"
}

function toggleForm() {
    var loginForm = document.getElementById('login-form');
    var registrationForm = document.getElementById('registration-form');

    loginForm.style.display = loginForm.style.display === 'none' ? 'block' : 'none';
    registrationForm.style.display = registrationForm.style.display === 'none' ? 'block' : 'none';
};


