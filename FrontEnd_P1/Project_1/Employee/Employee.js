const url = 'http://localhost:8080/P1-Nicholas-LeFevre/Employee/'

document.getElementById("pastRequests").addEventListener('click', pastFunc)
document.getElementById("pendingRequests").addEventListener('click', pendingFunc)
document.getElementById("sendRequests").addEventListener('click', sendFunc)
document.getElementById("logout").addEventListener('click', logoutFunc)

async function pastFunc(){
    let response = await fetch(url + "previous", {credentials: "include"});

    if (response.status === 200){
        document.getElementById("r_table").style.display = "block";
        
        console.log(response);

        let data = await response.json();

        for(let reimb of data){
            console.log(reimb);

            let theRow = document.createElement("tr");

            let cellData1 = document.createElement("td");
            cellData1.innerHTML = reimb.reimb_amount;
            theRow.appendChild(cellData1);

            let cellData2 = document.createElement("td");
            cellData2.innerHTML = reimb.reimb_submitted;
            theRow.appendChild(cellData2);

            let cellData3 = document.createElement("td");
            cellData3.innerHTML = reimb.reimb_description;
            theRow.appendChild(cellData3);

            let cellData4 = document.createElement("td");
            cellData4.innerHTML = reimb.reimb_author;
            theRow.appendChild(cellData4);

            let cellData5 = document.createElement("td");
            cellData5.innerHTML = reimb.reimb_resolver;
            theRow.appendChild(cellData5);

            if(reimb.reimb_status_id == 2){
                let cellData6 = document.createElement("td");
                cellData6.innerHTML = "Reimbursement Accepted.";
                theRow.appendChild(cellData6);
            } else{
                let cellData6 = document.createElement("td");
                cellData6.innerHTML = "Reimbursement Denied.";
                theRow.appendChild(cellData6);
            }

            let cellData7 = document.createElement("td");
            switch(reimb.reimb_type_id){
                case 1:
                    cellData7.innerHTML = "Lodging";
                    break;
                
                case 2:
                    cellData7.innerHTML = "Travel";
                    break;

                case 3: 
                    cellData7.innerHTML = "Food";
                    break;
                
                case 4: 
                    cellData7.innerHTML = "Other";
                    break;
            }
            theRow.appendChild(cellData7);

            let cellData8 = document.createElement("td");
            cellData8.innerHTML = reimb.reimb_id;
            theRow.appendChild(cellData8);
            document.getElementById("Body").appendChild(theRow);
        }
    }
}

async function pendingFunc(){
    let response = await fetch(url + "pending", {credentials: "include"});

    if(response.status === 200){
        document.getElementById("r_tablex").style.display = "block";
        console.log(response);
        let data = await response.json();

        for(let reimb of data){
            console.log(reimb);
            let theRow = document.createElement("tr");

            let cellData1 = document.createElement("td");
            cellData1.innerHTML = reimb.reimb_amount;
            theRow.appendChild(cellData1);

            let cellData2 = document.createElement("td");
            cellData2.innerHTML = reimb.reimb_submitted;
            theRow.appendChild(cellData2);

            let cellData3 = document.createElement("td");
            cellData3.innerHTML = reimb.reimb_description;
            theRow.appendChild(cellData3);

            let cellData4 = document.createElement("td");
            cellData4.innerHTML = reimb.reimb_author;
            theRow.appendChild(cellData4);

            let cellData5 = document.createElement("td");
            cellData5.innerHTML = reimb.reimb_resolver;
            theRow.appendChild(cellData5);

            let cellData6 = document.createElement("td");
            switch (reimb.reimb_type_id){
                case 1:
                    cellData6.innerHTML = "Lodging";
                    break;
                
                case 2:
                    cellData6.innerHTML= "Travel";
                    break;
                
                case 3:
                    cellData6.innerHTML = "Food";
                    break;
                
                case 4:
                    cellData6.innerHTML = "Other";
                    break;
            }
            theRow.appendChild(cellData6);
            let cellData7 = document.createElement("td");
            cellData7.innerHTML = reimb.reimb_id;
            theRow.appendChild(cellData7);
            document.getElementById("Bodyx").appendChild(theRow);
        }
    }
}

async function sendFunc(){
    let input = document.getElementById("type").value;
    let description = document.getElementById("description").value;
    let amount = document.getElementById("amount").value;

    let userInput = {
        reimb_type_id: type_id,
        reimb_description: description,
        reimb_amount: amount
    };

    let response = await fetch(url + "add", {
        method: "POST",
        body: JSON.stringify(userInput),
        credentials: "include"
    });

    if(type_id > 0 && type_id < 5){
        document.getElementById("submitMsg").style.display = "block";
    } else {
        document.getElementById("errorMsg").style.display = "block";
    }  
}
function logoutFunc(){
    window.location.replace("C:\Users\Nicholas LeFevre\Documents\GitDocs\Revature\Project_1\P1-Nicholas-LeFevre\FrontEnd_P1\Project_1\Login")
}