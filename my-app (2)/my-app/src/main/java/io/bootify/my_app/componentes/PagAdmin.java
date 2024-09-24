package io.bootify.my_app.componentes;

import React from 'react';

function PagAdmin() {
    const handleCreateUser = () => {
        // Lógica para crear usuario
    };

    const handleDeleteUser = () => {
        // Lógica para borrar usuario
    };

    return (
            <div>
            <h1>Admin Screen</h1>
            <button onClick={handleCreateUser}>Crear Usuario</button>
            <button onClick={handleDeleteUser}>Borrar Usuario</button>
        </div>
    );
}

export default AdminScreen;
