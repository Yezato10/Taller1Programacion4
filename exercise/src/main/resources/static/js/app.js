// Variables globales
let recursos = [];

// Inicialización
document.addEventListener('DOMContentLoaded', () => {
    initForms();
    document.getElementById('resourceType').addEventListener('change', showForm);
    document.getElementById('filterType').addEventListener('change', filtrarRecursos);
    cargarRecursos();
});

// Formularios 
function initForms() {
    const formsContainer = document.getElementById('formsContainer');
    
    // Formulario Libro
    formsContainer.innerHTML += `
        <div id="libroForm" class="form-section">
            <h3>📖 Nuevo Libro</h3>
            <div class="mb-3">
                <label class="form-label">Nombre:</label>
                <input type="text" id="libroNombre" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Autor:</label>
                <input type="text" id="libroAutor" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Editorial:</label>
                <input type="text" id="libroEditorial" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Año:</label>
                <input type="number" id="libroAnio" class="form-control" required>
            </div>
            <button class="btn btn-primary" onclick="agregarLibro()">Agregar Libro</button>
        </div>
    `;
    
    // Formulario Periódico
    formsContainer.innerHTML += `
        <div id="periodicoForm" class="form-section">
            <h3>📰 Nuevo Periódico</h3>
            <div class="mb-3">
                <label class="form-label">Nombre:</label>
                <input type="text" id="periodicoNombre" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Editorial:</label>
                <input type="text" id="periodicoEditorial" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Fecha Publicación:</label>
                <input type="date" id="periodicoFecha" class="form-control" required>
            </div>
            <button class="btn btn-primary" onclick="agregarPeriodico()">Agregar Periódico</button>
        </div>
    `;
    
    // Formulario Computador
    formsContainer.innerHTML += `
        <div id="computadorForm" class="form-section">
            <h3>💻 Nuevo Computador</h3>
            <div class="mb-3">
                <label class="form-label">Nombre:</label>
                <input type="text" id="computadorNombre" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Marca:</label>
                <input type="text" id="computadorMarca" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Modelo:</label>
                <input type="text" id="computadorModelo" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Sistema Operativo:</label>
                <input type="text" id="computadorSO" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Tipo:</label>
                <select id="computadorTipo" class="form-select">
                    <option value="PORTATIL">Portátil</option>
                    <option value="ESCRITORIO">Escritorio</option>
                    <option value="TABLET">Tablet</option>
                </select>
            </div>
            <button class="btn btn-primary" onclick="agregarComputador()">Agregar Computador</button>
        </div>
    `;
    
    // Mostrar primer formulario por defecto
    showForm();
}

function showForm() {
    document.querySelectorAll('.form-section').forEach(form => {
        form.classList.remove('active-form');
    });
    const selectedType = document.getElementById('resourceType').value;
    document.getElementById(`${selectedType}Form`).classList.add('active-form');
}

// Cargar recursos
async function cargarRecursos() {
    try {
        const response = await fetch('/api/recursos');
        if (!response.ok) throw new Error('Error al cargar recursos');
        recursos = await response.json();
        mostrarRecursos(recursos);
    } catch (error) {
        console.error('Error:', error);
        alert('Error al cargar los recursos');
    }
}

// Mostrar recursos en tabla
function mostrarRecursos(listaRecursos) {
    const tbody = document.querySelector('#resourcesTable');
    tbody.innerHTML = '';
    
    listaRecursos.forEach(recurso => {
        const tipo = recurso.autor ? 'libro' : recurso.marca ? 'computador' : 'periodico';
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${recurso.id}</td>
            <td>${getIcon(recurso)} ${getTypeName(recurso)}</td>
            <td>${recurso.nombre || 'Sin nombre'}</td>
            <td>${getDetails(recurso)}</td>
            <td><button class="btn btn-sm btn-danger" onclick="eliminarRecurso(${recurso.id}, '${tipo}')">🗑️ Eliminar</button></td>
        `;
        tbody.appendChild(row);
    });
}

// Filtrar recursos
function filtrarRecursos() {
    const tipo = document.getElementById('filterType').value;
    
    if (tipo === 'todos') {
        mostrarRecursos(recursos);
    } else {
        const filtrados = recursos.filter(recurso => {
            if (tipo === 'libro') return recurso.autor;
            if (tipo === 'periodico') return recurso.fechaPublicacion;
            if (tipo === 'computador') return recurso.marca;
            return false;
        });
        mostrarRecursos(filtrados);
    }
}

// Funciones auxiliares
function getIcon(recurso) {
    if (recurso.autor) return '📖';
    if (recurso.marca) return '💻';
    if (recurso.fechaPublicacion) return '📰';
    return '📄';
}

function getTypeName(recurso) {
    if (recurso.autor) return 'Libro';
    if (recurso.marca) return 'Computador';
    if (recurso.fechaPublicacion) return 'Periódico';
    return 'Recurso';
}

function getDetails(recurso) {
    let details = '';
    if (recurso.autor) {
        details += `<div class="detail-item"><strong>Autor:</strong> ${recurso.autor}</div>`;
        details += `<div class="detail-item"><strong>Editorial:</strong> ${recurso.editorial}</div>`;
        details += `<div class="detail-item"><strong>Año:</strong> ${recurso.anio}</div>`;
    }
    if (recurso.marca) {
        details += `<div class="detail-item"><strong>Marca:</strong> ${recurso.marca}</div>`;
        details += `<div class="detail-item"><strong>Modelo:</strong> ${recurso.modelo}</div>`;
        details += `<div class="detail-item"><strong>SO:</strong> ${recurso.sistemaOperativo}</div>`;
        details += `<div class="detail-item"><strong>Tipo:</strong> ${recurso.tipo}</div>`;
    }
    if (recurso.fechaPublicacion) {
        details += `<div class="detail-item"><strong>Editorial:</strong> ${recurso.editorial}</div>`;
        details += `<div class="detail-item"><strong>Fecha:</strong> ${formatDate(recurso.fechaPublicacion)}</div>`;
    }
    return details || 'Sin detalles';
}

function formatDate(dateString) {
    if (!dateString) return 'No definida';
    const date = new Date(dateString);
    return date.toLocaleDateString();
}

// Funciones para agregar recursos
async function agregarLibro() {
    const libro = {
        nombre: document.getElementById('libroNombre').value,
        autor: document.getElementById('libroAutor').value,
        editorial: document.getElementById('libroEditorial').value,
        anio: parseInt(document.getElementById('libroAnio').value),
        activo: true
    };
    
    try {
        const response = await fetch('/api/recursos/libros', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(libro)
        });
        
        if (!response.ok) throw new Error('Error al agregar libro');
        
        limpiarFormulario('libro');
        await cargarRecursos();
        alert('Libro agregado con éxito!');
    } catch (error) {
        console.error('Error:', error);
        alert('Error al agregar el libro');
    }
}

async function agregarPeriodico() {
    const periodico = {
        nombre: document.getElementById('periodicoNombre').value,
        editorial: document.getElementById('periodicoEditorial').value,
        fechaPublicacion: document.getElementById('periodicoFecha').value,
        activo: true
    };
    
    try {
        const response = await fetch('/api/recursos/periodicos', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(periodico)
        });
        
        if (!response.ok) throw new Error('Error al agregar periódico');
        
        limpiarFormulario('periodico');
        await cargarRecursos();
        alert('Periódico agregado con éxito!');
    } catch (error) {
        console.error('Error:', error);
        alert('Error al agregar el periódico');
    }
}

async function agregarComputador() {
    const computador = {
        nombre: document.getElementById('computadorNombre').value,
        marca: document.getElementById('computadorMarca').value,
        modelo: document.getElementById('computadorModelo').value,
        sistemaOperativo: document.getElementById('computadorSO').value,
        tipo: document.getElementById('computadorTipo').value,
        activo: true
    };
    
    try {
        const response = await fetch('/api/recursos/computadores', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(computador)
        });
        
        if (!response.ok) throw new Error('Error al agregar computador');
        
        limpiarFormulario('computador');
        await cargarRecursos();
        alert('Computador agregado con éxito!');
    } catch (error) {
        console.error('Error:', error);
        alert('Error al agregar el computador');
    }
}

function limpiarFormulario(tipo) {
    if (tipo === 'libro') {
        document.getElementById('libroNombre').value = '';
        document.getElementById('libroAutor').value = '';
        document.getElementById('libroEditorial').value = '';
        document.getElementById('libroAnio').value = '';
    } else if (tipo === 'periodico') {
        document.getElementById('periodicoNombre').value = '';
        document.getElementById('periodicoEditorial').value = '';
        document.getElementById('periodicoFecha').value = '';
    } else if (tipo === 'computador') {
        document.getElementById('computadorNombre').value = '';
        document.getElementById('computadorMarca').value = '';
        document.getElementById('computadorModelo').value = '';
        document.getElementById('computadorSO').value = '';
    }
}

// Eliminar recurso
async function eliminarRecurso(id, tipo) {
    if (!confirm('¿Estás seguro de eliminar este recurso?')) return;
    
    try {
        const endpoint = `/api/recursos/${id}?tipo=${tipo}`;
        const response = await fetch(endpoint, { 
            method: 'DELETE' 
        });
        
        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(errorData.message || 'Error al eliminar recurso');
        }
        
        await cargarRecursos();
        alert('Recurso eliminado con éxito!');
    } catch (error) {
        console.error('Error al eliminar:', error);
        alert('Error al eliminar el recurso: ' + error.message);
    }
}