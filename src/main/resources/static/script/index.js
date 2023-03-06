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
				if(photo.visible){
					console.log(photo.visible);
					document.querySelector('#photo_table').innerHTML += `

						<div class="col-3">
							<div class="card">
							  <img alt="${photo.title}" src="${photo.url}">
							  <div class="card-body">
							  	<p>Tag: <span>${photo.tag}</span></p>
							    <h5 class="card-title">${photo.title}</h5>
							    <p class="card-text">${photo.description}</p>
							    <a class="btn btn-primary" href="./my-photos/show?id=${photo.id}"><i class="fa-solid fa-magnifying-glass"></i></a>
							  </div>
							</div>
						</div>
		                
		            `
				} 
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