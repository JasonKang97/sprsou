let currentMode = 'add';
let currentTodoId = null;

// 모달 열기
const openFormModal = (mode, id = null) => {
    currentMode = mode;
    currentTodoId = id;
    
    const modal = document.getElementById('formModal');
    modal.style.display = 'block';
    
    document.getElementById('modalTitle').textContent = 
        mode === 'add' ? '할 일 추가' : '할 일 수정';
    
    document.getElementById('submitBtn').textContent = 
        mode === 'add' ? '등록' : '수정 완료';
    
    if(mode === 'edit') {
        fetch(`/todo/${id}`)
            .then(res => res.json())
            .then(data => {
                document.getElementById('id').value = data.id;
                document.getElementById('title').value = data.title;
                document.getElementById('order').value = data.order;
                document.getElementById('completed').checked = data.completed;
            });
    } else {
        document.getElementById('todoForm').reset();
    }
};

// 폼 제출
const submitForm = () => {
    const url = currentMode === 'add' ? '/todo' : `/todo/${currentTodoId}`;
    const method = currentMode === 'add' ? 'POST' : 'PATCH';

    const data = {
        title: document.getElementById('title').value,
        order: parseInt(document.getElementById('order').value),
        completed: document.getElementById('completed').checked
    };

    fetch(url, {
        method: method,
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(() => {
        closeFormModal();
        loadTodos();
    });
};

// 할 일 목록 로드
const loadTodos = () => {
    fetch('/todo')
        .then(res => res.json())
        .then(data => {
            const tbody = document.getElementById('tableBody');
            tbody.innerHTML = data.map(todo => `
                <tr>
                    <td>${todo.title}</td>
                    <td>${todo.order}</td>
                    <td><input type="checkbox" ${todo.completed ? 'checked' : ''} disabled></td>
                    <td><button onclick="openFormModal('edit', ${todo.id})">수정</button></td>
                    <td><button onclick="openDeleteModal(${todo.id})">삭제</button></td>
                </tr>
            `).join('');
        });
};

// 삭제 모달 처리
let deleteId = null;
const openDeleteModal = (id) => {
    deleteId = id;
    document.getElementById('deleteModal').style.display = 'block';
};

document.getElementById('confirmDelete').addEventListener('click', () => {
    fetch(`/todo/${deleteId}`, { method: 'DELETE' })
        .then(() => {
            document.getElementById('deleteModal').style.display = 'none';
            loadTodos();
        });
});

document.getElementById('cancelDelete').addEventListener('click', () => {
    document.getElementById('deleteModal').style.display = 'none';
});

// 모달 닫기 공통 함수
const closeFormModal = () => {
    document.getElementById('formModal').style.display = 'none';
};

// 초기 로드
document.addEventListener('DOMContentLoaded', () => {
    loadTodos();
    
    // 모달 외부 클릭 닫기
    window.addEventListener('click', (event) => {
        const modals = document.querySelectorAll('.modal');
        modals.forEach(modal => {
            if(event.target === modal) {
                modal.style.display = 'none';
            }
        });
    });
});