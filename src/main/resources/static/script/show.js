const URLParams = new URLSearchParams(window.location.search);
const photoId = URLParams.get('id');

showPhoto(photoId);

function showPhoto(photoId) {
    axios
        .get("http://localhost:8080/api/photos/" + photoId)
        .then((response) => {
            console.log('richiesta ok', response);
            const photo = response.data;
            document.querySelector('#show_photo').innerHTML = `
            
            <h1>Dettaglio Foto</h1>
            <div class="row">
                <div class="col-4">
                    <h3>${photo.title}</h3>
                    <img alt="${photo.title}" width="150" height="150" src="${photo.url}">
                    <p>${photo.description}</p>
                </div>
                <div class="col-3"> 
                    <h3>Tag</h3>
                    <p>${photo.tag}</p>
                </div>
                <div class="col-3" id="show_comments"> 
                    <h3>Commenti</h3>
                </div>
            </div>
            
            `
            
            photo.comments.forEach((comment) => {
				document.querySelector('#show_comments').innerHTML += `
				
				<h6 class="fw-bold">${comment.name}</h6>
                <p>${comment.text}</p>
				
				`
			})
            
        })
        .catch((response) => {
            console.error('Errore chiamata', response);
        })
}


 function addComment() {
     const comment = {
         name: document.querySelector('#name').value,
         text: document.querySelector('#text').value
     }

     axios
     	.post(`http://localhost:8080/api/photos/${photoId}/comment`, comment)
     	.then((response) => {
         console.log("commento ok")
         location.href = `/my-photos/show?id=${photoId}`
     }).catch((response) => {
         console.log("errore commento")
     })
 }