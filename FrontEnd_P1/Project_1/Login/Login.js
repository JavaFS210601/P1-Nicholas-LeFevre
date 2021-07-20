const url = 'http://localhost:8080/P1-Nicholas-LeFevre/'

document.getElementById("submit").addEventListener('click', loginFunc)

async function loginFunc(){

    let usern = document.getElementById("uname").value
    let userp = document.getElementById("psw").value

    let user = {
        username:usern,
        password:userp
    };

    console.log(user)

    let response = await fetch(url + "login", {

        method: "POST",
        body: JSON.stringify(user),
        credentials: "include"

    });

    console.log(response.status)

    if(response.status === 200){
        document.getElementById("login-row").innerText="Welcome!"
    }else {
        document.getElementById("login-row").innerText="Login Failed! Refresh the page!"
    }
}