const form = document.querySelector('form');

form.addEventListener('submit', function(event){
let email = document.getElementById('email');
let confirmEmail = document.getElementById('confirmEmail');

if(confirmEmail.value !== email.value) {
    alert('Email\'s Don\'t Match');
    event.preventDefault();
};

});