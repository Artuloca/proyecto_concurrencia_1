package io.bootify.my_app.componentes;

import React, { useState } from 'react';

function LoginScreen({ onLogin }) {
        const [nombreUsuario, setNombreUsuario] = useState('');
    const [contraseña, setContraseña] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
// Aquí deberías hacer la llamada a tu servicio de autenticación
        const response = await fetch('/api/authenticate', {
    method: 'POST',
            headers: {
        'Content-Type': 'application/json',
    },
    body: JSON.stringify({ nombreUsuario, contraseña }),
});
        const user = await response.json();
onLogin(user);
    };

            return (
        <form onSubmit={handleSubmit}>
            <div>
<label>Nombre de Usuario:</label>
                <input
type="text"
value={nombreUsuario}
onChange={(e) => setNombreUsuario(e.target.value)}
        />
            </div>
            <div>
                <label>Contraseña:</label>
                <input
type="password"
value={contraseña}
onChange={(e) => setContraseña(e.target.value)}
        />
            </div>
            <button type="submit">Login</button>
        </form>
        );
        }

export default LoginScreen;