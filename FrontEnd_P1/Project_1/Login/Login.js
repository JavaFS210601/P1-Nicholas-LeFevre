const url = 'http://localhost:8080/P1-Nicholas-LeFevre/'

document.getElementById("loginbtn").addEventListener('click', loginFunc)

async function loginFunc(){

    let ers_username = document.getElementById("username").value
    let ers_password = document.getElementById("password").value

    let user = {
        user_name: ers_username,
        user_password: ers_password
    };

    console.log(user)

    let response = await fetch(url + "login", {

        method: "POST",
        body: JSON.stringify(user),
        credentials: "include"

    });

    console.log(response.status)

    if(response.status === 200){
        document.getElementById("loginDiv").innerText="Welcome!"

        let user = await response.json();

        if(user.user_role_id === 2){
            window.location.href = "employee.html";
        } else if(user.user_role_id === 1){
            window.location.href = "manager.html";
        }

    }else {
        document.getElementById("errorMsg").innerText="Login Failed! Refresh the page!"
    }
}