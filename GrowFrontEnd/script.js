async function addToDo() {
    const title = document.getElementById('todo-input').value;
   let resp= await fetch('http://localhost:8888/todos/create', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({title})
    });
   // console.log(resp);
    loadToDos();
}



async function loadToDos() {
    try {
        const response = await fetch('http://localhost:8888/todos/get');
        const todos = await response.json();

        // Render todos in the list
        let list = document.getElementById('todo-list');
        list.innerHTML = "";

        todos.forEach(todo => {
            list.innerHTML += `
            <tr class="${todo.status ? 'comp': 'in'}">
                <td>${todo.title}</td>
                <td>
                    <input type="checkbox" onclick="markAsComplete(${todo.id})" id="${todo.id}" ${todo.status ? 'checked' : ''}  /> ${todo.status ? "Completed" : "Mark as Completed"}
                </td>
            </tr>
            `;
        });
    } catch (error) {
        console.error('Error loading todos:', error);
    }
}



async function markAsComplete(id) {

    const checkbox = document.getElementById(id);

    
    const newStatus = checkbox.checked;

  
    await fetch(`http://localhost:8888/todos/update/${id}?status=${newStatus}`, { method: 'PUT' });

    // Reloading
    loadToDos();
}


function renderToDos(todos) {
    const list = document.getElementById('todo-list');
    list.innerHTML = ''; 
    todos.forEach(todo => {
      list.innerHTML+=`<tr>
    <td>${todo.description}</td>
    <td>${todo.id}</td>
    <div>Spec</div>
    </tr>`
    });
}

loadToDos()