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

                <tr class="photo">
                    <td class="photo-title">${photo.title}</td>
                    <td>${photo.description}</td>
                    <td><img class="img-thumbnail" width="150" height="150" src="${photo.url}"></img></td>
                    <td class="photo-tag">${photo.tag}</td>
                    
                    <td><a class="btn btn-primary" href="./my-photos/show?id=${photo.id}"><i class="fa-solid fa-magnifying-glass"></i></a></td>
                </tr>
                
                `
            });
        })
        .catch((response) => {
            console.error('Errore chiamata', response);
        })
}

function search() {
	const search = document.querySelector('#search');
	const value = search.value.toLowerCase();
	console.log(value);
	const photos = document.querySelectorAll('.photo');
	photos.forEach((photo) => {
		console.log(photo);
		const name = photo.querySelector('.photo-title').textContent.toLowerCase();
		const tag = photo.querySelector('.photo-tag').textContent.toLowerCase();
		console.log(name);
		if(name.includes(value) || tag.includes(value)){
			photo.classList.remove('d-none');
		} else {
			photo.classList.add('d-none');
		}
	})
}