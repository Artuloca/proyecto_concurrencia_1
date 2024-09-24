import React from 'react';

function PagAdmin() {
    const handleCreateUser = async () => {
        const newUser = {
            nombre: 'nuevoUsuario',
            contraseña: 'password123',
            esAdmin: false
        };
        await fetch('/api/users/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(newUser),
        });
    };

    const handleDeleteUser = async (id) => {
        await fetch(`/api/users/delete/${id}`, {
            method: 'DELETE',
        });
    };

    return (
        <div>
            <h1>Admin Screen</h1>
            <button onClick={handleCreateUser}>Crear Usuario</button>
            <button onClick={() => handleDeleteUser(1)}>Borrar Usuario</button>
        </div>
    );
}

export default PagAdmin;