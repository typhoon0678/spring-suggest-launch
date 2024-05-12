const deleteButton = document.getElementById('delete-btn');

const modifyButton = document.getElementById('modify-btn');

const createButton = document.getElementById('create-btn');

if (deleteButton) {
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById('restaurant-id').value;
        fetch(`/api/restaurants/${id}`, {
            method: 'DELETE',
        })
            .then(() => {
                alert('삭제되었습니다.')
                location.replace('/restaurants');
            });
    });
} else if (modifyButton) {
    modifyButton.addEventListener('click', event => {
        let params = new URLSearchParams(location.search);
        let id = params.get('id');

        fetch(`/api/restaurants/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                name: document.getElementById('restaurant-name').value,
                lat: document.getElementById('restaurant-lat').value,
                lon: document.getElementById('restaurant-lon').value,
                categoryId: document.getElementById('restaurant-categoryId').value,
            })
        })
            .then(() => {
                alert('수정되었습니다.');
                location.replace(`/restaurants/${id}`);
            });
    });
} else if (createButton) {
    createButton.addEventListener('click', event => {
        fetch('/api/restaurants', {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                name: document.getElementById('restaurant-name').value,
                lat: document.getElementById('restaurant-lat').value,
                lon: document.getElementById('restaurant-lon').value,
                categoryId: document.getElementById('restaurant-categoryId').value,
            })
        })
            .then(() => {
                alert('등록되었습니다.');
                location.replace('/restaurants');
            });
    });
}