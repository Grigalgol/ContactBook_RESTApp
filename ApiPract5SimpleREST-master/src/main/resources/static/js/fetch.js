async function getAllContacts(){
    const res = await fetch('http://localhost:8080/getAll')
    const contacts = await res.json();

    console.log(contacts)
    contacts.forEach(contact => contactsToHTML(contact))
}

window.addEventListener('DOMContentLoaded', getAllContacts)

function contactsToHTML({id, phone, name}){
    const contactsList = document.getElementById('contactsList')

    contactsList.insertAdjacentHTML('beforeend', `
    <tr id="${id}">
                <th scope="row">${id}</th>
                <td>${name}</td>
                <td>${phone}</td>
                <td>
                    <div class="btn-group" role="group" aria-label="Basic outlined example">
                        <a type="button" href="/editContact/${id}" class="btn btn-outline-secondary"><i class="bi bi-pen"></i></a>                        
                        <a type="button" onclick="deleteHTMLContact(${id})" class="btn btn-outline-secondary"><i class="bi bi-x-circle"></i></a>
                    </div>
                </td>
            </tr>
    `)
}

async function deleteHTMLContact(id){
    const rowContact = document.getElementById(id);
    rowContact.remove()

    const request = 'http://localhost:8080/delete/' + id
    const res = await fetch(request, {
        method: 'DELETE'
    })
}