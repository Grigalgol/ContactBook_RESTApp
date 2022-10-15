async function createContact(){
    const phone = document.getElementById('phoneInput').value
    const name = document.getElementById('nameInput').value

    console.log(phoneInput)
    console.log(nameInput)

    const res = await fetch('http://localhost:8080/create', {
        method: 'POST',
        headers:{
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({phone, name})
    })
}



