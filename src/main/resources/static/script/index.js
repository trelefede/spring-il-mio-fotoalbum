/**
 * 
 */

 photoList();

function photoList() {
    axios
        .get("http://localhost:8080/api/photos")
        .then((response) => {
            console.log("richiesta ok", response);
            response.data.forEach(photo => {
                document.querySelector('#photo_table').innerHTML += `

                <tr>
                    <td>${photo.title}</td>
                    <td>${photo.description}</td>
                    <td><img class="img-thumbnail" width="150" height="150" src="${photo.url}"></img></td>
                    <td>${photo.tag}</td>
                    
                    <td><a class="btn btn-primary" href="./my-photos/show?id=${photo.id}"><i class="fa-solid fa-magnifying-glass"></i></a></td>
                </tr>
                
                `
            });
        })
        .catch((response) => {
            console.error('Errore chiamata', response);
        })
}