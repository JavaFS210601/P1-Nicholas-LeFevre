const url = 'http://localhost:8080/P1-Nicholas-LeFevre/Employee/'

document.getElementById("pastRequests").addEventListener('click', pastFunc)
document.getElementById("pendingRequests").addEventListener('click', pendingFunc)
document.getElementById("sendRequests").addEventListener('click', sendFunc)
document.getElementById("logout").addEventListener('click', logoutFunc)

async function pastFunc(){

    let response = await fetch(url+"past", {credentials: 'include'})
  
    if(response.status===200){
      document.getElementById("r_table").style.display = "block"
      console.log(response)
      let data = await response.json()
  
        console.log(reimbursement)

        let row = document.createElement("tr")
  
        let cell = document.createElement("td")
        cell.innerHTML = reimb.amount 
        row.appendChild(cell)
  
        let cell2 = document.createElement("td")
        cell2.innerHTML = reimb.Submitted
        row.appendChild(cell2)

        let cell3 = document.createElement("td")
        cell3.innerHTML = reimb.resolved
        row.appendChild(cell3)

        let cell4 = document.createElement("td")
        cell4.innerHTML = reimb.description
        row.appendChild(cell4)
  
        let cell5 = document.createElement("td")
        cell5.innerHTML = reimb.author
        row.appendChild(cell5)

        let cell6 = document.createElement("td")
        cell5.innerHTML = reimb.resolver
        row.appendChild(cell6)
  
        if(reimbursement.statusId == 2){
            let cell7 = document.createElement("td")
            cell7.innerHTML = "Accepted"
            row.appendChild(cell7)
        } else {
            let cell7 = document.createElement("td")
            cell7.innerHTML = "Rejected"
            row.appendChild(cell7)
        }

        let cell8 = document.createElement("td")
        switch(reimbursement.typeId){
        case 1:
            cell8.innerHTML = "LODGING"
            break
        case 2:
            cell8.innerHTML = "TRAVEL"
            break
        case 3:
            cell8.innerHTML = "FOOD"
            break
        case 4:
            cell8.innerHTML = "OTHER"
            break
        }
        row.appendChild(cell8)

        let cell9 = document.createElement("td")
        cell9.innerHTML = reimbursement.reimbursementId
        row.appendChild(cell9)
  
        document.getElementById("Body").appendChild(row)

        }
    }

async function pendingFunc(){
    
}

async function sendFunc(){

    let inputTypeId = document.getElementById("type").value;
    let inputDescription = document.getElementById("description").value;
    let inputAmount = document.getElementById("amount").value;

    let user = {
        typeId:inputTypeId,
        description:inputDescription,
        amount:inputAmount
    };

    let response = await fetch(url+"add", { 
        method:"POST", 
        body: JSON.stringify(userInput),
        credentials: "include"
        });

    if(inputTypeId > 0 && inputTypeId < 5){
        document.getElementById("hiddenMessage").style.display = "block";
    } else document.getElementById("failureMessage").style.display = "block";

}

function logoutFunc(){
    window.location.replace("Employee.html")
}
